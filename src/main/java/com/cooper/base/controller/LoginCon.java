package com.cooper.base.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cooper.common.shiro.token.UserToken;
import com.cooper.common.shiro.token.UserUtil;
import com.gonvan.kaptcha.Constants;
import com.gonvan.kaptcha.Producer;

/**  
 * Copyright © 2017 com. All rights reserved.
 *
 * @Title: LoginCOn.java
 * @Prject: springmvc-mybatis-shiro
 * @Package: com.cooper.base.controller
 * @Description: TODO
 * @author: JackCooperZ  
 * @date: 2017年1月17日 下午4:33:45
 * @version: V1.0  
 */
@Controller
public class LoginCon {

	private static Logger logger = LoggerFactory.getLogger(LoginCon.class);

	@Resource
	private Producer producer;

	/** 
	 * @Title: login 
	 * @Description: 跳转到登录页 GET
	 * @return  String ftl/login
	 * @throws 
	 */
	@RequestMapping(value="/login",method={RequestMethod.GET})
	public String login(){
		if(UserUtil.isLogin()){
			return "redirect:index";
		}
		return "ftl/login";
	}

	/** 
	 * @Title: login 
	 * @Description: 用户登录
	 * @param user
	 * @return     
	 * @throws 
	 */
	@RequestMapping(value = "/sys/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> login(UserToken user){
		Map<String,Object> res = new HashMap<String,Object>();
		//1.校验验证码
		String captcha = UserUtil.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
		if(!captcha.equalsIgnoreCase(user.getCaptcha())){
			res.put("msg", "验证输入错误");
			return res;
		}
		//2.通过shiro的login方法实现登录
		try{
			Subject subject = UserUtil.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
			if(user.getRememberMe() != null && "Y".equals(user.getRememberMe())){
				token.setRememberMe(true);    // 记住我     
			}
			subject.login(token);
		}catch (UnknownAccountException e) {
			res.put("msg", e.getMessage());
			return res;
		}catch (IncorrectCredentialsException e) {
			res.put("msg", e.getMessage());
			return res;
		}catch (LockedAccountException e) {
			res.put("msg", e.getMessage());
			return res;
		}catch (AuthenticationException e) {
			res.put("msg", "用户验证失败");
			return res;
		}catch(Exception e){
			res.put("msg", "网络异常，请稍后重试");
			return res;
		}
		//验证通过，从session中移除
		UserUtil.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);
		res.put("msg", "suc");
		return res;
	}
	
	@RequestMapping(value="/logout")
	public String logout(){
		UserUtil.logout();
		return "redirect:login";
	}

	/** 
	 * @Title: captcha 
	 * @Description: 获取验证码
	 * @param response
	 * @throws ServletException
	 * @throws IOException     
	 * @throws 
	 */
	@RequestMapping("captcha.jpg")
	public void captcha(HttpServletResponse response)throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");

		//生成文字验证码
		String text = producer.createText();
		//生成图片验证码
		BufferedImage image = producer.createImage(text);
		//保存到shiro session
		UserUtil.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
	}

	/** 
	 * @Title: unauth 
	 * @Description: 无权限跳转
	 * @return  String jsp/error/403.jsp   
	 * @throws 
	 */
	public String unauth(){
		return "jsp/error/403";
	}

}

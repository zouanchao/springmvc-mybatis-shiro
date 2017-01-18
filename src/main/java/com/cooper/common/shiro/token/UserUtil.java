package com.cooper.common.shiro.token;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.cooper.base.model.SysUser;

/**  
 * Copyright © 2017 com. All rights reserved.
 *
 * @Title: UserUtil.java
 * @Prject: springmvc-mybatis-shiro
 * @Package: com.cooper.common.shiro.token
 * @Description: Session用户工具类
 * @author: JackCooperZ  
 * @date: 2017年1月17日 下午6:05:40
 * @version: V1.0  
 */
public class UserUtil {

	/** 
	 * @Title: getSession 
	 * @Description: 获取Session
	 * @return     
	 * @throws 
	 */
	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	/** 
	 * @Title: getSubject 
	 * @Description: 获取当前操作用户
	 * @return     
	 * @throws 
	 */
	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	/** 
	 * @Title: getSysUser 
	 * @Description: 获取当前操作用户实际用户信息
	 * @return     
	 * @throws 
	 */
	public static SysUser getSysUser() {
		return (SysUser)SecurityUtils.getSubject().getPrincipal();
	}

	/** 
	 * @Title: getUserId 
	 * @Description: 获取当前操作用户实际用户ID
	 * @return     
	 * @throws 
	 */
	public static String getUserId() {
		return getSysUser().getUserId();
	}

	/** 
	 * @Title: setSessionAttribute 
	 * @Description: 在session添加属性元素
	 * @param key
	 * @param value     
	 * @throws 
	 */
	public static void setSessionAttribute(Object key, Object value) {
		getSession().setAttribute(key, value);
	}

	/** 
	 * @Title: getSessionAttribute 
	 * @Description: 根据key获取session属性元素
	 * @param key
	 * @return     
	 * @throws 
	 */
	public static Object getSessionAttribute(Object key) {
		return getSession().getAttribute(key);
	}

	/** 
	 * @Title: isLogin 
	 * @Description: 判断是否已经登录
	 * @return     
	 * @throws 
	 */
	public static boolean isLogin() {
		return SecurityUtils.getSubject().getPrincipal() != null;
	}

	/** 
	 * @Title: logout 
	 * @Description: 退出登录     
	 * @throws 
	 */
	public static void logout() {
		SecurityUtils.getSubject().logout();
	}

	/** 
	 * @Title: getKaptcha 
	 * @Description: 从session中获取验证码值
	 * @param key
	 * @return     
	 * @throws 
	 */
	public static String getKaptcha(String key) {
		String kaptcha = getSessionAttribute(key).toString();
		return kaptcha;
	}
}

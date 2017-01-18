package com.cooper.common.shiro.token;

import java.io.Serializable;

/**  
 * Copyright © 2017 com. All rights reserved.
 *
 * @Title: UsernamePasswordToken.java
 * @Prject: springmvc-mybatis-shiro
 * @Package: com.cooper.common.shiro.token
 * @Description: TODO
 * @author: JackCooperZ  
 * @date: 2017年1月17日 下午6:02:16
 * @version: V1.0  
 */
public class UserToken implements Serializable{

	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;
	
	private String username;//用户名
	
	private String password;//密码 
	
	private String captcha;//验证码
	
	private String rememberMe;//记住我
	
	public UserToken(){
		
	}
	
	public UserToken(String username,String password){
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}
	
	

}

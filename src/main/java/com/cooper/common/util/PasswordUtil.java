package com.cooper.common.util;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**  
 * Copyright © 2017 com. All rights reserved.
 *
 * @Title: PasswordUtil.java
 * @Prject: springmvc-mybatis-shiro
 * @Package: com.cooper.common.util
 * @Description: 用户密码工具类
 * @author: JackCooperZ  
 * @date: 2017年1月17日 下午5:52:20
 * @version: V1.0  
 */
public class PasswordUtil {

	/** 
	 * @Title: encrypt 
	 * @Description: 根据用户名和密码明文加密
	 * @param username 用户名
	 * @param express 密码明文
	 * @return String 加密后的密码 
	 * @throws 
	 */
	public static String encryptByUsername(String username,String express){
		String random = new SecureRandomNumberGenerator().nextBytes().toHex();
		String salt = username+random;
		String password = new SimpleHash("SHA-1", express, salt).toString();
		return password;
	}
	
	/** 
	 * @Title: encrypt 
	 * @Description: 根据密码明文和盐加密
	 * @param salt 盐
	 * @param express 密码明文
	 * @return String 加密后的密码 
	 * @throws 
	 */
	public static String encryptBySalt(String express,String salt){
		String password = new SimpleHash("SHA-1", express, salt).toString();
		return password;
	}

}

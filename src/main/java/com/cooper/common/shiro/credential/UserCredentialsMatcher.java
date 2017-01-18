package com.cooper.common.shiro.credential;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.util.ByteSource;

import com.cooper.common.util.PasswordUtil;

/**  
 * Copyright © 2017 com. All rights reserved.
 *
 * @Title: UserCredentialsMatcher.java
 * @Prject: springmvc-mybatis-shiro
 * @Package: com.cooper.common.shiro.credential
 * @Description: TODO
 * @author: JackCooperZ  
 * @date: 2017年1月17日 下午7:00:43
 * @version: V1.0  
 */
public class UserCredentialsMatcher extends HashedCredentialsMatcher{
	/**
	 * 重写的密码匹配方法
	 * 通过salt和得到的输入密码进行加密后得到的tokenHashedCredentials 与 real中传入的数据库密码  accountCredentials进行匹配
	 */
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,AuthenticationInfo info) {
		Object tokenHashedCredentials = hashProvidedCredentials(token, info);
		Object accountCredentials = info.getCredentials();
		return equals(tokenHashedCredentials, accountCredentials);
	}
	
	/**
	 * token中存放的有用户登录时候的信息
	 * token.getCredentials 得到是用户输入的密码
	 * info 存放的是从数据库查询到的用户信息 
	 */
	protected Object hashProvidedCredentials(AuthenticationToken token, AuthenticationInfo info) {
		Object salt = null;
		String password = new String((char[])token.getCredentials()); 
		if (info instanceof SaltedAuthenticationInfo) {
			salt = ((SaltedAuthenticationInfo) info).getCredentialsSalt();  
		} else { 
			if (isHashSalted()) {
				salt = getSalt(token);
			}
		} 
		return PasswordUtil.encryptBySalt(password,CodecSupport.toString(((ByteSource)salt).getBytes()));
	}  
}

package com.cooper.common.shiro.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.cooper.base.model.SysUser;
import com.cooper.base.service.SysUserService;
import com.cooper.common.shiro.token.UserToken;
import com.cooper.common.util.PasswordUtil;

/**  
 * Copyright © 2017 com. All rights reserved.
 *
 * @Title: UserRealm.java
 * @Prject: springmvc-mybatis-shiro
 * @Package: com.cooper.common.shiro
 * @Description: TODO
 * @author: JackCooperZ  
 * @date: 2017年1月17日 下午5:37:10
 * @version: V1.0  
 */
public class UserRealm extends AuthorizingRealm{
	
	@Resource 
	private SysUserService sysUserService;//用户信息操作接口
	
	/**
	 * 认证(登录时调用)
	 * 
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1.获取用户提交信息【用户名，密码】
		String username = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		SysUser record = new SysUser(username);
		//2.根据提交的用户名，从数据库中查询用户信息
		SysUser user = sysUserService.selectOne(record);
		//3.验证用户有效性
		if(user == null){//用户不存在
			throw new UnknownAccountException("账号或密码不正确");
		}
		//4.验证密码
		String credential = PasswordUtil.encryptBySalt(password, user.getSalt());
		if(!credential.equals(user.getPassword())){
			 throw new IncorrectCredentialsException("账号或密码不正确");
		}
		//5.验证账号状态，是否锁定，0：锁定，1：启用
		if(user.getStatus() == 0){
			throw new LockedAccountException("账号已被锁定,请联系管理员");
		}
		//6.返回验证信息
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(new UserToken(username,password), user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
		//SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),ByteSource.Util.bytes(user.getSalt()),getName());
		return info;
	}
	
	/**
	 * 授权(验证权限时调用)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}
	
	

	

}

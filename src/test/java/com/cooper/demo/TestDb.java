package com.cooper.demo;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cooper.base.model.SysUser;
import com.cooper.base.service.SysUserService;
import com.cooper.common.util.IdGen;
import com.cooper.common.util.PageUtil;

/**  
 * Copyright © 2017 com. All rights reserved.
 *
 * @Title: TestDb.java
 * @Prject: springmvc-mybatis-demo
 * @Package: com.cooper.demo
 * @Description: TODO
 * @author: JackCooperZ  
 * @date: 2017年1月16日 上午9:32:22
 * @version: V1.0  
 */
//引入Spring测试框架
@RunWith(SpringJUnit4ClassRunner.class)
//加载Spring配置文件
@ContextConfiguration(locations = {"classpath*:/spring.xml"})
public class TestDb {

	@Resource
	private SysUserService sysUserService;

	/** 
	 * @Title: testAdd 
	 * @Description: 添加用户     
	 * @throws 
	 */
	@Test
	public void testAdd(){

		String userId = IdGen.uuid();
		SysUser sysUser = new SysUser();
		sysUser.setCreateBy(userId);
		sysUser.setCreateDate(new Date());
		sysUser.setEmail("XXXXX@XXX.com");
		sysUser.setIsDelete("N");
		sysUser.setMobile("15888888888");
		//加密用shiro提供的散列算法
		String username = "test_001";  
		String pass_mingwen = "test_001";
		String random = new SecureRandomNumberGenerator().nextBytes().toHex();
		String salt = username+random;
		String password = new SimpleHash("SHA-1", pass_mingwen, salt).toString();
		sysUser.setPassword(password);
		//
		sysUser.setRealName("测试账号");
		sysUser.setRemarks("业精于勤");
		sysUser.setSalt(salt);
		sysUser.setStatus(1);//0：禁用，1：启用
		sysUser.setUpdateBy(userId);
		sysUser.setUpdateDate(new Date());
		sysUser.setUserId(userId);
		sysUser.setUsername(username);
		int m = sysUserService.save(sysUser);
		if(m==1){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
	}

	/** 
	 * @Title: testSelect 
	 * @Description: 查询用户     
	 * @throws 
	 */
	@Test
	public void testSelect(){
		SysUser tempUser = new SysUser();
		String username = "admin";  
		String pass_mingwen = "admin123";
		tempUser.setUsername(username);
		tempUser = sysUserService.selectOne(tempUser);
		if(tempUser!=null){
			System.out.println(tempUser.getPassword());
			System.out.println(tempUser.getSalt());
			String password = new SimpleHash("SHA-1", pass_mingwen, tempUser.getSalt()).toString();
			//密码比对
			System.out.println(password.equals(tempUser.getPassword()));
		}
	}

	/** 
	 * @Title: testSelectList 
	 * @Description: 查询多条记录     
	 * @throws 
	 */
	@Test
	public void testSelectList(){
		List<SysUser> uList = sysUserService.selectAll();
		for (SysUser sysUser : uList) {
			System.out.println(sysUser);
		}
	}

}

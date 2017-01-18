package com.cooper.base.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**  
 * Copyright © 2017 com. All rights reserved.
 *
 * @Title: UserCon.java
 * @Prject: springmvc-mybatis-shiro
 * @Package: com.cooper.base.controller
 * @Description: TODO
 * @author: JackCooperZ  
 * @date: 2017年1月17日 下午7:51:07
 * @version: V1.0  
 */
@Controller
@RequestMapping("/user")
public class UserCon {

	/** 
	 * @Title: list 
	 * @Description: TODO
	 * @return     
	 * @throws 
	 */
	@RequestMapping(value="/list",method={RequestMethod.GET})
	@RequiresRoles("admin")
	public String list(){
		return "ftl/user/list";
	}

}

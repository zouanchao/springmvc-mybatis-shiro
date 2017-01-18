package com.cooper.base.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**  
 * Copyright © 2017 com. All rights reserved.
 *
 * @Title: IndexCon.java
 * @Prject: springmvc-mybatis-shiro
 * @Package: com.cooper.base.controller
 * @Description: TODO
 * @author: JackCooperZ  
 * @date: 2017年1月17日 下午4:32:10
 * @version: V1.0  
 */
@Controller
public class IndexCon {
	
	private static Logger logger = LoggerFactory.getLogger(IndexCon.class);

	/** 
	 * @Title: toIndex 
	 * @Description: 跳转到首页
	 * @return String 首页地址 ftl/index    
	 * @throws 
	 */
	@RequestMapping(value="/index")
	public String toIndex(){
		return "ftl/index";
	}
	/** 
	 * @Title: toIndex 
	 * @Description: 跳转到首页
	 * @return String 首页地址 ftl/index    
	 * @throws 
	 */
	@RequestMapping(value="/welcome")
	public String welcome(){
		return "ftl/welcome";
	}

}

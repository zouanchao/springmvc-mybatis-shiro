package com.cooper.demo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gonvan.kaptcha.Producer;


/**  
 * Copyright © 2017 com. All rights reserved.
 *
 * @Title: TestOther.java
 * @Prject: springmvc-mybatis-shiro
 * @Package: com.cooper.demo
 * @Description: TODO
 * @author: JackCooperZ  
 * @date: 2017年1月17日 下午4:45:16
 * @version: V1.0  
 */
//引入Spring测试框架
@RunWith(SpringJUnit4ClassRunner.class)
//加载Spring配置文件
@ContextConfiguration(locations = {"classpath*:/spring.xml"})
public class TestOther {
	
	@Resource
	private Producer producer;
	
	@Test
	public void testGeneratorImg(){
		//生成文字验证码
	    String text = producer.createText();
	    System.out.println(text);
	    //生成图片验证码
	    BufferedImage image = producer.createImage(text);
	    //
	    try {
			ImageIO.write(image, "png", new File("D:\\test.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}

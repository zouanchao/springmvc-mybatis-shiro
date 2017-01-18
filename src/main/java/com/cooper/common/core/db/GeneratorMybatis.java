package com.cooper.common.core.db;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cooper.common.util.LoadPropertiesUtil;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * Copyright © 2016parim. All rights reserved.
 * @Title: GeneratorMybatis.java
 * @Prject: mybatis-spring
 * @Package: com.isea533.mybatis.util
 * @Description: MyBatis 通用Mapper的Generator 生成Dao、Mapper、Mapper.xml配置文件 工具类
 * @author: Administrator  
 * @date: 2016年6月1日 上午9:01:04
 * @version: V1.0  
 */
public class GeneratorMybatis {

	public static void main(String[] args) {
		generator(); 
	}

	/**
	 * @author: jackCooperZ
	 * @Title: generator
	 * @Description: Mapper生成工具类
	 * @return: void
	 */
	public static void generator(){
		/*生成异常信息*/
		List<String> warnings = new ArrayList<String>();
		/*是否覆盖已有*/
		boolean overwrite = false;
		/*生成新配置解析器*/
		ConfigurationParser cp = new ConfigurationParser(warnings);
		try {
			//修改生成表的路径和表
			boolean tb_md =  LoadPropertiesUtil.changeValueByPropertyName("db.properties", "generator.javaModel", "com.cooper.base.model");
			boolean tb_mp =  LoadPropertiesUtil.changeValueByPropertyName("db.properties", "generator.javaMap", "com.cooper.base.mapping");
			boolean tb_do =  LoadPropertiesUtil.changeValueByPropertyName("db.properties", "generator.javaDao", "com.cooper.base.dao");
			boolean tb_f = LoadPropertiesUtil.changeValueByPropertyName("db.properties", "generator.tableName", "%");
			//如果生成的
			if(tb_md&&tb_mp&&tb_do&&tb_f){
				/*配置文件路径*/
				String filePath = Test.class.getClassLoader().getResource("generatorConfig.xml").getPath();
				File configFile = new File(filePath);
				//读取配置文件
				Configuration config = cp.parseConfiguration(configFile);
				DefaultShellCallback callback = new DefaultShellCallback(overwrite);
				/*生成器*/
				MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
				myBatisGenerator.generate(null);
				System.out.println("*******************************************************");
				System.out.println(" End Generator !\n Result:Generator Success,Please refresh your project!");
				System.out.println("*******************************************************");
				if(warnings!=null&&warnings.size()>0){
					System.out.println("WARN INFO：");
					for (String str : warnings) {
						System.out.println(str);
					}
				}
			}
		} catch (IOException e) {
			System.out.println("message:generatorConfig.xml 文件不存在，请确定文件路径");
			e.printStackTrace();
		} catch (XMLParserException e) {
			System.out.println("generatorConfig.xml 配置文件出现异常，请核对配置文件");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("发生异常，生成文件失败");
			e.printStackTrace();
		}
	}
}

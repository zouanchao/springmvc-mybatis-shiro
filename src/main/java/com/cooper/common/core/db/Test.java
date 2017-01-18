package com.cooper.common.core.db;

import java.io.File;

/**
 * Copyright © 2016  All rights reserved.
 *
 * @Title: Test
 * @Prject: springmvc-mybatis-demo
 * @Package: com.cooper.common.core.db
 * @Description: TODO
 * @author: JackCooperZ
 * @date: 2017/1/15 0015 下午 6:04
 * @version: V1.0
 */
public class Test {

    public  static void main(String[] args){
        String filePath = Test.class.getClassLoader().getResource("generatorConfig.xml").getPath();
        File file = new File(filePath);
        System.out.println(file);
    }
}

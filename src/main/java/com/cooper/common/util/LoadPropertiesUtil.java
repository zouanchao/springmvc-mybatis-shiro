package com.cooper.common.util;

import org.mybatis.generator.config.Configuration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/** 
* @ClassName: OperatePropertiesFile 
* @Description: 属性文件操作
* @author JackCooperZ
* @date 2016年11月22日 下午2:10:30 
*  
*/
public class LoadPropertiesUtil {
	
	public LoadPropertiesUtil(){
		super();
	}
	 
	/**
     * @description 采用Properties类取得属性文件对应值
     * @param propertiesFileName properties文件名，如a.properties
     * @param propertyName 属性名
     * @return 根据属性名得到的属性值，如没有返回""
     */
    public static String getValueByPropertyName(String propertiesFileName,String propertyName) {
        String s="";
        Properties p=new Properties();//加载属性文件读取类
        InputStream in;
        try {
        	ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        	//以流的形式读取属性文件
        	in = classloader.getResourceAsStream(propertiesFileName);
            p.load(in);//属性文件将该流加入的可被读取的属性中
            in.close();//读完了关闭
            s=p.getProperty(propertyName);//取得对应的属性值
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    
    /**
     * @description 更改属性文件的值，如果对应的属性不存在，则自动增加该属性
     * @param propertiesFileNameproperties文件名，如a.properties
     * @param propertyName属性名
     * @param propertyValue将属性名更改成该属性值
     * @return 是否操作成功
     */
    public static boolean changeValueByPropertyName(String propertiesFileName,String propertyName,String propertyValue) {
        boolean writeOK=true;
        Properties p=new Properties();
        InputStream in;
        try {
        	ClassLoader classloader = Thread.currentThread().getContextClassLoader();
         	//以流的形式读取属性文件
         	in = classloader.getResourceAsStream(propertiesFileName);
            p.load(in);//
            in.close();
            p.setProperty(propertyName,propertyValue);//设置属性值，如不属性不存在新建
            String path = LoadPropertiesUtil.class.getResource("/").getPath()+propertiesFileName;
        	FileOutputStream out = new FileOutputStream(path);
            p.store(out,"");//设置属性头，如不想设置，请把后面一个用""替换掉
            out.flush();//清空缓存，写入磁盘
            out.close();//关闭输出流
        } catch (Exception e) {
            e.printStackTrace();
        }
        return writeOK;
    }
    
    public static void main(String[] args) {
    	/*String tb = LoadPropertiesUtil.getValueByPropertyName("db.properties", "generator.tableName");
    	System.out.println(tb);*/
        new LoadPropertiesUtil().test();
	}

	public  void test(){
       URL  url =  this.getClass().getResource("/generatorConfig.xml");
        System.out.println(url.toString());
        File configFile = new File(url.toString());
        System.out.println(configFile);
    }

}

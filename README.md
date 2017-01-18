基于Spingmvc+MyBatis+shiro+通用mapper集成的简单DEMO

### 项目框架
[Spring 4.1.7.RELEASE](http://maven.springframework.org/release/org/springframework/spring/4.1.7.RELEASE/)
[MyBatis 3.2.8](https://github.com/mybatis/mybatis-3)
[Shiro 1.2.3](http://shiro.apache.org/download.html)
[通用Mapper](https://github.com/abel533/Mapper)
[前端框架 AdminLTE](https://www.almsaeedstudio.com/themes/AdminLTE/documentation/index.html)

### 开发环境要求
[JDK 1.7+](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
[MySQL数据库，我使用的是MySQL 5.7](https://dev.mysql.com/downloads/mysql/)
[Maven 3.3.9](http://maven.apache.org/download.cgi)
[IDE 我用的Idea，当然也可以用Eclipse](http://www.jetbrains.com/idea/)
[Tomcat 7+（我用的tomcat7）](http://tomcat.apache.org/download-70.cgi)


### 项目使用步骤
1.将doc文件夹中的创建库和建表语句放到MySQL中执行，初始化表结构及基础表数据

2.用Idea创建项目，选择从Git创建，就可以直接将项目导入到Idea中;
如果你是Eclipse工具，也可以先将项目下载到本地，然后导入即可

3.修改数据库连接，如下图：修改db.properties属性文件中数据库连接参数，设置成你自己的即可
![数据库连接配置](http://git.oschina.net/uploads/images/2017/0118/095033_3967cddb_614740.png "在这里输入图片标题")

4.将项目部署到tomcat中，启动tomcat即可

测试地址：http://localhost:8080/springmvc-mybatis-shiro 测试账号： 用户名 admin 密码 admin123 
因为现在只是整合了Shiro登录，还未做权限管理等，功能较少，后期慢慢完善，fighting


### 运行效果
**1.登录页** 
![登录页](http://git.oschina.net/uploads/images/2017/0118/095513_885c0c5e_614740.png "登录页")

**2.后台首页**
![后台首页](http://git.oschina.net/uploads/images/2017/0118/095948_6ae5f7a7_614740.png "后台首页")

**3.无权限访问页**
![无权限访问页](http://git.oschina.net/uploads/images/2017/0118/100100_191041e9_614740.png "无权限访问页")




### 附1:通用Mapper链接地址
http://git.oschina.net/free/Mapper/blob/master/wiki/mapper3

### 附2：分页插件链接地址
https://github.com/pagehelper/Mybatis-PageHelper

### 附3：Generator 链接地址
http://git.oschina.net/free/Mybatis_Utils/blob/master/MybatisGeneator/MybatisGeneator.md


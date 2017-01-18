<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="<%=basePath %>">
    <meta charset="UTF-8">
    <!-- 优先使用 IE 最新版本和 Chrome -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge" >
    <!-- 为移动设备添加 viewport -->
    <meta name="viewport" content="initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
    <!-- 忽略页面中的数字识别为电话，忽略email识别 -->
    <meta name="format-detection" content="telphone=no, email=no" >
    <title>SSM基础DEMO</title>
    <!-- Favicons-->
    <link rel="apple-touch-icon" href="static/common/images/apple-touch-icon.png">
    <link rel="icon" href="static/common/images/favicon.ico">
    <link rel="stylesheet" href="static/bootstrap-3.3.6-dist/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
    <div class="page-header">
        <div>
            你好909234324
        </div>
    </div>
</div>
</body>
</html>

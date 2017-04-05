<%@ page import="com.codingvictor.newhope.constant.Global"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.google.gson.JsonObject" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>管理主页</title>
  <link rel="stylesheet" type="text/css" href="../css/bootstrap4.css" />
  <link rel="stylesheet" type="text/css" href="../css/main.css" />
  <style>
    span {
      color: white;
    }
    .btn {
      width: 300px;
      margin-top: 20px;
      margin-left: 40px;
    }
  </style>
</head>

<body>
<%  
    JsonObject staff = (JsonObject)session.getAttribute(Global.Staff_SESSION_KEY); 

%>
<div class="jumbotron">
  <h1 class="display-3">Hello, <%= staff.get("familyName").getAsString() + staff.get("givenName").getAsString() %>!</h1>
  <p class="lead">作为全世界最伟大的污水处理公司的管理人员，相信你对自己的重要性感到很骄傲</p>
  <hr class="my-4">
  <p>但权利有多大责任也有多大，请谨慎下面的操作，以保证不对公司的数据产生不良影响，如发现系统出现什么错误，请联系系统开发者</p>
  <p class="lead" class="white">
    <a class="btn btn-primary btn-lg" href="#" role="button"><span>修改雇员信息</span></a>
    <a class="btn btn-primary btn-lg" href="#" role="button"><span>新增公司动态</span></a>
    <a class="btn btn-primary btn-lg" href="#" role="button"><span>修改公司动态</span></a>
    <a class="btn btn-primary btn-lg" href="#" role="button"><span>新增最新产品信息</span></a>
    <a class="btn btn-primary btn-lg" href="#" role="button"><span>修改最新产品信息</span></a>
  </p>
</div>
</body>
</html>
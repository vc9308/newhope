<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>注册用户</title>
  <link rel="stylesheet" type="text/css" href="../css/bootstrap4.css" />
  <link rel="stylesheet" type="text/css" href="../css/main.css" />
  <script src="../js/angular.min.js"></script>
  <style>
      .error {
        text-align: center;
        color: red;
      }
  </style>
</head>
<body>
  <br />
  <div class="container">
    <form class="form" action="<st:url value="/user/doRegister"></st:url>" method="post" ng-app="">
      <% String email = (String) request.getAttribute("email");
         String familyName = (String) request.getAttribute("familyName");
         String givenName = (String) request.getAttribute("givenName");
         String birthYear = (String) request.getAttribute("birthYear");
         String password = (String) request.getAttribute("password");
         String confirm = (String) request.getAttribute("confirm");
         String phoneNumber = (String) request.getAttribute("phoneNumber");
         String country = (String) request.getAttribute("country");
         String province = (String) request.getAttribute("province");  
         %>
      <h2>用户注册</h2><br />
      <div class="form-group">
        <input name="email" class="form-control" placeholder="邮箱"
        <% if(email != null) out.print("value=\"" + email + "\"");%>
          autofocus />
        <div class="form-control-feedback">${ERR_email }</div>
      </div>
      <div class="form-group <% if(familyName != null) out.print("has-danger"); %>">
        <input name="familyName" class="form-control" placeholder="姓"
          <% if(familyName != null) out.print("value=\"" + familyName + "\"");%> />
          <div class="form-control-feedback">${ERR_familyName }</div>
      </div>
      <div class="form-group <% if(givenName != null) out.print("has-danger"); %>">
        <input name="givenName" class="form-control" placeholder="名"
          <% if(givenName != null) out.print("value=\"" + givenName + "\"");%> />
          <div class="form-control-feedback">${ERR_givenName }</div>
      </div>
      <div class="form-group <% if(birthYear != null) out.print("has-danger"); %>">
        <input type="number" name="birthYear" class="form-control"
          min="1900" max="2005" placeholder="出生年份"
          <% if(birthYear != null) out.print("value=\"" + birthYear + "\"");
          else out.print("value=\"" + birthYear + "\"");
          %> />
          <div class="form-control-feedback">${ERR_birthYear }</div>
      </div>
      <div class="form-group <% if(password != null) out.print("has-danger"); %>">
        <input type="password" name="password" class="form-control" placeholder="密码"
          <% if(password != null) out.print("value=\"" + password + "\"");%> />
          <div class="form-control-feedback">${ERR_password }</div>
      </div>
      <div class="form-group <% if(confirm != null) out.print("has-danger"); %>">
        <input type="password" name="confirm" class="form-control" placeholder="请再确认一次"
          <% if(confirm != null) out.print("value=\"" + confirm + "\"");%> />
          <div class="form-control-feedback">${ERR_confirm }</div>
      </div>
      <div class="form-group <% if(country != null) out.print("has-danger"); %>">
        <input name="country" class="form-control" placeholder="所在国家或地区"
          <% if(province != null) out.print("value=\"" + province + "\"");%> />
          <div class="form-control-feedback">${ERR_country }</div>
      </div>
      <div class="form-group <% if(province != null) out.print("has-danger"); %>">
        <input name="province" class="form-control" placeholder="所在地省份"
          <% if(province != null) out.print("value=\"" + province + "\"");%> />
          <div class="form-control-feedback">${ERR_province }</div>
      </div>
      <div class="form-group <% if(phoneNumber != null) out.print("has-danger"); %>">
        <input name="phoneNumber" class="form-control" placeholder="电话号码"
          <% if(phoneNumber != null) out.print("value=\"" + phoneNumber + "\"");%> />
          <div class="form-control-feedback">${ERR_phoneNumber }</div>
      </div>
      <input class="btn btn-lg btn-primary btn-block" type="submit" value="注册" /><br />
      <div class="error">${error }</div>
  </form>
  </div>
  ${error }
</body>
</html>
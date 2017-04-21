<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>登录用户</title>
  <link rel="stylesheet" type="text/css" href="../css/bootstrap4.css" />
  <link rel="stylesheet" type="text/css" href="../css/main.css" />
  <link rel="icon" href="../icon/new_hope_icon_30x30.png" />
  <style>
      .error {
        text-align: center;
        color: red;
      }
  </style>
</head>
<body>
  <br /><br />
  <div class="container">
    <form class="form" action="<st:url value="/administrator/doLogin"></st:url>" method="post">
      <% String email = (String) request.getAttribute("email"); %>
      <h2>用户登录</h2><br />
      <div class="form-group
      <% if (request.getAttribute("error") != null)
           out.print("has-danger");
      %>">
        <input name="email" class="form-control" placeholder="邮箱"
          <% if(email != null) out.print("value=\"" + email + "\"");%>
            autofocus />
      </div>
      <div class="form-group
      <%
         if (request.getAttribute("error") != null)
           out.print("has-danger");
      %>">
        <input type="password" name="password" class="form-control" placeholder="密码" />
      </div>
      <input class="btn btn-lg btn-primary btn-block" type="submit" value="登录" /><br />
      <div class="error">${error }</div><br>
      <div style="text-align: center; font-size: small;"><a href="./findPassword">找回密码</a></div>
      <br />
      <div style="text-align: center; font-size: small;"><a href="../staff/register">注册用户</a></div>
  </form>
  </div>
</body>
</html>
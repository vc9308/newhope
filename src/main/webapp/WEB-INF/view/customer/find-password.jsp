<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>找回密码</title>
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
  <br /><br />
  <div class="container">
    <form class="form" action="<st:url value="/user/doFindPassword"></st:url>" method="post" ng-app="">
      <% String email = (String) request.getAttribute("email");
         %>
      <h2>找回密码</h2><br />
      <div class="form-group">
        <input name="email" class="form-control" placeholder="邮箱"
        <% if(email != null) out.print("value=\"" + email + "\"");%>
          autofocus /><br />
        <div class="form-control-feedback">${ERR_email }</div>
      </div>
      <input class="btn btn-lg btn-primary btn-block" type="submit" value="找回密码" /><br />
      <div class="error">${error }</div>
  </form>
  </div>
  ${error }
</body>
</html>
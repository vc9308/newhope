<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="../css/bootstrap4.css" />
  <link rel="stylesheet" type="text/css" href="../css/main.css" />
  <title>发表动态</title>
  <style>
    .error {
      text-align: center;
      color: red;
    }
  </style>
</head>
<body>
  <br>
  <div class="container">
    <form class="form" action="<st:url value="/activities/doPublish"></st:url>" method="post">
      <% String heading = (String)request.getAttribute("heading");
         String content = (String)request.getAttribute("content");
         String author = (String) request.getAttribute("author");%>
      <h2>发表动态</h2><br />
      <div class="form-group">
        <input name="author" class="form-control" placeholder="作者"
        <% if(author != null) out.print("value=\"" + author + "\"");%>
        required autofocus />
      </div>
      <div class="form-group <% if(heading != null) out.print("has-danger"); %>">
        <input name="heading" class="form-control" placeholder="标题"
          <% if(heading != null) out.print("value=\"" + heading + "\"");%> required />
      </div>
      <div class="form-group <% if(content != null) out.print("has-danger"); %>">
        <textarea name="content" class="form-control" rows="7" placeholder="内容" required
        ><% if(content != null) out.print(content);%></textarea><br>
      </div>
      <input class="btn btn-lg btn-primary btn-block" type="submit" value="发表" /><br />
      <a class="btn btn-lg btn-danger btn-block center" style="color: white;"
        href="/latest-products/doDelete">删除</a>
      <div class="error">${error }</div>
  </form>
  </div>
</body>
</html>
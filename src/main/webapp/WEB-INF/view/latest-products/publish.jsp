<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="icon" href="../icon/new_hope_icon_30x30.png" />
  <link rel="stylesheet" type="text/css" href="../css/bootstrap4.css" />
  <link rel="stylesheet" type="text/css" href="../css/main.css" />
  <title>发表最新产品信息</title>
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
    <form class="form" 
    action="<st:url value="/latest-products/doPublish"></st:url>" method="post">
      <% String heading = (String) request.getAttribute("heading");
         String content = (String) request.getAttribute("content");
         String author = (String) request.getAttribute("author");
         %>
      <h2>发表最新产品信息</h2><br />
      <div class="form-group">
        <input name="author" class="form-control" placeholder="作者"
        <% if(author != null) out.print("value=\"" + author + "\"");%>
        required autofocus />
      </div>
      <div class="form-group <% if(heading != null) out.print("has-danger"); %>">
        <input name="heading" class="form-control" placeholder="产品名称"
          <% if(heading != null) out.print("value=\"" + heading + "\"");%> required />
        <small class="form-text text-muted">&nbsp;请用"&lt;br /&gt;"把类型和型号隔开</small>
      </div><br />
      <div class="form-group <% if(content != null) out.print("has-danger"); %>">
        <textarea name="content" class="form-control" rows="7" placeholder="介绍" required
        ><% if(content != null) out.print(content);%></textarea><br>
      </div>
      <input class="btn btn-lg btn-primary btn-block" type="submit" value="发表" /></br>
      <div class="error">${error }</div>
  </form>
  </div>
</body>
</html>
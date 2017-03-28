<%@ page import="com.codingvictor.newhope.common.ActivityPage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <meta charset="UTF-8">
  <title>所有最新动态</title>
  <link rel="stylesheet" type="text/css" href="../css/bootstrap4.css" />
  <link rel="stylesheet" type="text/css" href="../css/bootstrap3.css" />
  <link rel="stylesheet" type="text/css" href="../css/main.css" />
  <style>
    .card:hover {
      color: red;
      border: solid red 5px;
      cursor: pointer;
      font-size: 96%; 
    }
  </style>
</head>
<body>
  <div class="activities" style="width: 100%;">
    <br /><br />
	<h3 style="position: absolute; left: 30px;">选择要修改的最新动态</h3>
	<div class="card-block" style="padding-top: 50px;" id="c-b1">
	  <div class="container-fluid">
	    <div class="row">
	      <c:forEach items="${ActivityItems.data }" var="item">
		    <a href="update?id=${item.id }" class="row1 col-xs-6 col-sm-6 col-md-4 col-lg-3">
		      <div class="card card- h-100">
		        <div class="card-header">
		          <h5 class="card-title">${item.heading }</h5>
		        </div>
		        <div class="card-block">
		        <p><img src="../pictures/latest-products/${item.id }.jpg" class="img-fluid mx-auto" /></p>
		        <p class="text-left lead2"></p>
			      ${item.content }
		        </div>
	          </div>
	        </a>
		  </c:forEach>
		</div>
	  </div>
	</div>
  </div>
  <%			
    ActivityPage activityPage = (ActivityPage) request.getAttribute("ActivityItems");
	int currPage = activityPage.getCurrPage();
	int totalPage = activityPage.getTotalPage();
  %>
  <br />
  <nav class="center-without-width" aria-label="">
    <ul class="pagination">
      <li class="page-item disabled">
        <a class="page-link" tabindex="-1" href="/activity/more?page=<%= currPage - 1 %>">上一页</a>
      </li>
	  <%
	  for (int i = 1; i <= totalPage; i ++) {
	    if (i == currPage) {
	  %>
      <li class="page-item active">
        <a class="page-link" href="#"><%=currPage %><span class="sr-only">(current)</span></a>
      </li>
      <%
	    } else {
      %>
      <li class="page-item"><a class="page-link" href="/activity/more?page=<%=i %>"><%=i %></a></li>
      <%
	    }
	  }
	  %>
      <li class="page-item">
        <a class="page-link" href="/activity/more?page=<%= currPage + 1 %>">下一页</a>
      </li>
    </ul>
  </nav>
</body>
</html>
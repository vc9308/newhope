<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <title>客服系统</title>
  <link rel="stylesheet" href="../css/bootstrap.min.css">
  <style>
    .container {
      
    }
    .history {
      border: 1px solid black;
      width: 500px;
      height: 300px;
      overflow-x: hidden; /* Hide horizontal scrollbar */
      overflow-y: scroll; /* Add vertical scrollbar */
      margin-top: 20px;
     }
    .dialog-box {
      border: 1px solid black;
      width: 500px;
      height: 100px;
      overflow-x: hidden; /* Hide horizontal scrollbar */
      overflow-y: hidden; /* Hide vertical scrollbar */
      margin-top: 5px;
    }
    .send-btn {
      position: relative;
      top: -20px;
      left: -78px;
    }
  </style>
  <script src="../js/html5shiv.js"></script>
  <script src="../js/jquery-2.2.4.min.js"></script>
  <script src="../js/angular.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
  <script>
  function send() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
		alert(this.readyState + "\n" + this.status);
	    if (this.readyState == 4 && this.status == 200) {
	     document.getElementById("demo").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "ajax_info.txt", true);
	  xhttp.send();
	}
  </script>
</head>

<body>
  <div class="container">
    <div class="history"></div>
    <textarea class="dialog-box"></textarea>
    <button class="btn btn-success send-btn" type="button" onclick="send()">send</button>
  </div>
  <div id="demo"></div>
</body>
</html>
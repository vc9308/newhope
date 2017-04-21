<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>气体控制</title>
  <link rel="icon" href="../icon/new_hope_icon_30x30.png" />
  <link rel="stylesheet" type="text/css" href="../css/bootstrap4.css" />
  <link rel="stylesheet" type="text/css" href="../css/main.css" />
  <style>
    article {
      margin-top: 20px;
      margin-left: 2%;
      margin-right: 2%;
    }
  </style>
</head>
<body>
  <header class="slogan-logo" style="text-align:center;">
    <img alt="New Hope Big Logo" src="../logo/new-hope-logo-original.png"/>
  </header>
  <div class="nav">
    <ul>
      <li><a class="active" href="<st:url value="/index"></st:url>" style="padding-left: 23px;">主页</a></li>
      <li><a href="<st:url value="/products"></st:url>">产品</a></li>
      <li class="my-dropdown">
        <a href="#" class="dropbtn dropdown-toggle">服务<span class="caret"></span></a>
        <div class="dropdown-content">
          <a href="<st:url value="/service/water-treatment"></st:url>">水处理</a>
          <a href="<st:url value="/service/foam-control"></st:url>">泡沫控制</a>
          <a href="<st:url value="/service/microbe-control"></st:url>">微生物控制</a>
          <a href="<st:url value="/service/cleaning"></st:url>">清洁清洗</a>
          <a href="<st:url value="/service/gas-control"></st:url>">气体控制</a>
        </div>
      </li>
      <li><a href="<st:url value="/industry-dynamics"></st:url>">行业动态</a></li>
      <li><a href="<st:url value="/documents"></st:url>">文献</a></li>
      <li><a href="<st:url value="/contacts"></st:url>">联系</a></li>
      <li class="my-dropdown">
        <a href="#" class="dropbtn dropdown-toggle">用户入口<span class="caret"></span></a>
        <div class="dropdown-content">
          <a href="<st:url value="/administrator/home"></st:url>">管理员</a>
          <a href="<st:url value="/customer/home"></st:url>">顾客</a>
          <a href="<st:url value="/staff/home"></st:url>">雇员</a>
        </div>
      </li>
    </ul>   
  </div>
  <article class="service-list">
    <ul>
      <li>酸性气体吸收和抑制方面：硝酸/盐酸/铬酸等方面；<br />&nbsp;
      <li>碱性气体吸收和抑制方面：有机/无机碱等方面的控制；<br />&nbsp;
      <li>除臭方面：固体/液体方面，主要用于垃圾处理和土壤改良方面；<br />&nbsp;
      <li>日用方面：甲醛去除，异味控制方面；<br />&nbsp;
    </ul>
  </article>
  <div class="footer">
    <div class="content fade-in-1500ms">
      <div style="width: 33.33%; float: left;">
        <img class="footer-logo" src="<st:url value="/logo/New_Hope_Logo_bandw.png"></st:url>">
      </div>
      <div class="column-1" style="float: left; text-align: left;">
        <img class="footer-logo-mobile" src="<st:url value="/logo/New_Hope_Logo_bandw.png"></st:url>">
        <a href="<st:url value="/team"></st:url>">团队</a><br />
        <a href="<st:url value="/sponsor"></st:url>">赞助商</a><br />
        <a href="<st:url value="/employ"></st:url>">加入我们</a><br />
        <a href="<st:url value="/faqs"></st:url>">FAQs</a><br />
      </div>
      <div class="column-2" style="width: 33.33%; float: left; text-align: left;">
        <a href="tel:+8602012345678">+86 (020) 12345678</a><br />
        <a href="mailto:vc93@icloud.com?Subject=Hellow%20again" target="_top">vc93@icloud.com</a><br />
        <a href="<st:url value="/privacyPolicy"></st:url>">隐私政策</a><br />
        <a href="<st:url value="/itemofuse"></st:url>">使用条款</a>
      </div>
    </div><br />&nbsp;
    <p class="copyright fade-in-1500ms">Designed and built with all the love in the world by Victor Chen (<a href="https://twitter.com/vc9308"> github</a> <a href="https://github.com/vc9308">twiiter</a> <a href="https://www.facebook.com/profile.php?id=100008310261533">facebook</a> ). Main blacktained by the core team with the help of our contributors.
    <br />本项目源码受 MIT开源协议保护，文档受 CC BY 3.0 开源协议保护。</p>
  </div>
</body>
</html>

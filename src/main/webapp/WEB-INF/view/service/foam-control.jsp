<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>泡沫控制</title>
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
  <article>
    <ul>
      <li>泡沫控方面：特点：A，消泡能力强；B,抑泡持久；C，对使用的工序无负作用。<br />&nbsp;
      <li>生化处理：无防腐杀菌等添加剂和无脱气的能力，利于其生化；无乳化功能，利于后续污泥脱水；其主成份为碳水化和物，利于生物降解。<br />&nbsp;
      <li>石化行业：石化的工序多，各自要求不一致，根据其使用环节的特点，提供相适应的产品和使用方案。<br />&nbsp;
      <li>煤化行业：主要服务于煤气化和焦化行业，根据水质的变化，提供其消抑能力好，脱气能力强，利于后续水质净化的相关产品。<br />&nbsp;
      <li>盐化和磷化行业：高盐度和强酸条件下，其泡沫层含有大量的悬浮物，在控制泡沫的同时，还要满足其絮凝的效果。<br />&nbsp;
      <li>清洗方面：无泡和低泡清洗方面，分别适用于乳液型和非乳液型；强酸，强碱型；表面活性剂复配型。适用的操作温度-10°C~190°C；高压喷淋和高速搅拌。满足其罐装和连续生产的需要。<br />&nbsp;
      <li>发醇方面：安全，无毒负作用，超强的抑泡能力。对生化无影响。<br />&nbsp;
      <li>电子工业方面：碱性方面的泡沫控制，要求其水洗性和兼容性很好，不能有残留物方面的影响。<br />&nbsp;
      <li>建材方面：主要是对不同体系的减水剂有泡沫控制能力，不但能消泡和抑泡，同时要求控制泡沫的大小，对后混凝土的强度不能有影响。<br />&nbsp;
      <li>日化方面：安全，对人体的亲和性好，对环境要友好，控制泡沫的同时，具有一定的清洗能力。<br />&nbsp;
      <li>其它方面：农药生产，生物制药，水处理等方面泡沫的控制。<br />&nbsp;
      <li>有自己的分析泡沫的能力和仪器，提供专业的泡沫控制方案。<br />&nbsp;
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
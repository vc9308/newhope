<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="st" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <title>新希望污水处理公司官网</title>
  <meta charset="UTF-8" />
  <meta name="author" content="Victor Chen" />
  <meta name="description" content="新希望污水处理公司官网" />
  <meta name="keywords"
  content="新希望污水处理公司,新希望污水处理,新希望,污水处理,环保,绿色,污水" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0 /">
  <link rel="icon" href="icon/new_hope_icon_30x30.png" />
  <link rel="stylesheet" type="text/css" href="css/bootstrap4.css" />
  <link rel="stylesheet" type="text/css" href="css/bootstrap3.css" />
  <link rel="stylesheet" type="text/css" href="css/main.css" />
  <script src="js/html5shiv.js"></script>
  <script src="js/jquery-2.2.4.min.js"></script>
  <script src="js/bootstrap4.js"></script>
  <script src="js/bootstrap3.js"></script>
  <script src="js/newhope.js"></script>
</head>

<body>
<div class="page-wrapper">
  <div class="slogan-logo" style="text-align:center;">
    <img alt="New Hope Big Logo" src="logo/new-hope-logo-original.png"/>
  </div>
  	    <div class="nav">
    <ul>
      <li><a class="active" href="#home" style="padding-left: 23px;">主页</a></li>
      <li><a href="#">产品</a></li>
      <li class="my-dropdown">
        <a href="#" class="dropbtn dropdown-toggle">服务<span class="caret"></span></a>
        <div class="dropdown-content">
          <a href="service/water-treatment">水处理</a>
          <a href="service/foam-control">泡沫控制</a>
          <a href="service/microbe-control">微生物控制</a>
          <a href="service/cleaning">清洁清洗</a>
          <a href="service/gas-control">气体控制</a>
        </div>
      </li>
      <li><a href="#">行业动态</a></li>
      <li><a href="#">文献</a></li>
      <li><a href="customer-service/client">联系</a></li>
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
  <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
      <li data-target="#carousel-example-generic" data-slide-to="1"></li>
      <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>
    <!-- Wrapper for slides -->
    <div class="carousel-inner bold" role="listbox">
      <div class="item active">
        <img class="carousel-picture" id="carousel-picture-1" alt="First Slide">
        <div class="face">
          <div class="desc-background fade-in-1500ms-067" 
            style="background: white; right: 10%;">
            <div class="desc fade-in-3s">
              优质品牌：<br />Goldwell<br />Goldmater<br />点石安达</div>
          </div>
        </div>
      </div>
      <div class="item">
        <img class="carousel-picture" id="carousel-picture-2" alt="Second Slide">
        <div class="face">
          <div class="desc-background fade-in-1500ms-067"
            style="background: white; left: 15%;">
            <div class="desc fade-in-3s" style="color: black;">
              从始至终走绿色，科技，安全<br />的发展之路，一直致力于环境<br />保护和科技的相关领域。</div>
          </div>
        </div>
      </div>
      <div class="item">
        <img class="carousel-picture" id="carousel-picture-3" alt="Third Slide">
        <div class="face">
          <div class="desc-background fade-in-1500ms-067"
            style="background: black; right: 10%;">
            <div class="desc fade-in-3s" style="color: white">
              科研单位的加入 &nbsp;客户的认可<br />知名供应商支持 &nbsp; 高效的管理
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
      <span class="glyphicon glyphicon carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
      <span class="glyphicon glyphicon carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  <div class="activities">
    <br /><br />
    <h2 class="head text-center fade-in-1500ms">
      <img src="./pictures/animation/leaf.png">
      <img src="./pictures/animation/leaf-replacement.jpg" width="20" height="20">
        能提供稳定服务的企业一定生机勃勃
    </h2>
    <h5 class="text-center padding-top-5 fade-in-1500ms">我们公司的动态</h5>
    <hr class="half-rule">
    <div class="more-outer">
      <a class="more" style="top: -12px;" href="activities/more">更多</a>
    </div>
    <div class="card-block" id="c-b1" style="height:500px;overflow-y:scroll;">
      <div class="container-fluid">
        <div class="row">
        <c:forEach items="${ActivityItems.data }" var="item">
          <a href="" class="row1 col-xs-6 col-sm-6 col-md-4 col-lg-3">
            <div class="card card- h-100">
              <div class="card-header"><h5 class="card-title">${item.heading }</h5>
              </div>
              <div class="card-block"><p>
                <img
                 src="./pictures/activities/full/${item.id}.jpg"
                 class="img-fluid mx-auto" /></p><p class="text-left lead2"></p>
                 ${item.content }
              </div>
            </div>
          </a>
          </c:forEach>
        </div>
      </div>
    </div>
  </div>
  <div class="activities2next" onclick="jump_to_latest_products()">下部分</div>
  <div class="break" style="background-color: white; height:30px;"></div>
  <div id="latest-products" class="latest-products">
    <br />
    <h2 class="head text-center fade-in-1500ms">
      坚持推陈出新，是公司继续发展的原动力
      <img src="./pictures/animation/rocket.png">
      <img src="./pictures/animation/rocket-replacement.jpg" width="24" height="24">
    </h2>
    <h5 class="text-center padding-top-5 fade-in-1500ms">我们的最新产品</h5>
    <hr class="half-rule">
    <div class="more-outer">
      <a class="more" style="top: -12px;" href="latest-products/more">更多</a>
    </div>
    <div class="card-block" id="c-b2" style="height:500px;overflow-y:scroll;">
      <div class="container-fluid">
        <div class="row">
          <c:forEach items="${LatestProductItems.data }" var="item">
          <a href="" class="row1 col-xs-6 col-sm-6 col-md-4 col-lg-3">
            <div class="card card- h-100">
              <div class="card-header"><h5 class="card-title">${item.heading }</h5>
              </div>
              <div class="card-block"><p>
                <img
                 src="./pictures/latest-products/${item.id }.jpg"
                 class="img-fluid mx-auto" /></p><p class="text-left lead2"></p>
                 ${item.content }
              </div>
            </div>
          </a>
          </c:forEach>
        </div>
      </div>
    </div>
  </div>
  <div class="latest_products2next" onclick="jump_to_prospect()">下部分</div>
  <div class="break" style="background-color: #f1f1f1; height:30px;"></div>
  <div class="prospect bold" id="prospect">
    <br />
    <div class="container">
      <h2 class="text-center fade-in-1500ms">为想让城市更美好，乡村更美丽的人们</h2>
      <h5 class="text-center padding-top-5 fade-in-1500ms">新希望污水处理为所有城市污水处理项目提供完善、科技、快捷的产品和服务，
      以生态环境保护为目标，以社会经济发展为条件，以客户需求为基础。</h5>
      <hr class="half-rule">
      <div class="row">
        <div class="col-sm-4">
          <img src="./pictures/prospect1.png">
          <h3>利于缓解水资源短缺</h3>
          <p>水资源短缺已经成为制约很大地区社会经济发展的瓶颈。大力推进城市污水处理回用是缓解水资源短缺和建设节水型社会的重要手段，
          具有投资少、见效快等特点。</p>
        </div>
        <div class="col-sm-4">
          <img src="./pictures/prospect2.png">
          <h3>水资源的循环利用</h3>
          <p>世界淡水资源日趋短缺，为确保我们有足够水源配合可持续发展需要，节约用水、保护水资源及开发新水资源是十分重要的；
          其中「再造水」的使用，是一项意义重大的长远策略。</p>
        </div>
        <div class="col-sm-4">
          <img src="./pictures/prospect3.png">
          <h3>日益严重的污水</h3>
          <p>死亡有机质消耗水中溶解的氧气,危及鱼类的生存。绝大部分有机化学药品有毒性,它们进入江河湖泊会毒害或毒死水中生物,引起生态破坏。
          高含量的磷引起水中藻类疯长。</p>
        </div>
      </div>
    </div>
  </div>
  <div class="break" style="background-color: white; height:30px;"></div>
  <div class="successful-cases">
    <br />
    <h2 class="head text-center fade-in-1500ms bold">多少次的案例证明，选择我们一定是对的！</h2>
    <h5 class="head text-center
    padding-top-5 fade-in-1500ms bold">20多年来行业声誉是日积月累的经验的最好见证，一切都看得到也听得到</h5>
    <hr class="half-rule">
    <div class="more-outer">
        <a class="more" style="top: -25px; font-weight: normal;" href="activities/more">更多</a>
    </div>
    <div class="marquee bold">
  	  <div class="case-boxes">
      <div class="case-box">
        <a target="" href="./pictures/successful_case/1.jpg">
          <img src="./pictures/successful_case/1.jpg">
        </a>
        <div class="desc">深圳南山区华侨城水浸问题</div>
      </div>
      <div class="case-box">
        <a target="" href="./pictures/successful_case/2.jpg">
          <img src="./pictures/successful_case/2.jpg">
        </a>
        <div class="desc">Navenen 石材项目</div>
      </div>
      <div class="case-box">
        <a target="" href="./pictures/successful_case/3.jpg">
          <img src="./pictures/successful_case/3.jpg">
        </a>
        <div class="desc">广州番禺大学城项目</div>
      </div>
      <div class="case-box">
        <a target="" href="./pictures/successful_case/4.jpg">
          <img src="./pictures/successful_case/4.jpg">
        </a>
        <div class="desc">纽约长岛南部水污染处理</div>
      </div>
      <div class="case-box">
        <a target="" href="./pictures/successful_case/5.jpg">
          <img src="./pictures/successful_case/5.jpg">
        </a>
        <div class="desc">Kacca Vooce 石材项目</div>
      </div>
      <div class="case-box">
        <a target="" href="./pictures/successful_case/6.jpg">
          <img src="./pictures/successful_case/6.jpg">
        </a>
        <div class="desc">深圳岗厦地下水排放问题</div>
      </div>
      <div class="case-box">
        <a target="" href="./pictures/successful_case/7.jpg">
          <img src="./pictures/successful_case/7.jpg">
        </a>
        <div class="desc">波士顿常春藤周围污水处理</div>
      </div>
      <div class="case-box">
        <a target="" href="./pictures/successful_case/8.jpg">
          <img src="./pictures/successful_case/8.jpg">
        </a>
        <div class="desc">北京王府井地区污水处理</div>
      </div>
      <div class="case-box">
        <a target="" href="./pictures/successful_case/9.jpg">
          <img src="./pictures/successful_case/9.jpg">
        </a>
        <div class="desc">深圳白石州生活污水处理</div>
      </div>
  	  </div>
    </div>
  </div>
  <div class="break" style="background-color: #f1f1f1; height:30px;"></div>
  <div class="navbar navbar-default footer">
    <div class="content fade-in-1500ms">
      <div style="width: 33.33%; float: left;">
        <img class="footer-logo" src="logo/New_Hope_Logo_bandw.png">
      </div>
      <div class="column-1" style="float: left; text-align: left;">
        <img class="footer-logo-mobile" src="logo/New_Hope_Logo_bandw.png">
        <a href="team.html">团队</a><br />
        <a href="sponsor.html">赞助商</a><br />
        <a href="employ.html">加入我们</a><br />
        <a href="faqs.html">FAQs</a><br />
      </div>
      <div class="column-2" style="width: 33.33%; float: left; text-align: left;">
        <a href="tel:+8602012345678">+86 (020) 12345678</a><br />
        <a href="mailto:vc93@icloud.com?Subject=Hellow%20again" target="_top">vc93@icloud.com</a><br />
        <a href="privacyPolicy.html">隐私政策</a><br />
        <a href="itemofuse.html">使用条款</a>
      </div>
    </div><br />
    <p class="copyright fade-in-1500ms">Designed and built with all the love in the world by Victor Chen (<a href="https://twitter.com/vc9308"> github</a> <a href="https://github.com/vc9308">twiiter</a> <a href="https://www.facebook.com/profile.php?id=100008310261533">facebook</a> ). Main blacktained by the core team with the help of our contributors.
    <br />本项目源码受 MIT开源协议保护，文档受 CC BY 3.0 开源协议保护。</p>
  </div>
</div>
</body>
</html>
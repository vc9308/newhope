<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>注册用户</title>
  <link rel="icon" href="../icon/new_hope_icon_30x30.png" />
  <link rel="stylesheet" type="text/css" href="../css/bootstrap4.css" />
  <link rel="stylesheet" type="text/css" href="../css/main.css" />
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
    <form class="form" action="<st:url value="/customer/doRegister"></st:url>" method="post">
      <% String email = (String) request.getAttribute("email");
         String familyName = (String) request.getAttribute("familyName");
         String givenName = (String) request.getAttribute("givenName");
         String phoneNumber = (String) request.getAttribute("phoneNumber");
         String countryStr = (String) request.getAttribute("country");
         String provinceStr = (String) request.getAttribute("province");
         String companyName = (String) request.getAttribute("companyName");
         String companyTypeStr = (String) request.getAttribute("companyType");
         String genderStr = (String) request.getAttribute("gender");
         String[] COMPANY_TYPE = com.codingvictor.newhope.constant.ParamArray.COMPANY_TYPE;
         String[] GENDER = com.codingvictor.newhope.constant.ParamArray.GENDER;
         String[] COUNTRY = com.codingvictor.newhope.constant.ParamArray.COUNTRY;
         String[] PROVINCE_OF_CHINA = com.codingvictor.newhope.constant.ParamArray.PROVINCE_OF_CHINA;
         %>
      <h2>用户注册</h2><br />
      <div class="form-group <% if(request.getAttribute("ERR_email") != null) out.print("has-danger"); %>">
        <input name="email" class="form-control" placeholder="邮箱"
        <% if(email != null) out.print("value=\"" + email + "\"");%>
          autofocus />
        <div class="form-control-feedback">${ERR_email } &nbsp;</div>
      </div>
      <div class="form-group <% if(request.getAttribute("ERR_familyName") != null) out.print("has-danger"); %>">
        <input name="familyName" class="form-control" placeholder="姓"
          <% if(familyName != null) out.print("value=\"" + familyName + "\"");%> />
          <div class="form-control-feedback">${ERR_familyName } &nbsp;</div>
      </div>
      <div class="form-group <% if(request.getAttribute("ERR_givenName") != null) out.print("has-danger"); %>">
        <input name="givenName" class="form-control" placeholder="名"
          <% if(givenName != null) out.print("value=\"" + givenName + "\"");%> />
          <div class="form-control-feedback">${ERR_givenName } &nbsp;</div>
      </div>
      <div class="form-group <% if(request.getAttribute("ERR_password") != null) out.print("has-danger"); %>">
        <input type="password" name="password" class="form-control" placeholder="密码" />
          <div class="form-control-feedback">${ERR_password } &nbsp;</div>
      </div>
      <div class="form-group <% if(request.getAttribute("ERR_confirm") != null) out.print("has-danger"); %>">
        <input type="password" name="confirm" class="form-control" placeholder="请再确认一次" />
          <div class="form-control-feedback">${ERR_confirm } &nbsp;</div>
      </div>
      <div class="form-group <% if(request.getAttribute("ERR_country") != null) out.print("has-danger"); %>">
        <select name="country" class="form-control">
          <%
          if (countryStr == null) {out.print("<option selected value=\"300\">国家与地区</option>");}
          else if (Short.parseShort(countryStr) == 300)
          {out.print("<option selected value=\"300\">国家与地区</option>");}
          for(byte i = 0; i < COUNTRY.length; i++) {
          %>
          <option value="<%= i %>"
          <% if (countryStr != null) {
        	  if (countryStr.length() != 0) {
        	  if(i == Short.parseShort(countryStr)) out.print("selected"); }}%>>
            <% out.print(COUNTRY[i]); %>
          </option>
          <% 
          }
          %> 
          <option value="240">其他</option>
        </select>
          <div class="form-control-feedback">${ERR_country } &nbsp;</div>
      </div>
      <div class="form-group <% if(request.getAttribute("ERR_province") != null) out.print("has-danger"); %>">
        <select name="province" class="form-control">
          <%
          if (provinceStr == null) {out.print("<option selected value=\"1000\">所在省份</option>");}
          else if (Short.parseShort(provinceStr) == 1000)
          {out.print("<option selected value=\"1000\">所在省份</option>");}
          for(byte i = 0; i < PROVINCE_OF_CHINA.length; i++) { 
          %>
          <option value="<%= i %>"
          <% if (provinceStr != null) {
        	  if (provinceStr.length() != 0) {
        	  if(i == Short.parseShort(provinceStr)) out.print("selected"); }}%>>
            <% out.print(PROVINCE_OF_CHINA[i]); %>
          </option>
          <%
          }
          %>
          <option value="999">其他</option>
        </select>
          <div class="form-control-feedback">${ERR_province } &nbsp;</div>
      </div>
      <div class="form-group <% if(request.getAttribute("ERR_phoneNumber") != null) out.print("has-danger"); %>">
        <input name="phoneNumber" class="form-control" placeholder="电话号码"
          <% if(phoneNumber != null) out.print("value=\"" + phoneNumber + "\"");%> />
        <div class="form-control-feedback">${ERR_phoneNumber } &nbsp;</div>
      </div>
      <div class="form-group <% if(request.getAttribute("ERR_companyName") != null) out.print("has-danger"); %>">
        <input name="companyName" class="form-control" placeholder="公司名称"
         <% if(companyName != null) out.print("value=\"" + companyName + "\"");%>/>
        <div class="form-control-feedback">${ERR_companyName }  &nbsp;</div>
      </div>
      <div class="form-group <% if(request.getAttribute("ERR_companyType") != null) out.print("has-danger"); %>">
        <select name="companyType" class="form-control">
          <%
          if (companyTypeStr == null) {out.print("<option selected value=\"100\">公司行业</option>");}
          else if (Byte.parseByte(companyTypeStr) == 100)
          {out.print("<option selected value=\"100\">公司行业</option>");}
          for(byte i = 0; i < COMPANY_TYPE.length; i++) { 
          %>
          <option value="<%= i %>"
          <% if (companyTypeStr != null) {
        	  if (companyTypeStr.length() != 0) {
        	  if(i == Byte.parseByte(companyTypeStr)) out.print("selected"); }}%>>
            <% out.print(COMPANY_TYPE[i]); %>
          </option>
          <% 
          }
          %> 
        </select>
          <div class="form-control-feedback">${ERR_companyType } &nbsp;</div>
      </div>
      <div class="form-group <% if(request.getAttribute("ERR_gender") != null) out.print("has-danger"); %>">
        <select name="gender" class="form-control">
          <%
          if (genderStr == null) {out.print("<option selected value=\"4\">性别</option>");}
          else if (Byte.parseByte(genderStr) == 4)
          {out.print("<option selected value=\"4\">性别</option>");}
          for(byte i = 0; i < GENDER.length; i++) { 
          %>
          <option value="<%= i %>"
          <% if (genderStr != null) {
        	  if (genderStr.length() != 0) {
        	  if(i == Byte.parseByte(genderStr)) out.print("selected"); }}%>>
            <% out.print(GENDER[i]); %>
          </option>
          <% 
          }
          %> 
        </select>
          <div class="form-control-feedback">${ERR_gender } &nbsp;</div>
      </div>
      
      <input class="btn btn-lg btn-primary btn-block" type="submit" value="注册" /><br />
  </form>
  </div>
</body>
</html>
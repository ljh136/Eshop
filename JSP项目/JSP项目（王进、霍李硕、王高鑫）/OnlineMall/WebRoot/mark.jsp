<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.wgx.bean.goods"%>
<%@page import="com.wgx.bean.Order"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>确认订单</title>

<link rel="stylesheet" type="text/css" href="css/zzsc.css">
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquerybacktotopbutton.js"></script>
<script type="text/javascript" src="js/scrolltopcontrol.js"></script></p>


</head>
<body>
<header class="header-navigation" id="header">
  <nav>
  <div>
 <span style="margin-right:58%;"><a class="link" href="main.jsp" title="Home" >首页</a></span>
 <c:if test="${user.uname==null }">
 <span> <a class="link" href="login.jsp" >登录</a></span>
 <span> <a class="ulogo" href="registered.jsp" >注册</a></span>
 </c:if>
  <c:if test="${user.uname!=null }">
  <span> <a class="link" href="WPersonalServlet" >${user.uname }</a></span>
 <span> <a class="ulogo" href="WPersonalServlet" ><img src="${user.ulogo }" width="40px;" height="40px;"></a></span>
  </c:if>
 <span> <a class="link" href="WMyCatServlet" title="购物车">购物车</a></span>
 <span> <a class="link" href="WMyOrderServlet" title="订单">订单</a></span>
 <span> <a class="link" href="error.jsp" title="反馈">用户反馈</a></span>
 <span> <a  href="aboutus.jsp">关于我们</a></span>
 <span> <a  href="joinus.jsp">加入我们</a></span>
  </div>
  </nav>
</header>
<script type="text/javascript">
	var new_scroll_position = 0;
	var last_scroll_position;
	var header = document.getElementById("header");
	window.addEventListener('scroll', function(e) {
	  last_scroll_position = window.scrollY;
	  if (new_scroll_position < (last_scroll_position && last_scroll_position) > 80) {
		header.classList.remove("slideDown");
		header.classList.add("slideUp");
	  } else if (new_scroll_position > last_scroll_position) {
		header.classList.remove("slideUp");
		header.classList.add("slideDown");
	  }
	  new_scroll_position = last_scroll_position;
	});
	function markit(){
	alert("评价成功！");
	}
</script>
<br>
<br>
<br>
<br>
<br>
<br>
<div>
<br>
<div>
<div class="logo">
				<h1 style="font-size:30px;color:#337AB7;">
                <!--logo图片-->
                <img src="img/logo.jpg" style="height:60px;"/>&nbsp;网上商城</h1>
</div>

<div align="center">
<div class="search">
<div style="padding:3px;">
<span style="margin-right:10px;"><input type="text" class="searchtexttype"></span><span><input type="submit" class="searchbuttontype" value="搜索"></span>
</div>
</div>
</div>
</div>
<br>
<br>
<div class="leaderlist">
<div align="center" style=" padding-top:20px;">
<span style="margin-right:60px;"><a href="goclothes">精选服装</a></span>
<span style="margin-right:60px;"><a href="gosmarttoys">电子产品</a></span>
<span style="margin-right:60px;"><a href="golifeneeds">生活用品</a></span>
<span><a title="delisous food" href="godeliciousfood">休闲美食</a></span>
</div>
</div>
<div  class="chidleader"> <div align="center" style="padding-top:1%">宝贝评价</div></div>

<div class="buyshowinformation1">
<div class="buyshowdata"><table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="30%" align="center" height="100px">宝贝名称</td>
    <td width="30%" align="center" height="100px">商品属性</td>
    <td width="15%" align="center" height="100px">单价</td>
    <td width="10%" align="center" height="100px">购买数量</td>
    <td width="15%"align="center" height="100px">购买时间</td>
  </tr>
  <%
  		Order order=(Order)request.getAttribute("order");
		goods good =(goods)request.getAttribute("good");
   %>
   <tr>
    <td width="30%" align="center" height="100px">
     <% 
    String[] value = good.getGpic().split(", |\\[|\\],\\[|\\]");
          if(value.length==1){
          	%>
          	<a href="goodinformation?gid=<%=good.getGid()%>"><img alt="<%=value[0]%>" src="<%=value[0]%>" width="80px"  height="80px" ></a>
          	<%
          }
          	else{
          for(int s=1;s<value.length;s++){
          %>
          	<a href="goodinformation?gid=<%=good.getGid()%>"><img  alt="<%=value[1]%>" src="<%=value[1]%>" width="80px"  height="80px" no-repeat;></a>
          	<%
        	break;
		}}
           %>
            <br>
    <%=good.getGname() %>
    </td>
    <td width="30%" align="center" height="100px"><%=good.getGintroduce() %></td>
    <td width="15%" align="center" height="100px"><%=good.getGprice()%></td>
    <td width="10%" align="center" height="100px"><%=order.getBnum()%></td>
    <td width="15%"align="center" height="100px"><%=order.getBdate()%>计</td>
  </tr>
</table>
</div>
</div>
<form action="marked" method="post">
<input type="hidden" name="gid" value="<%=good.getGid()%>">
<input type="hidden" name="uid" value="<%=order.getUid()%>">
<input type="hidden" name="bdate" value="<%=order.getBdate()%>">
<div class="buyshowinformation1">
<textarea rows="10" cols="65" style="font-size:24px; color:#F30" name="gmark">在此写入评价
</textarea>
</div>
<div class="buy">
<input type="submit" value="提交评价" style="background-color:#F00; font-size:36px; border:0; color:#FFF; padding:10%" onclick="markit()">
</div>
</div>

</form >
        <div  class="blockdiv"></div>
        <div class="bottom" >
   <div  style="margin-left:20%;">     
   <table width="70%" border="0" cellspacing="0" cellpadding="0" >
  <tr height="80px;">
  	<td>品质保障</td>
    <td>百城速达</td>
    <td>客服在线</td> 
    </tr>
    <tr height="80px;">
    <td>15天换货保障</td>
    <td>远程支持服务</td>
   <td>7天无理由退货</td>
  </tr>
</table>
</div>

       
        </div>
<div  class="rights"><div style="padding:20px;">Copyright ©2012-2017 OnelineMall.com All Rights Reseved</div>
</div>
        
</body>
</html>

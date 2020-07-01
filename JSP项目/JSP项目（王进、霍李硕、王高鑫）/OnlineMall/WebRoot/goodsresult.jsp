<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.wj.bean.*"%>
<%@page import="com.wj.service.*"%>
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
<title>精选服装</title>

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
<form action="WGoodsResultServlet" method="post">
<span style="margin-right:10px;"><input type="text" name="keyword" class="searchtexttype"></span><span><input type="submit" class="searchbuttontype" value="搜索"></span>
</form>
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
<div class="selectquery">
<div align="center">
 <table width="70%" border="0" cellspacing="0" cellpadding="0" >
  <tr height="80px;">
  	<td bgcolor="#CCCCCC" align="center";>价格</td>
    <td><a  style="color:#FF572D" align="center">￥0-50</a></td>
    <td><a style="color:#FF572D" align="center">￥51-100</a></td>
    <td><a style="color:#FF572D" align="center">￥101-200</a></td> 
    <td><a style="color:#FF572D" align="center">￥200-500</a></td>  
    </tr>
     <tr height="80px;">
  <td bgcolor="#CCCCCC" align="center";>销量</td>
    <td><a style="color:#FF572D" align="center">按升序</a></td>
   <td><a style="color:#FF572D" align="center">按降序</a></td>
   <td><a style="color:#FF572D" align="center">&nbsp;</a></td>
   <td>&nbsp;</td>
  </tr>
</table>
</div>
</div>
 
 
<div  class="blockdiv">
</div>

<ul id="iconWall">
            <%
		List list=(ArrayList)request.getAttribute("list");
		if(list.size()==0){
			%>
			<h2 style="color:black;">未搜索到与之相关的商品，快去商城看看吧</h2>
			<%
		}else{
		%>
			<h2 style="color:black;">搜索商品如下：</h2><br>
			<%
		for(int i=0;i<list.size();i++){
		
		Goods good = (Goods)list.get(i);
		
      %>
      
            <li>
                    <div class="img-back">
          <%         
          String[] value = good.getGpic().split(", |\\[|\\],\\[|\\]");
          if(value.length==1){
          	%>
          	<a href="goodinformation?gid=<%=good.getGid()%>"><img alt="<%=value[0]%>" src="<%=value[0]%>" width="200px"  height="200px" ></a>
          	<%
          }
          	else{
          for(int s=1;s<value.length;s++){
          %>
          	<a href="goodinformation?gid=<%=good.getGid()%>"><img  alt="<%=value[1]%>" src="<%=value[1]%>" width="200px"  height="200px" no-repeat;></a>
          	<%
          	break;}
		}%> 
                      <!-- <img src="img/jp/1.jpg" alt="" width="200px"  height="200px"> -->
                        <p class="tit"></p>
                        <p class="des"><%=good.getGname() %></p>
                        <p class="price"><%=good.getGprice() %></p>
                        <span class="old-price">￥9698</span>
                        <span class="saled">销量：<%=good.getGsales() %></span>
                        </p>
                    </div>

            </li>
            <% 
            } }
            %>
        </ul>
        <div  class="blockdiv">
</div>
        <div  class="blockdiv"></div>
        <div class="bottom" >
   <div  style="margin-left:20%;">     
   <table width="70%" border="0" cellspacing="0" cellpadding="0" >
  <tr height="8px;">
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

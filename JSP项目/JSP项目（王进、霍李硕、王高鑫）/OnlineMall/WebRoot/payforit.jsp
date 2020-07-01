<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.wgx.bean.Buycat"%>
<%@page import="com.wgx.dao.DaoDB"%>
<%@page import="com.wgx.bean.goods"%>
<%@page import="com.wgx.bean.User"%>
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
	function payit(){
	alert("购买成功！");
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
<div  class="blockdiv"></div>
<div  class="chidleader"> <div align="center" style="padding-top:1%">确认订单</div></div>
<div  class="buyshowinformationtitle">
<div class="buyshowinformationtitletext">确认收货地址</div>
</div>
<%  
	Buycat buycar =(Buycat)request.getAttribute("buycar");
	List list=(ArrayList)request.getAttribute("list");
	String[] buygoods=request.getParameterValues("buygoods");
	String bid1 = request.getParameter("bid1");
	if(bid1==null){bid1="2";}
	DaoDB db = new DaoDB();
	double SUM=0;
	int Gid=0;
	if(buycar==null){
	 for(int i=0;i<list.size();i++){
		
		Buycat buycar1 = (Buycat)list.get(i);	
		User user=db.getUserByid(buycar1.getUid());
		
		
	%>
<div class="buyshowinformation"><div style="padding-top:3%"><span ><%=user.getAddress() %>
</span><span style="padding-right:3%"><a href="WPersonalServlet" style="color:#F60">点我修改收货地址</a></span></div></div>
<div class="buyshowinformationtitle">
<div class="buyshowinformationtitletext">确认收货电话号码</div></div>
<div class="buyshowinformation"><div style="padding-top:3%"><span ><%=user.getUstel() %>
</span><span style="padding-right:3%"><a href="WPersonalServlet" style="color:#F60">点我修改收货电话</a></span></div></div>
<%   break;
		} %>
<div class="buyshowinformationtitle">
<div class="buyshowinformationtitletext">确认订单细节</div></div>
<div class="buyshowinformation1">
<div class="buyshowdata"><table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td width="30%" align="center" height="100px">店铺名称</td>
    <td width="30%" align="center" height="100px">商品属性</td>
    <td width="15%" align="center" height="100px">单价</td>
    <td width="10%" align="center" height="100px">数量</td>
    <td width="15%"align="center" height="100px">小计</td>
  </tr>
  <%  
	 for(int i=0;i<list.size();i++){
		
		Buycat buycar1 = (Buycat)list.get(i);
		goods good=db.getGoodByid(buycar1.getGid());
		double price=Double.valueOf(good.getGprice());
		double num=buycar1.getBnum();
		double sum=	price*num;
		SUM=SUM+sum;
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
    <%=good.getGname() %></td>
    <td width="30%" align="center" height="100px"><%=good.getGintroduce() %></td>
    <td width="15%" align="center" height="100px"><%=good.getGprice() %></td>
    <td width="10%" align="center" height="100px"><%=buycar1.getBnum() %></td>
    <td width="15%"align="center" height="100px"><%=sum %></td>
  </tr>
 <%} 
 }
 else{
 	User user=db.getUserByid(buycar.getUid());

  %>
  <div class="buyshowinformation"><div style="padding-top:3%"><span ><%=user.getAddress() %>
</span><span style="padding-right:3%"><a href="WPersonalServlet" style="color:#F60">点我修改收货地址</a></span></div></div>
<div class="buyshowinformationtitle">
<div class="buyshowinformationtitletext">确认收货电话号码</div></div>
<div class="buyshowinformation"><div style="padding-top:3%"><span ><%=user.getUstel() %>
</span><span style="padding-right:3%"><a href="WPersonalServlet" style="color:#F60">点我修改收获电话</a></span></div></div>
<div class="buyshowinformationtitle">
<div class="buyshowinformationtitletext">确认订单细节</div></div>
<div class="buyshowinformation1">
<div class="buyshowdata"><table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td width="30%" align="center" height="100px">宝贝名称</td>
    <td width="40%" align="center" height="100px">商品属性</td>
    <td width="10%" align="center" height="100px">单价</td>
    <td width="10%" align="center" height="100px">数量</td>
    <td width="10%"align="center" height="100px">小计</td>
  </tr>
  
  
  
  <%
		goods good=db.getGoodByid(buycar.getGid());
		double price=Double.valueOf(good.getGprice());
		double num=buycar.getBnum();
		double sum=	price*num;
		SUM=SUM+sum;
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
    <td width="40%" align="center" height="100px"><%=good.getGintroduce()%></td>
    <td width="10%" align="center" height="100px"><%=good.getGprice() %></td>
    <td width="10%" align="center" height="100px"><%=buycar.getBnum() %></td>
    <td width="10%"align="center" height="100px"><%=sum %></td>
  </tr>
  <%} %>
  <tr>
    <td width="30%" align="center" height="100px">&nbsp;</td>
    <td width="40%" align="center" height="100px">&nbsp;</td>
    <td width="10%" align="center" height="100px">&nbsp;</td>
    <td width="10%" align="center" height="100px">合计</td>
    <td width="10%"align="center" height="100px" style="color:#F00; font-size:36px" ><%=SUM %></td>
  </tr>
</table>
</div>
</div>

<%-- <form action="paid" method="get">
<input type="hidden" name="list" value="<%=list %>">
<input type="hidden" name="bid1" value="<%=bid1%>">
<input type="hidden" name="buycar" value="<%=buycar%>">
<input type="hidden" name="buygoods" value="<%=buygoods%>">
<div class="buy"><input type="submit" value="确认购买"></div>
</form> --%>
 <a href="WMyOrderServlet"><div class="buy" onclick="payit()"><div style="padding:10%">确认购买</div></div></a>
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
<div class="rights"><div style="padding:20px;">Copyright ©2012-2017 OnelineMall.com All Rights Reseved</div>
</div>
        
</body>
</html>

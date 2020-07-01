<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
<title>修改密码</title>
<link rel="stylesheet" type="text/css" href="css/updatepassword.css">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  
<body>
	<header class="header-navigation" id="header">
  <nav>
  <div>
 <span style="margin-right:55%;"><a class="link" href="main.jsp" title="Home" >首页</a></span>
 <span> <a class="link" href="WPersonalServlet" >${user.uname }</a></span>
 <span> <a class="ulogo" href="WPersonalServlet" ><img src="${user.ulogo }" width="40px;" height="40px;"></a></span>
 <span> <a class="link" href="WMyCatServlet" title="购物车">购物车</a></span>
 <span> <a class="link" href="WMyOrderServlet" title="订单">订单</a></span>
 <span> <a class="link" href="error.jsp" title="反馈">用户反馈</a></span>
 <span> <a  href="aboutus.jsp" title="">关于我们</a></span>
  </div>
  </nav>
</header>


<script type="text/javascript">
	var new_scroll_position = 0;
	var last_scroll_position;
	var header = document.getElementById("header");
	window.addEventListener('scroll', function(e) {
	  last_scroll_position = window.scrollY;
	  if (new_scroll_position < last_scroll_position && last_scroll_position > 80) {
		header.classList.remove("slideDown");
		header.classList.add("slideUp");
	  } else if (new_scroll_position > last_scroll_position) {
		header.classList.remove("slideUp");
		header.classList.add("slideDown");
	  }
	  new_scroll_position = last_scroll_position;
	});
</script>
<br />
<br />
<br />
<br />
<div class="logo">
				<h1 style="font-size:30px;color:#337AB7;">
                <!--logo图片-->
                <img src="image/logo.jpg" style="height:60px;"/>&nbsp;网上商城</h1>
</div>
<div align="center">

<div class="search">

<div style="padding:3px;">

<span style="margin-right:10px;"><input type="text" class="searchtexttype"></span><span><input type="submit" class="searchbuttontype" value="搜索"></span>
</div>
</div>
</div>
<br>
<div class="leaderlist">
<div align="center" style=" padding-top:20px;">
<span style="margin-right:60px;"title="clothes"><a href="#">精选服装</a></span>
<span style="margin-right:60px;"title="smart toys"><a href="#">电子产品</a></span>
<span style="margin-right:60px;"title="life needs"><a href="#">生活用品</a></span>
<span><a title="delisous food" href="#">休闲美食</a></span>
</div>
</div>


<div class="grzx">
	<!--全部功能-->
	<div class="grzx-l"><br />
    <h2 align="left">全部功能:</h2>
    <h3><a href="WPersonalServlet">个人信息</a></h3>
    <h3><a href="WMyCatServlet">我的购物车</a></h3>
    <h3><a href="WMyOrderServlet">我的订单</a></h3>
    <h3><a href="error.jsp">我的收藏</a></h3>
    <h3><a href="WMyMarkServlet">评价管理</a></h3>
    <h3><a href="error.jsp">我的足迹</a></h3>
    <h3><a href="aboutus.jsp">关于我们</a></h3>
    <h3><a href="login.jsp">注销用户</a></h3>
	</div>
	
    <div class="grzx-z">
    </div>
    
    <!--修改密码-->
    <div class="grzx-r"><br />
    <h2 style="">修改密码</h2><br />
<form action="WUpdatePasswordServlet" method="post">
<input type="hidden" name="uid" value="${user.uid }">

<table width="100%" style="font-size:22px">
    <tr height="80px">
    	<td width="30%">当前头像：<td>
        <td width="70%"><img src="${user.ulogo }" height="80px"/><td>
    </tr>
    <tr height="40px">
    	<td width="30%">用户名：<td>
        <td width="70%">${user.uname }<td>
    </tr>
    <tr height="40px">
    	<td width="30%">旧密码：<td>
        <td width="70%"><input type="text" name="upassword"><td>
    </tr>
    <tr height="40px">
    	<td width="30%">密保问题：<td>
        <td width="70%">${user.uquestion }<td>
    </tr>
    <tr height="40px">
    	<td width="30%">密保问题答案：<td>
        <td width="70%"><input type="text" name="uanswer"><td>
    </tr>
    <tr height="40px">
    	<td width="30%">新密码：<td>
        <td width="70%"><input type="text" name="unpassword"><td>
    </tr>
    <tr height="40px">
    	<td width="30%">再次输入新密码：<td>
        <td width="70%"><input type="text" name="unpassword1"><td>
    </tr>
</table>
<input type="submit" class="button" value="确认修改"><a href="WPersonalServlet" class="button1" >取消修改</a>
</form>
   
    
    
    </div>


</div>

</body>
</html>

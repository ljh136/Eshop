<%@ page language="java" import="java.util.*,com.wj.bean.*,com.wj.service.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的评价</title>
	<link rel="stylesheet" type="text/css" href="css/mysmark.css">
   	<link rel="stylesheet" type="text/css" href="css/css.css"> 
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
<span style="margin-right:60px;"><a href="goclothes">精选服装</a></span>
<span style="margin-right:60px;"><a href="gosmarttoys">电子产品</a></span>
<span style="margin-right:60px;"><a href="golifeneeds">生活用品</a></span>
<span><a title="delisous food" href="godeliciousfood">休闲美食</a></span>
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
    
    <!--我的评价-->
    <div class="grzx-r"><br />
    <h2 style="">我的评价</h2><br />
   <%
   List list =(ArrayList)request.getAttribute("list");
   if(list.size()==0){
   		%> 
   		<h2>亲，您还没有评价任何商品哦，快去商城看看吧！</h2><br/>
   		<a href="#" class="button2">商城首页</a>
   		<%
   }else{
    %>
    <table width="95%" border="1" align="center" bordercolor="#fff" frame="border" rules="rows">
   <tr height="40px">
         <td width=8%>&nbsp;评价</td>
         <td width=45%>评价内容</td>
         <td width=15%>商品名称</td>
         <td width=14%>商品图片</td>
         <td width=13%>商品单价</td>
   <tr>
   <%
   	for(int i=0;i<list.size();i++){
         GoodsMark goodsMark = (GoodsMark)list.get(i);
         Goods goods=MyCatService.getGoodBygid(goodsMark.getGid());
         String[] value = goods.getGpic().split(", |\\[|\\],\\[|\\]");
   %>
   	<tr height="80px">
   	<td width=8%>&nbsp;<img alt="" src="image/haoping.png"></td>
		<td width=45%>
         <%=goodsMark.getGmark() %><br>
         [<%=goodsMark.getGdate() %>]
         </td>
         <td width=15%><%=goods.getGname()%></td>
         <td width=14%>
        <%
          if(value.length==1){
          	%>
          	<a href="goodinformation?gid=<%=goods.getGid()%>"><img class="spimg" src="<%=value[0]%>"></a>
          	<%
          }
          	else{
          for(int s=1;s<value.length;s++){
          %>
          	<a href="goodinformation?gid=<%=goods.getGid()%>"><img class="spimg" src="<%=value[1]%>"></a>
          	<%
          	break;
        	}
		}%>
         </td>
         <td width=13%><%=goods.getGprice() %></td>
   <tr>
      
   <%}
   }%>
   
   </table>
    
    
    </div>


</div>

</body>
</html>

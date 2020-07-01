<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.wgx.bean.goods"%>
<%@page import="com.wgx.bean.User"%>
<%@page import="com.wgx.bean.GoodsMark"%>
<%@page import="com.wgx.dao.DaoDB"%>

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
<title>商品信息</title>

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
	function buyit(){
	alert("加入购物车成功！");

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

<div class="goodinforshow">
<div  style="padding-top:50px;">
<span  class="goodinforshowchid"><a style="color:#CCC;" href="main.jsp">首页|</a></span>
<span  ><a style="color:#CCC;">分类|</a></span>
<span  ><a style="color:#CCC;">当前</a></span>
</div>
</div>
<%  
	goods good=(goods)request.getAttribute("good");
	List list=(ArrayList)request.getAttribute("list");
	double price=Double.valueOf(good.getGprice());
	double oldprice=price*1.2;
 %>
<div class="goodinforshowmain">
<form action="buycar" METHOD="POST">
<input type="hidden" name="gid" value="<%=good.getGid()%>">
  <table width="100%"  height="600px" border="0" cellspacing="0" cellpadding="0">
    <tr>
     <%         
          String[] value = good.getGpic().split(", |\\[|\\],\\[|\\]");
          if(value.length==1){
          	%>
      <td width="400" rowspan="6" height="400"><img alt="<%=value[0]%>" src="<%=value[0]%>" width="390px"  height="390px" ></td>
      	<%}else{
          for(int s=1;s<value.length;s++){
          %>
          <td width="400" rowspan="6" height="400"><img  alt="<%=value[1]%>" src="<%=value[1]%>" width="200px"  height="200px" no-repeat;></td>
          	<%
        	break;
		}}
           %>
      <td width="5%" rowspan="7" >&nbsp;</td>
      <td style="color:#F60">名称</td>
      <td colspan="2" style="color:#000"><%=good.getGname() %></td>
    </tr>
    <tr>
      <td width="10%" style="color:#F60">信息</td>
      <td colspan="2" style="color:#000"><%=good.getGintroduce() %></td>
    </tr>
    <tr>
      <td width="10%" bgcolor="#CCCCCC" style="color:#F60">价格</td>
      <td bgcolor="#CCCCCC"class="oldprice"><%=oldprice %></td>
      <td bgcolor="#CCCCCC"style="color:#F00; font-size:36px"><%=good.getGprice() %></td>
    </tr>
    <tr>
      <td width="10%" style="color:#F60">销量</td>
      <td colspan="2"style="color:#000"><%=good.getGsales() %></td>
    </tr>
<!--     <tr>
      <td width="10%">地址</td>
      <td colspan="2"> & nbsp;</td>
    </tr> -->
    <tr>
      <td width="10%" style="color:#F60">数量</td>
      <td colspan="2">
      <input type=button value="-" onClick="javascript:this.form.bnum.value--;" style="width: 20px">
      <input type=text name="bnum" value=1 width="20px" style="width: 40px; font-size: 15px;" >
		<input type=button value="+" onClick="javascript:this.form.bnum.value++;" style="width: 20px">
      </td>
    </tr>
    <tr>
      <td width="400" height="100px"></td>
      <td width="10%" height="100px">&nbsp;</td>
      <td height="100px"> <input type="submit" value="点我加入购物车"  style="font-size:24px; width:200px; height:90px; background-color:#F00; color:#FFF" onclick="buyit()"></td>
      <td height="100px">&nbsp;</td>
    </tr>
  </table>

</form>

</div>

<div  class="blockdiv"></div>
<div  class="chidleader"><div align="center">用户评论</div>
</div>
<div class="goodinforshowmain">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <% if(list.size()==0){%>
		  
  <tr>
     
      <td width="100%" style="font-size:36px;color:#3FF"colspan="3">该商品暂无评论，赶快购买商品抢沙发吧~</td>
    </tr>
  
 <%  } 
    else{
 %>
  <tr>
      <td width="15%" style="font-size:36px;color:#3FF">用户名</td>
      <td width="70%" style="font-size:36px;color:#3FF">评论</td>
      <td width="15%" style="font-size:36px;color:#3FF">时间</td>
    </tr>
    
  <%     DaoDB db = new DaoDB();
  		 for(int i=0;i<list.size();i++){
		
		GoodsMark goodmark = (GoodsMark)list.get(i);
		int uid=goodmark.getUid();
		User user=db.getUserByid(uid);
		 %>
	<tr>
      <td width="15%" style="font-size:36px;color:#F60"><%=user.getUname() %></td>
      <td width="70%" style="font-size:36px;color:#F60"><%=goodmark.getGmark() %></td>
      <td width="15%" style="font-size:36px;color:#F60"><%=goodmark.getGdate() %></td>
    </tr>
    <%} 
    }%>
 </table>

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

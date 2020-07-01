<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.wgx.bean.goods"%>
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
<title>欢迎来到在线购物商城</title>

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

 
 <div id="big_banner_wrap">
	 <ul id="banner_menu_wrap">
		 <li class="active"img>
			 <a>电子产品</a>
			 <a class="banner_menu_i">&gt;</a>
			 <div class="banner_menu_content" style="width: 600px; top: -20px;">
				 <ul class="banner_menu_content_ul">
					 <li>
						 <a><img src="img/minote.jpg"></a><a>大米NOTE</a><span>选购</span></li>
					 <li>
						 <a><img src="img/mi4.jpg"></a><a>大米手机4</a><span>选购</span></li>
					 <li>
						 <a><img src="img/hongmi2.jpg"></a><a>红米手机2</a><span>选购</span></li>
					 <li>
						 <a><img src="img/tv40.jpg"></a><a>大米电视40英寸</a><span>选购</span></li>
					 <li>
						 <a><img src="img/note2.jpg"></a><a>红米NOTE2</a><span>选购</span></li>
					 <li>
						 <a><img src="img/hezis.jpg"></a><a>大米盒子</a><span>选购</span></li>
				 </ul>
				 <ul class="banner_menu_content_ul">
					 <li>
						 <a><img src="img/mipad.jpg"></a><a>大米平板</a><span>选购</span></li>
					 <li>
						 <a><img src="img/miwifi.jpg"></a><a>大米路由器</a><span>选购</span></li>
					 <li>
						 <a><img src="img/air.jpg"></a><a>净化器</a><span>选购</span></li>
					 <li>
						 <a><img src="img/shouhuan.jpg"></a><a>大米手环</a><span>选购</span></li>
					 <li>
						 <a><img src="img/powerscript.jpg"></a><a>大米插线板</a><span>选购</span></li>
				 </ul>
			 </div>
		 </li>
<br>
<br>
<br>
		 <li>
			 <a>休闲美食</a>
			 <a class="banner_menu_i">&gt;</a>
			 <div class="banner_menu_content" style="width: 600px; top: -115px;">
				 <ul class="banner_menu_content_ul">
					 <li>
						 <a><img src="img/food/juzi.jpg"></a><a>橘子</a><span>选购</span></li>
					 <li>
						 <a><img src="img/food/lanmei.jpg"></a><a>蓝莓</a><span>选购</span></li>
					 <li>
						 <a><img src="img/food/longyan.jpg"></a><a>龙眼</a><span>选购</span></li>
					 <li>
						 <a><img src="img/food/pinguo.jpg"></a><a>苹果</a><span>选购</span></li>
                         
					 <li>
						 <a><img src="img/food/qiaokeli.jpg"></a><a>巧克力</a><span>选购</span></li>
                          </ul>
                      <ul class="banner_menu_content_ul">
					 <li>
						 <a><img src="img/food/songzi.jpg"></a><a>松子</a><span>选购</span></li>
                     <li>
						 <a><img src="img/food/xiaweiyiguo.png"></a><a>夏威夷果</a><span>选购</span></li>
                     <li>
						 <a><img src="img/food/yingtao.jpg"></a><a>樱桃</a><span>选购</span></li>
				 </ul>
				
			 </div>
		 </li>
<br>
<br>
<br>
		 <li>
			 <a>精品服装</a>
			 <a class="banner_menu_i">&gt;</a>
			 <div class="banner_menu_content" style="width: 600px; top: -212px;">
				 <ul class="banner_menu_content_ul">
					 <li>
						 <a><img src="img/clothes/kuzi.jpg"></a><a>裤子</a><span>选购</span></li>
					 <li>
						 <a><img src="img/clothes/shubao.jpg"></a><a>书包</a><span>选购</span></li>
					 <li>
						 <a><img src="img/clothes/txu.jpg"></a><a>T恤</a><span>选购</span></li>
					 <li>
						 <a><img src="img/clothes/wallet.png"></a><a>钱包</a><span>选购</span></li>
					 <li>
						 <a><img src="img/clothes/xiezi.jpg"></a><a>鞋子</a><span>选购</span></li>
					 <li>
						 <a><img src="img/clothes/xizhuangtaofu.jpg"></a><a>西装</a><span>选购</span></li>
				 </ul>
				 <ul class="banner_menu_content_ul">
					 <li>
						 <a><img src="img/clothes/zhenzhishan.jpg"></a><a>针织衫</a><span>选购</span></li>
					 <li>
						 <a><img src="img/clothes/qunzi.jpg"></a><a>裙子</a><span>选购</span></li>
					 
				 </ul>
			 </div>
		 </li>
<br>
<br>
<br>
		 <li>
			 <a>生活用品</a>
			 <a class="banner_menu_i">&gt;</a>
			 <div class="banner_menu_content" style="width: 300px; top: -309px;">
				 <ul class="banner_menu_content_ul">
					 <li>
						 <a><img src="img/lifeneeds/beizi.jpg"></a><a>杯子</a><span>选购</span></li>

					 <li>
						 <a><img src="img/lifeneeds/kouzhao.jpg"></a><a>口罩</a><span>选购</span></li>



					 <li>
						 <a><img src="img/lifeneeds/san.jpg"></a><a>伞</a><span>选购</span></li>

					 <li>
						 <a><img src="img/lifeneeds/zhijin.jpg"></a><a>纸巾</a><span>选购</span></li>
				 </ul>
			 </div>
		 </li>
		 
	 </ul>
	 <div id="big_banner_pic_wrap">
		 <ul id="big_banner_pic">
			 <li><img src="img/T1hiDvBvVv1RXrhCrK.jpg"></li>
			 <li><img src="img/T1jrxjB_VT1RXrhCrK.jpg"></li>
			 <li><img src="img/T1oTJjBKKT1RXrhCrK.jpg"></li>
			 <li><img src="img/T1RICjB7DT1RXrhCrK.jpg"></li>
			 <li><img src="img/T1vWdTBKDv1RXrhCrK.jpg"></li>
		 </ul>
	 </div>
	 <div id="big_banner_change_wrap">
		 <div id="big_banner_change_prev">&lt;</div>
		 <div id="big_banner_change_next">&gt;</div>
	 </div>
 </div>

 
<script type="text/javascript" src="js/script.js"></script>
<div  class="blockdiv">
</div>
<div  class="chidleader"><div style="padding:20px;">每日精品</div>
</div>
<ul id="iconWall">
 <%
		DaoDB shoplist = new DaoDB();
       	List list =shoplist.queryGoods();
		for(int i=0;i<10;i++){
		
		goods good = (goods)list.get(i);
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
        	break;
		}}
           %>
                       
                        <p class="tit"></p>
                        <p class="des"><%=good.getGname() %></p>
                        <p class="price"><%=good.getGprice() %>
                        <span class="old-price">￥9698</span>

                        <span class="saled">销量：<%=good.getGsales() %></span>
                        </p>
                    </div>

            </li>
  <% }%>   
        </ul>
        <div  class="blockdiv">
</div>
<div  class="chidleader"><div style="padding:20px;">限量秒杀</div>
</div>
<ul id="iconWall">
 <%
		
		for(int i=10;i<20;i++){
		
		goods good = (goods)list.get(i);
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
        	break;
		}}
           %>
                       
                        <p class="tit"></p>
                        <p class="des"><%=good.getGname() %></p>
                        <p class="price"><%=good.getGprice() %>
                        <span class="old-price">￥9698</span>

                        <span class="saled">销量：<%=good.getGsales() %></span>
                        </p>
                    </div>

            </li>
  <% }%>   
        </ul>
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

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/login_s.css" />
<link rel="stylesheet" type="text/css" href="css/lb.css" />
<script type="text/javascript">
function fun(){
	document.getElementById('tishi').innerHTML="";

}
</script>
  </head>
  
  <body>
  <%session.invalidate(); %>
<div class="container-fluid box" style="margin:0px auto;padding-top:10px;">
	<div class="row-fluid">
		<div class="main">
			<div class="col-xs-3">
				<h1 style="font-size:30px;color:#337AB7;">
                <!--logo图片-->
                <img src="image/logo.jpg" style="height:60px;margin-top:-10px;"/>&nbsp;网上商城</h1>
			</div>
			<div class="col-xs-1">
			</div>
			<div class="col-xs-6" style="padding-top:22px;">
				<div class="form-inline">
					<div class="form-group">
						<input type="text" style="width:380px;" class="form-control" placeholder="商品名/商品类型">
					</div>
					<button type="button" class="btn btn-info" style="background-color:F81B1F;">搜商品</button>
				</div>
			</div>
			<div class="col-xs-2" style="padding-top:22px;">
				<ul class="list-unstyled list-inline">
					<li><a href="login.jsp" class="btn btn-default"> 登 录 </a></li>
					<li><a href=" registered.jsp" class="btn btn-default"> 注 册 </a></li>
									</ul>
			</div>
		</div>
	</div>
</div>


<div class="container-fluid navbar" style="margin-top:0px;margin-bottom:0px;padding-top:10px;background-color:D32727;">
	<div class="row-fluid">
		<div class="main">
			<div class="col-xs-12">
				<ul class="list-unstyled list-inline">
					<li class="menu col-xs-1"><a href="goclothes">精选服装</a></li>
					<li class="menu col-xs-1"><a href="gosmarttoys">电子产品</a></li>
					<li class="menu col-xs-1"><a href="golifeneeds">生活用品</a></li>
                   	<li class="menu col-xs-1"><a href="godeliciousfood">休闲美食</a></li>
                    <li class="menu col-xs-1"><a href="#">更多……</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>


<div class="container-fluid">
	<div class="row-fluid">
		<div class="main box">
			<div class="col-xs-7" style="padding:15px;">
            <!--左边大图片-->
				<!--<img src="image/login_3.jpg" />-->
                	<div class="flash">
		<img src="image/login18.jpg" height="416" /> 
        <img src="image/login12.jpg" height="416" /> 
        <img src="image/login13.jpg" height="416"/> 
        <img src="image/login17.jpg" height="416" />
			
		<ul class="button">
			<li class="hover"></li>
			<li></li>
			<li></li>
			<li></li>
			
		</ul>
        <script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/lb.js"></script>
	
					</div>
			</div>
			<div class="col-xs-4 pull-right" style="margin:30px 30px 0px auto;background-color:#FFFFFF;">
            
				<form class="col-xs-12" method="post" action="WLoginUserServlet">
					<h4 class="title" style="line-height:3em;margin-bottom:40px;">用户登录</h4>
					 <div class="tishi" id="tishi">
					 	<c:if test="${type==1 }">
					 		用户名或密码错误！
					 	</c:if>
					 	<c:if test="${type==2 }">
					 		密码修改成功，请重新登录！
					 	</c:if>
					 	<c:if test="${type==3 }">
					 		您还未登录，请先登录！
					 	</c:if>
					 	<c:if test="${type==4 }">
					 		注册成功，请登录！
					 	</c:if>
					 </div>
					<div class="form-group input-group">
						<span class="input-group-addon" ><img src="image/user_logo.png" class="user_logo"  /></span>
						<input class="form-control" name="uname" placeholder="请输入账号/用户名" onfocus="fun()" type="text" style="height:44px;line-height:24px;font-size:16px;">
                    </div>
					<div class="form-group input-group">
						<span class="input-group-addon"><img src="image/password_logo.png" class="pass_logo"  /></span>
						<input class="form-control" name="upassword" placeholder="请输入密码" onfocus="fun()" type="password" style="height:44px;line-height:24px;font-size:16px;">                     
					</div>
					<input type="hidden" value="1" name="userlogin"/>
					<button type="submit" class="btn btn-primary btn-block" style="background-color:F81B1F;height:44px;line-height:32px;font-size:16px;margin-top:30px;">登录</button>
					<a class="btn btn-default btn-block" href="registered.jsp" style="height:44px;line-height:32px;font-size:16px;margin-top:10px;">注册</a>
				</form>
			</div>
		</div>
	</div>
</div>


<div class="container-fluid box" style="background-color:D32727;margin-bottom:0px;" id="footer">
	<div class="row-fluid">
		<div class="main itembox">
			<div class="col-xs-12">
				<ul class="list-unstyled">
					<li class="text-center">网上商城系统</li>
					<li class="text-center"></li>
				</ul>
			</div>
		</div>
	</div>
</div>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<link rel="stylesheet" type="text/css" href="css/registered.css" />
<script type="application/javascript" src="js/registered.js"></script>

  </head>
  
  <body>
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
					<li><a href="registered.jsp" class="btn btn-default"> 注 册 </a></li>
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
			<div class="col-xs-7" style="padding:15px;padding-top:70px;">
            <!--左边大图片-->
				<img src="image/login11.jpg" />
			</div>
			<div class="col-xs-4 pull-right" style="margin:30px 30px 0px auto;background-color:#FFFFFF;">
            
				<form class="col-xs-12" method="post" action="WAddUserServlet" onsubmit="return check()" enctype="multipart/form-data">
					<h4 class="title" style="line-height:3em;margin-bottom:40px;">用户注册</h4>
                    <div class="tishi" id="tishi"></div>
                    
                    <div class="form-group input-group">
						上传头像：
						<input class="form-control" name="upload" type="file"  style="height:44px;line-height:24px;font-size:16px;">
                    </div>
					<div class="form-group input-group">
						<span class="input-group-addon" ><img src="image/user_logo.png" class="user_logo"  /></span>
						<input class="form-control" name="uname" id="username" placeholder="请输入用户名" type="text" onfocus="show1()" onblur="fun1()" style="height:44px;line-height:24px;font-size:16px;">
                    </div>
                    
					<div class="form-group input-group">
						<span class="input-group-addon" ><img src="image/user_logo.png" class="user_logo"  /></span>
						<input class="form-control" name="utel" id="utel" placeholder="请输入手机号" type="text" onfocus="show5()" onblur="fun5()" style="height:44px;line-height:24px;font-size:16px;">
                    </div>
                    <div class="form-group input-group">
						<span class="input-group-addon" ><img src="image/email_logo.png" class="email_logo"  /></span>
						<input class="form-control" name="uemail" id="email" placeholder="请输邮箱地址" type="text" onfocus="show2()" onblur="fun2()" style="height:44px;line-height:24px;font-size:16px;">
                    </div>
					<div class="form-group input-group">
						<span class="input-group-addon"><img src="image/password_logo.png" class="pass_logo"  /></span>
						<input class="form-control" name="upassword" id="password" placeholder="请输入密码" type="password" onfocus="show3()" onblur="fun3()" style="height:44px;line-height:24px;font-size:16px;">                     
					</div>
                    <div class="form-group input-group">
						<span class="input-group-addon"><img src="image/password_logo.png" class="pass_logo"  /></span>
						<input class="form-control" name="upassword1" id="password1" placeholder="请再次输入密码" type="password" onfocus="show4()" onblur="fun4()" style="height:44px;line-height:24px;font-size:16px;">                     
					</div>
                                        
                    
					<input type="submit" class="btn btn-primary btn-block" value="注册" style="background-color:F81B1F;height:44px;line-height:32px;font-size:16px;margin-top:30px;">
					<a class="btn btn-default btn-block" href="login.jsp" style="height:44px;line-height:32px;font-size:16px;margin-top:10px;">登录</a>
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

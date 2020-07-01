<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'query.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.box {
	width: 1500px;
	height: 1000px;
	margin: 0 auto;
	background: url(image/7065230ad9fe0e846f902db49278f057.jpg) no-repeat center;
	}
	</style>
  </head>
  
  <body>
  <center>
   <div class="box">
     <h2>按商品编号查询：</h2>
     <h3><a href="query1.jsp">切换至按商品名称查询</a></h3>
     
  	 <form action="QueryGoodServlet" class="form" method="post">
  	  	输入商品编号：<input type="text"  name="gid">
  	 	<input type="submit" class="button" value="查询">
  	 </form>
  	 <h4><a href="Goodall.jsp" class="button2">查看全部商品</a></h4>
  </center>
  </body>
</html>

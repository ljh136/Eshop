<%@page import="com.hls.bean.User"%>
<%@page import="com.hls.dao.DaoDB"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Horderuser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <%
		User user = (User) request.getAttribute("user");
        request.setAttribute("user",user);
		
    %>
    <br><br><br>
     <center>
    	<table width="50%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" onmouseover="changeto()"  onmouseout="changeback()">
    		<tr>
    			 <td width="50%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">用户名</span></div></td>
    			 <td width="50%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10"><%=user.getUname() %></span></div></td>
    		</tr>
    		<tr>
    			<td width="50%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">用户电话</span></div></td>
    			<td width="50%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10"><%=user.getUtel() %></span></div></td>
    		</tr>
    		<tr>
    			<td width="50%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">用户密码</span></div></td>
    			<td width="50%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10"><%=user.getUpassword() %></span></div></td>
    		</tr>
    		<tr>
    			<td width="50%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">用户邮箱</span></div></td>
    			<td width="50%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10"><%=user.getUemail() %></span></div></td>
    		</tr>
    		
    		<tr>
    			<td width="50%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">送货地址</span></div></td>
    			<td width="50%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10"><%=user.getAddress() %></span></div></td>
    		</tr>
    		<tr>
    			<td width="50%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">下单时间</span></div></td>
    			<td width="50%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10"><%=user.getUregtime() %></span></div></td>
    		</tr>
    		<tr>
    			<td width="50%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">送货电话</span></div></td>
    			<td width="50%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10"><%=user.getUstel() %></span></div></td>
    		</tr>
    		<tr >
    			<td colspan="2" width="50%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10"><a href="Horderlist.jsp">返回</a></span></div></td>
    		</tr>
    	
    </center>
  </body>
</html>

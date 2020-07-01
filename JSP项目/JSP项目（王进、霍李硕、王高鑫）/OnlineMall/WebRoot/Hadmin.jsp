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
    
    <title>My JSP 'Hadmin.jsp' starting page</title>
    
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
	width: 1700px;
	height: 800px;
	margin: 0 auto;
	background: url(image/20100929134225886.jpg) no-repeat center;
	}
	</style>
  </head>
  
  <body>
  <%
  	String admin_name =(String)session.getAttribute("admin_name");
  	DaoDB db = new DaoDB();
  	int admin_id = db.getadmin(admin_name);
   %>
  
  <div class="box">
  
    <table style="border-collapse:separate; border-spacing:0px 10px;" >
    <tr>
    		<td valign="middle">
            <div align="center" class="STYLE1"><font color="#000099" size="+3">管理员信息</font></div>
            </td>
    </tr>
    	<tr>
            <td valign="middle">
            <div align="center" class="STYLE1"><font color="#000099" size="+2">管理员编号：<%=admin_id %></font></div>
            
            </td>
        </tr>
        <tr>
        	<td valign="middle">
        	<div align="center" class="STYLE1"><font color="#000099" size="+2">管理员姓名：<%=admin_name %></font></div>
        	
        	</td>
        </tr>
        <tr>
        	<td valign="middle">
        	<div align="center" class="STYLE1"><font color="#000099" size="+2">欢迎<%=admin_id %>号管理员<%=admin_name %>登陆</font></div>
        	</td>
        </tr>
    </table>
 
   </div>
  </body>
</html>

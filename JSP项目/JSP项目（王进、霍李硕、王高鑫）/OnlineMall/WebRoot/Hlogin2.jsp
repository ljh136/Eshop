<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Hlogin2.jsp' starting page</title>
    
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
    <div style="background-image:url(image/guanliyuan.jpg)">
  
    <table style="border-collapse:separate; border-spacing:0px 10px;" >
    <tr>
    		<td valign="middle">
            <div align="center" class="STYLE1"><font color="#000099" size="+3">管理员信息</font></div>
            </td>
    </tr>
    	<tr>
            <td valign="middle">
            <table>
            	<tr></tr>
            </table>
            <div align="center" class="STYLE1"><font color="#000099" size="+2">管理员编号：</font></div>
            </td>
        </tr>
        <tr>
        	<td valign="middle">
        	<div align="center" class="STYLE1"><font color="#000099" size="+2">管理员姓名：</font></div>
        	</td>
        </tr>
        <tr>
        	<td valign="middle">
        	<div align="center" class="STYLE1"><font color="#000099" size="+2">欢迎号管理员登陆</font></div>
        	</td>
        </tr>
    </table>
 
   </div>
  </body>
</html>

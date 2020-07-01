<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow:hidden;
}
.STYLE1 {
	font-size: 12px;
	color: #a1c8c6;
}
.STYLE4 {color:#039; font-size: 12px; }
-->
</style>
  </head>
  
  <body>
    <form action="LoginServlet" method="post">
    
    <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">

  <tr>
    <td bgcolor="035551">&nbsp;</td>
  </tr>
  <tr>
    <td height="311" background="image/login_03.gif"><table width="758" border="0" align="center" cellpadding="0" cellspacing="0">
    
      <tr>
        <td height="210" background=""><h1 style="color:#3FC"> 管理员登录</h1>&nbsp;</td>
      </tr>
      <tr>
        <td height="101"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="446" height="101" background="image/login_06.gif">&nbsp;</td>
            <td width="156"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="29%" height="22"><span class="STYLE4">用户名</span></td>
                <td width="71" height="22"><input type="text" name="admin_name" style="width:100px; height:16px; border:solid 1px #000000; color:#666666"></td>
              </tr>
              <tr>
                <td height="22"><span class="STYLE4">密&nbsp;&nbsp;码</span></td>
                <td height="22"><input type="password" name="admin_password" style="width:100px; height:16px; border:solid 1px #000000; color:#666666"></td>
              </tr>
              <tr>
                <td height="25">&nbsp;</td>
                <td height="25">
                <input type="submit" value="登录"> 
                <button><a href="index.jsp">返回</a></button>
                </td>
                </tr>
            </table></td>
            <td width="156" background="image/login_09.gif">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td bgcolor="1f7d78">&nbsp;</td>
  </tr>
  <tr>
    <td bgcolor="1f7d78"></td>
  </tr>
 
</table>

 </form>
  </body>
</html>

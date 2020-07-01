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
    
    <title>My JSP 'Huserlist.jsp' starting page</title>
    
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
     <h2>用户信息列表：</h2>
    <table border="1" width="100%"  align="center" bgcolor="B6CBFC">
       <tr height="40px">
         <th width=7%>用户ID</th>
         <th width=8%>用户名</th>
         <th width=15%>用户电话</th>
         <th width=6%>用户密码</th>
         <th width=6%>用户邮箱</th>
         <th width=25%>用户地址</th>
         <th width=13%>密保问题</th>
         <th width=6%>密保答案</th>
       <tr>
       <%
		DaoDB shoplist = new DaoDB();
       	List list =shoplist.queryUser();
		for(int i=0;i<list.size();i++){
		
		User user =(User)list.get(i);
      %>
       <tr height="60px">
          <td><%=user.getUid() %></td>
          <td><%=user.getUname() %></td>
          <td><%=user.getUtel() %></td>
          <td><%=user.getUpassword() %></td>
          <td><%=user.getUemail() %></td>
          <td><%=user.getAddress() %></td>
          <td><%=user.getUanswer() %></td>
          <td><%=user.getUanswer() %></td>
         
       </tr>
     <%}%>
      
    </table>
  </body>
</html>

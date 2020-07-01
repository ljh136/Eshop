<%@page import="com.hls.bean.GoodsMark"%>
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
    
    <title>My JSP 'Hintroduce.jsp' starting page</title>
    
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
    	
    	int gid = Integer.valueOf(String.valueOf(request.getAttribute("gid"))) ;
		DaoDB db = new DaoDB();
		List list =db.getGoodmarkByid(gid);
		//System.out.print(list.size());
		for(int i=0;i<list.size();i++){
		GoodsMark mark = (GoodsMark)list.get(i);
		int uid = mark.getUid();
		User user = db.getUserByid(uid);
		
		
      %>
   <center>
   <div class="box">
   <font>
     <table >
     <tr>
     	<td><font color="#FFFFFF" size="+2">用户名：<%=user.getUname() %></font></td>
     </tr>
       <tr>
     	<td><font color="#FFFFFF" size="+2">用户评价：<%=mark.getGmark() %></font></td>
     </tr>
     <tr>
     	<td><font color="#FFFFFF" size="+2">用户评论时间：<%=mark.getGdate() %></font></td>
     </tr>
     <tr>
     	<td><font color="#FFFFFF" size="+2"><a href="Hdeletemarkservlet?mid=<%=mark.getMid() %>">删除该条评论</a></font></td>
     </tr>
     </table>
     </font>
     </div>
   </center>
         
      <%} %>
    
  </body>
</html>

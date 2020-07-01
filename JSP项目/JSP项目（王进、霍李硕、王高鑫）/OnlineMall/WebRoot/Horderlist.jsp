<%@page import="com.hls.bean.Order"%>
<%@page import="com.hls.dao.DaoDB"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单总表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/css.css">

  </head>
  
  <body>
  <h3>订单列表:</h3>
    <table border="1" width="100%"  align="center" bgcolor="B6CBFC">
       <tr height="40px">
         <th width=7%>订单编号</th>
         <th width=8%>用户编号</th>
         <th width=8%>商品编号</th>
         <th width=6%>订单状态</th>
         <th width=6%>购买数量</th>
         <th width=30%>购买日期</th>
         <th width=25%>操作</th>
       </tr>
      <%
     
		DaoDB shoplist = new DaoDB();
       	List list =shoplist.queryorder();
       	
		for(int i=0;i<list.size();i++){
		
		Order order = (Order)list.get(i);
		int otype = order.getOtype();
		request.setAttribute("otype",otype);
      %>
       <tr height="60px">
          <td><%=order.getOid() %></td>
          <td><%=order.getUid() %><a class="button1" href="Horderuserservlet?uid=<%=order.getUid()%>">详情</a></td>
          <td><%=order.getGid() %><a class="button1" href="Hordergoodservlet?gid=<%=order.getGid()%>">详情</a></td>
          <%
          if(otype==1){
          	%>
          <td>待出库</td>
          	
          <%} %>
          <%if(otype==2){ %>
          <td>已发货</td>
           <% }%>
           <%if(otype==3){ %>
           <td>已收货</td>
           <%} %>
           <%if(otype==4){ %>
           <td>订单已完成</td>
           <%} %>
           <%if(otype==5){ %>
           <td>商品已退货</td>
           <%} %>
          <td><%=order.getBnum() %></td>
          <td><%=order.getBdate() %></td>
          <%
          	if(otype!=1){
          %>
          		<td>已发货</td>
          	<%
          	}
           %>
           <%
           	if(otype==1){
           	%>
           		<td><a class="button1" href="Horderlistservlet?oid=<%=order.getOid()%>">发货</a></td>
           	<%
           	}
            %>
          
         <%} %>
       </tr>
       
  </body>
</html>

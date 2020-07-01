<%@page import="com.hls.bean.leaveword"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>按ID查询商品</title>
    
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
    <br>
    <%
        List good =(List)request.getAttribute("good");
        String[] value = ((leaveword)good.get(0)).getGpic().split(", |\\[|\\],\\[|\\]");
        request.setAttribute("good", good);
        int size=good.size();
        
        request.setAttribute("size", size);
        
        %>
        <c:if test="${size<=0 }">
				<h2>未搜索到该商品</h2>
				<h4><a href="Goodall.jsp" class="button2">查看全部商品</a></h4>
				<h4><a href="query.jsp" class="button2">返回继续查询</a></h4>
        </c:if>
        <c:if test="${size>0 }">
        <h2>搜索结果如下：</h2>
        <table border="1" width="100%"  align="center" bgcolor="B6CBFC">
        <tr height="40px">
         <th width=7%>商品ID</th>
         <th width=8%>商品名称</th>
         <th width=20%>商品图片</th>
         <th width=6%>商品价格</th>
         <th width=6%>库存数量</th>
         <th width=30%>商品介绍</th>
         <th width=13%>商品操作日期</th>
         <th width=13%>商品类型</th>
         <th width=13%>商品销量</th>
       <tr>
       <c:forEach var="list" items="${good }">
	   <tr height="60px">
          <td>${list.gid }</td>
          <td>${list.gname }</td>
          <td>
          <%
          if(value.length==1){
          	%>
          	<a href="PicDownloadServlet?filename=<%=value[0]%>"><img class="spimg" alt="<%=value[0]%>" src="<%=value[0]%>" ></a>
          	<%
          }
          	else{
          for(int s=1;s<value.length;s++){
          %>
          	<a href="PicDownloadServlet?filename=<%=value[s]%>"><img class="spimg" alt="<%=value[s]%>" src="<%=value[s]%>"></a>
          	<%
        		}
			}
           %>
          
          </td>
          <td>${list.gprice }</td>
          <td>${list.gnum }</td>
          <td>${list.gintroduce }</td>
          <td>${list.gdate }</td>
          <td>${list.gtypeid }</td>
          <td>${list.gsales }</td>
       </tr>
     </c:forEach>
     </table>
		<h4><a href="Goodall.jsp" class="button2">查看全部商品</a></h4>
		<h4><a href="query.jsp" class="button2">返回继续查询</a></h4>	
	</c:if>
  </body>
</html>

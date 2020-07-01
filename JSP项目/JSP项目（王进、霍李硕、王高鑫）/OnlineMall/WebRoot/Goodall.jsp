<%@page import="com.hls.bean.leaveword"%>
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
    
    <title>商品总表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/css.css">

  </head>
  
  <body>
    <%
    request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
   %>
   <h2>商品列表：</h2>
     <h3 align="right" >
     <a href="Insert.jsp"class="button" >添加商品</a>&emsp;
  	 <a href="query.jsp" class="button">查询商品</a>
  	 </h3>
    <table border="1" width="100%"  align="center" bgcolor="B6CBFC">
       <tr height="40px">
         <th width=7%>商品ID</th>
         <th width=8%>商品名称</th>
         <th width=15%>商品图片</th>
         <th width=6%>商品价格</th>
         <th width=6%>库存数量</th>
         <th width=25%>商品介绍</th>
         <th width=13%>商品上架日期</th>
         <th width=6%>商品销量</th>
         <th width=5%>用户评价</th>
         <th width=10%>操作</th>
       <tr>
       <%
		DaoDB shoplist = new DaoDB();
       	List list =shoplist.queryGoods();
		for(int i=0;i<list.size();i++){
		
		leaveword good = (leaveword)list.get(i);
      %>
       <tr height="60px">
          <td><%=good.getGid() %></td>
          <td><%=good.getGname()%></td>
          <td>
          <%
          String[] value = good.getGpic().split(", |\\[|\\],\\[|\\]");
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
          <td><%=good.getGprice() %></td>
          <td><%=good.getGnum() %></td>
          <td><%=good.getGintroduce() %></td>
          <td><%=good.getGdate() %></td>
          <td><%=good.getGsales() %></td>
          <%
          	List l = shoplist.getGoodmarkByid(good.getGid());
          	int size = l.size();
          	if(size!=0){
          	
           %>
          <td><a href="HGoodsMarkservlet?gid=<%=good.getGid() %>" >查看全部</a></td>
          <%} %>
          <% 
          if(size==0){
          %>
          <td>无</td>
          <%} %>
          <td>
          &nbsp;<a class="button1" href="UpdateServlet?gid=<%=good.getGid()%>">修改</a>
          <a class="button1" href="DeleteShopServlet?gid=<%=good.getGid()%>">下架</a>
          </td>
         
       </tr>
     <%}%>
      
    </table>
  </body>
</html>

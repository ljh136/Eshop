<%@page import="com.hls.bean.leaveword"%>
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
    
    <title>My JSP 'updateGood.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function addfile(){
	var input = document.createElement('input');  //创建input节点
input.setAttribute('type', 'file');  //定义类型是文本输入
input.setAttribute('name', 'upload');
document.getElementById('form').appendChild(input); //添加到form中显示

}
</script>
  </head>
  
  <%
    leaveword good = (leaveword) request.getAttribute("good");
    request.setAttribute("good", good);
    String[] value = good.getGpic().split(", |\\[|\\],\\[|\\]");
    
   %>
  <body>
  <center>
  <font color="#003399">
    <h2>修改商品</h2>
     </font>
    <form action="updateGoServlet" class="form" method="post" enctype="multipart/form-data">
     <div style="background-image:url(image/20100929134225886.jpg)">
    <table style="border-collapse:separate; border-spacing:0px 10px;">
    <tr height="50">
    <td>
    	<font color="#FFFFFF" size="+3">商品编号：${good.gid } <br/>
    		<input type="hidden" name="gid" value="${good.gid }"></font>
    </td>
    </tr>
    <tr height="50">
    <td>
	       <font color="#FFFFFF" size="+3"> 商品名称：</font><input type="text" name="gname" value="${good.gname }"><br>
	</td>
    </tr>
    <tr height="50">
    <td>
	      <font color="#FFFFFF" size="+3">  商品图片：</font>
	        <input type="file" name="upload" id="file">
         	<input type="button" class="button3" value="添加图片上传框" onclick="addfile()">
         	<p id="form"></p>
         	 <!--  
	        <input type="file" name="upload" ><br>
	        <img  class="spimg" src="${good.gpic } "></img><br><input type="file" name="upload" ><br>
	        <img  class="spimg" src="${good.gpic } "></img><br>
	        -->
	</td>
    </tr height="50">
    <tr>
    <td>
	     <font color="#FFFFFF" size="+3">商品价格：</font><input type="text" name="gprice" value="${good.gprice }"><br>
	</td>
    </tr>
    <tr height="50">
    <td>
	    <font color="#FFFFFF" size="+3"> 库存数量：</font><input type="text" name="gnum" value="${good.gnum }"><br>
	</td>
    </tr>
    <tr height="50">
    <td>
	       <font color="#FFFFFF" size="+3"> 商品介绍：</font><br>
	  	<textarea name="gintroduce" rows="10" cols="30" >${good.gintroduce } </textarea><br>
	</td>
    </tr>
    <tr height="50">
    <td>
	  	<font color="#FFFFFF" size="+3">商品类型：</font><input type="text" name="gtypeid" value="${good.gtypeid }"><br>
	</td>
    </tr>
    <tr height="150">
    <td>
	    &emsp;&emsp;&emsp;&emsp;<input type="submit" class="button" value="确认修改">&emsp;&emsp;&emsp;
	    	  <a href="Goodall.jsp" class="button">取消修改</a>
	</td>
    </tr>
	</table>
	</div>
    </form>
 
  </center>
  </body>
</html>

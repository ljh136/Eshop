<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Insert.jsp' starting page</title>
    
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
  
  <body>
  <center>
    <h1>添加商品</h1>
  <form action="HAddGoodsServlet" method="post" enctype="multipart/form-data">
    <table border="1" width="60%"  align="center" bgcolor="#a8c7ce" >
    	<tr>
         <td width=8%><font size="+3">商品名称</font></td>
         <td><input type="text" name="gname" style="width:200px; height:30px;" ></td>
        </tr>
        <tr>
         <td width=20%><font size="+3">商品图片</font></td>
         <td>
         	<input type="file" name="upload" id="file">
         	<input type="button" class="button3" value="添加图片上传框" onclick="addfile()">
         	 <p id="form"></p>
         </td>
        </tr>
        <tr>
         <td width=6%><font size="+3">商品价格</font></td>
         <td><input type="text" name="gprice" style="width:200px; height:30px;"></td>
        </tr>
        <tr>
         <td width=6%><font size="+3">库存数量</font></td>
         <td><input type="text" name="gnum" style="width:200px; height:30px;"></td>
        </tr>
        <tr>
         <td width=30%><font size="+3">商品介绍</font></td>
         <td><input type="text" name="gintroduce" style="width:200px; height:30px;"></td>
        </tr>
        <tr>
         <td width=10%><font size="+3">商品类型</font><font size="+2">(1.精选服装 2.电子商品 3.生活用品 4.休闲美食)</font></td>
         <td><input type="text" name="gtypeid" style="width:200px; height:30px;"></td>
        </tr>
    	<tr>
    		<td colspan="2" align="center">
    			<input type="submit" value="提交">
    			<input type="reset" value="重置">
    			<a href="Goodall.jsp">返回</a>
    		</td>
    		
    	</tr>
    </table>
  </form>
  </body>
</html>

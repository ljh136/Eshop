<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Amenu.jsp' starting page</title>
    
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
    <style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	color: #FFFFFF;
	font-weight: bold;
	font-size: 12px;
}
.STYLE2 {
	font-size: 12px;
	color: #03515d;
}
a:link {font-size:12px; text-decoration:none; color:#03515d;}
a:visited{font-size:12px; text-decoration:none; color:#03515d;}
-->
</style></head>

<body>
<table width="156" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" valign="top"><table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="33" background="image/main_21.gif">&nbsp;</td>
      </tr>
      <tr>
        <td height="20" background="image/main_25.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="13%">&nbsp;</td>
            <td width="72%" height="20"><div align="center">
              <table width="78%" height="21" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td><div align="center"><img src="image/top_8.gif" width="16" height="16"></div></td>
                  <td valign="middle"><div align="center" class="STYLE1">管理员操作</div></td>
                </tr>
              </table>
            </div></td>
            <td width="15%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td align="center" valign="top"><table width="145" border="0" align="center" cellpadding="0" cellspacing="0">
          
          <tr>
            <td><table width="130" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="41" height="35"><div align="center"><img src="image/left_1.gif" width="31" height="31"></div></td>
                  <td width="89" height="35"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td height="23" style="cursor:hand" onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><span class="STYLE2">&nbsp;
                      <a href="Hbuju4.jsp" target="_top">用户信息</a></span></td>
                    </tr>
                  </table></td>
                </tr>
                <tr>
                  <td width="41" height="35"><div align="center"><img src="image/left_1.gif" width="31" height="31"></div></td>
                  <td width="89" height="35"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td height="23" style="cursor:hand" onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><span class="STYLE2">&nbsp;
                      <a href="Hbuju3.jsp" target="_top">商品管理</a></span></td>
                    </tr>
                  </table></td>
                </tr>
                <tr>
                  <td width="41" height="35"><div align="center"><img src="image/left_2.gif" width="31" height="31"></div></td>
                  <td height="35"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td height="23" style="cursor:hand" onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><span class="STYLE2">&nbsp;
                      <a href="Hbuju2.jsp" target="_top">订单管理</a></span></td>
                    </tr>
                  </table></td>
                </tr>
                <tr>
                  <td width="41" height="35"><div align="center"><img src="image/left_3.gif" width="31" height="31"></div></td>
                  <td height="35"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td height="23" style="cursor:hand" onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><span class="STYLE2">&nbsp;
                      <a href="Loginh.jsp" target="_top">退出管理员</a></span></td>
                    </tr>
                  </table></td>
                </tr>
                
            </table></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="22" background="image/main_36.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="13%">&nbsp;</td>
            <td width="72%" height="20"><div align="center">
                <table width="78%" height="21" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td><div align="center"><img src="image/top_17.gif" width="16" height="16"></div></td>
                    <td valign="middle"><div align="center"><span class="STYLE1">信用评分</span></div></td>
                  </tr>
                </table>
            </div></td>
            <td width="15%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="22" background="image/main_36.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="13%">&nbsp;</td>
            <td width="72%" height="20"><div align="center">
                <table width="78%" height="21" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td><div align="center"><img src="image/top_16.gif" width="16" height="16"></div></td>
                    <td valign="middle"><div align="center"><span class="STYLE1">用户等级</span></div></td>
                  </tr>
                </table>
            </div></td>
            <td width="15%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="22" background="image/main_36.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="13%">&nbsp;</td>
            <td width="72%" height="20"><div align="center">
                <table width="78%" height="21" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td><div align="center"><img src="image/top_18.gif" width="16" height="16"></div></td>
                    <td valign="middle"><div align="center" class="STYLE1">诚信管理</div></td>
                  </tr>
                </table>
            </div></td>
            <td width="15%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="39" background="">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>

 
   </div>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  <h3> 登录页面</h3>
   <form action="upload" method="post" enctype="multipart/form-data">
     <table>
      <tr>
       <td>文件描述：</td>
       <td><input type="text" name="description"></td>
      </tr>
      <tr>
       <td>请选择文件：</td>
       <td><input type="file" name="file"></td>
      </tr>
      <tr>
       <td><input type="submit" value="提交"></td>
      </tr>
      </table>
	</form>
  </body>
</html>

<%@ page language="java" import="java.util.*,com.vo.Book" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<h3> 注册页面</h3>
 
${requestScope.message}
     <table>
      <tr>
      <th>书名</th><th>图片</th><th>作者</th>
      </tr>
      <c:forEach items="${requestScope.list}" var="Book">
      <tr>
       <td>${Book.bookname}</td>
       <td><img src="file/${Book.imagename}" height="60"></td>
       <td>${Book.author}</td>
      </tr>
      </c:forEach>
      </table>
  </body>
</html>

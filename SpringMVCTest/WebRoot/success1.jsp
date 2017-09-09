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
<h3> 显示页面</h3>
 
     <table>
      <tr>
      <th>编号</th><th>姓名</th><th>性别</th><th>年龄</th><th>班级</th><th>编号</th>
      </tr>
      <c:forEach items="${requestScope.studentlist}" var="Student">
      <tr>
       <td>${Student.id}</td>
       <td>${Student.name}</td>
       <td>${Student.sex}</td>
       <td>${Student.age}</td>
       <td>${Student.clazz.id}</td>
       <td>${Student.clazz.code}</td>
      </tr>
      </c:forEach>
      </table>
  </body>
</html>

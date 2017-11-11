<%@ page language="java" import="java.util.*,com.vo.Book,com.vo.*" pageEncoding="utf-8"%>
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
      <th>班级</th><th>编号</th><th>学生学号</th><th>学生姓名</th><th>性别</th><th>年龄</th>
      </tr>
      <%
       List list = (List)request.getAttribute("clazzlist");
       for(int i=0;i<list.size();i++){
       Clazz clazz=(Clazz)list.get(i);
       List list1=(List)clazz.getStudents();
       for(int j=0;j<list1.size();j++){
       Student student=(Student)list1.get(j);
       %>
      <tr>
       <td><%=clazz.getId()%></td>
       <td><%=clazz.getCode()%></td>
        <td><%=student.getId()%></td>
       <td><%=student.getName()%></td>
       <td><%=student.getSex()%></td>
       <td><%=student.getAge()%></td>
      </tr>
      <%
      } 
      }
      %>
      </table>
  </body>
</html>
<%-- <%
       List list = (List)request.getAttribute("clazzlist");
       for(int i=0;i<list.size();i++){
       Clazz clazz=(Clazz)list.get(i);
       List list1=(List)clazz.getStudents();
       for(int j=0;j<list.size();j++){
       Student student=(Student)list1.get(j);
       %>
      <tr>
       <td><%=clazz.getId()%></td>
       <td><%=clazz.getCode()%></td>
        <td><%=student.getId()%></td>
       <td><%=student.getName()%></td>
       <td><%=student.getSex()%></td>
       <td><%=student.getAge()%></td>
      </tr>
      <%
      } 
      }
      %> --%>
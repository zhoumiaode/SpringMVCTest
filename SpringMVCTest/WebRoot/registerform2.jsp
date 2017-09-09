<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
     <form:form action="people/register" method="post" commandName="people">
     <table>
      <tr>
       <td>登录名：</td>
       <td><form:input path="loginname" />
       <td><form:errors path="loginname" cssStyle="color:red"></form:errors></td>
      </tr>
      <tr>
       <td>密码：</td>
       <td><form:input path="password" />
       <td><form:errors path="password" cssStyle="color:red"></form:errors></td>
      </tr>
      <tr>
       <td>用户名：</td>
       <td><form:input path="username" />
       <td><form:errors path="username" cssStyle="color:red"></form:errors></td>
      </tr>
      <tr>
       <td>年龄：</td>
       <td><form:input path="age" />
       <td><form:errors path="age" cssStyle="color:red"></form:errors></td>
      </tr>
      <tr>
       <td>邮箱：</td>
       <td><form:input path="email" />
       <td><form:errors path="email" cssStyle="color:red"></form:errors></td>
      </tr>
      <tr>
       <td>生日：</td>
       <td><form:input path="birthDate" />
       <td><form:errors path="birthDate" cssStyle="color:red"></form:errors></td>
      </tr>
      <tr>
       <td>电话：</td>
       <td><form:input path="phone" />
       <td><form:errors path="phone" cssStyle="color:red"></form:errors></td>
      </tr>
      <tr>
       <td><input type="submit" value="提交"></td>
      </tr>
      </table>
	</form:form>
  </body>
</html>

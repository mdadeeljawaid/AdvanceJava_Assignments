<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bean Example jsp</title>
</head>
<body>
	<jsp:useBean id="studentobj" class="mybeans.Student" scope="request"/>
  <jsp:setProperty property="name" name="studentobj" value="Republic day"/>
   <jsp:setProperty property="id" name="studentobj" value="101" />
   <jsp:setProperty property="password" name="studentobj" value="1950"/>
   <jsp:setProperty property="dept" name="studentobj" value="India"/>
    <jsp:getProperty property="name" name="studentobj"/>
   <jsp:getProperty property="id" name="studentobj"/>
   <jsp:getProperty property="password" name="studentobj"/>
   <jsp:getProperty property="dept" name="studentobj"/>
  <%
    response.sendRedirect("BeansExample2.jsp");
  %>
</body>
</html>
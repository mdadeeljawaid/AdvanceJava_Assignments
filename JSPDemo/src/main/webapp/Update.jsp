<%@page import="dao.DbService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update JSP</title>
</head>
<body>
 <%@include file="Header.jsp" %>
  <%
    int rollno = Integer.parseInt((String)session.getAttribute("id"));
    String user =request.getParameter("uname");
    String pass  = request.getParameter("upass");
    String dept = request.getParameter("udept");
    int i = DbService.updateStudentInfo(rollno, user, pass, dept);
    if(i>0){%>
    	<jsp:forward page="Login.jsp">
    	   <jsp:param value="Your profile is updated successfully" name="msg"/>
    	</jsp:forward> 
 <%  }
    else {  %>
    	  <jsp:forward page="UpdateForm.jsp"></jsp:forward>
   <%  }%> 
  
  %>
 <%@page file="Footer.html"%>

</body>
</html>
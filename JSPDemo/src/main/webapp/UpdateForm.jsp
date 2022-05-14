<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Form</title>
</head>
<body>
  <%
   String rollno= request.getParameter("id");
   session.setAttribute("id",rollno);
  
  %>
  <form method="post" action="Update.jsp">
    Username : <input type="text" name="uname">
    Password : <input type="password" name="upass">
    Student Dept <select name="udept">
                      <option value="cs"> CS </option>
                      <option value="it"> IT </option>
                      <option value="ece"> ECE </option>
                      <option value="me"> ME </option>
                  </select>
     <input type="submit" value="Update">
  
  </form>

</body>
</html>
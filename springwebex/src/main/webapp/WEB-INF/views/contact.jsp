<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Us</title>
</head>
<body>
	Address : <% String add = (String)request.getAttribute("address"); %>
	<h3><%=add %></h3>
	Mobile No : <% String mob = (String)request.getAttribute("mobile"); %>
	<h3><%=mob %></h3>
	Email : <% String mail = (String)request.getAttribute("email"); %>
	<h3><%=mail %></h3>

</body>
</html>
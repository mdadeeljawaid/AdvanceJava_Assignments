<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="dao.DbService"%>
 <%@page import="java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Student</title>
<style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
          
        th, td {
            text-align: left;
            padding: 8px;
        }
          
        tr:nth-child(even) {
            background-color: Lightgreen;
        }
    </style>
</head>
<body>
  <%@include file="Header.jsp"%>
 <div align="center" "width: 100%;height: 500px;">
  <table border=1 >
  <tr> 
    <th> Roll No </th>
    <th> Student Name </th>
    <th> Student Password </th>
    <th> Student Department </th>
    <th> Update </th>
    <th> Delete </th>
  </tr>
  <%
    ResultSet rs =DbService.fetchStudent();
    while(rs.next()){
    	
    	int rno=rs.getInt(1);
    	String n=rs.getString(2);
    	String p=rs.getString(3);
    	String d=rs.getString(4);  %>
    	<tr> 
    	<td>  <%=rno %> </td>
    	<td> <%=n %> </td>
    	<td> <%=p %> </td>
    	<td> <%=d %>  </td>
    	<td> <a href = "UpdateForm?id=<%=rno %>" > Update</a></td>
    	<td> <a href ="DeleteStudent?id=<%=rno %>" > Delete</a>  </td>
    	
    	</tr>
    	
 <%  }
  
   %>
   
   </table>
  </div>
    <jsp:include page="Footer.html"></jsp:include>

</body>
</html>
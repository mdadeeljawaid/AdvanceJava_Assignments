<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About Us</title>s
</head>
<body>
 <%--  <% String uname = (String)request.getAttribute("name"); 
       String umail =(String)request.getAttribute("email");
     %> 
  --%>    
     User : ${name}
     Email: ${email}
     ${name eq email} 
     ${10/2} 
     <c:set var="x" value="10"/>
    
     <c:if test="${x>=10}" >
      <h4> 
         <c:out value="value of x  is ${x}"></c:out>
      </h4>
     
     </c:if>
     
     <c:forEach begin="1" end="10" step="2" var="i" >
        <c:out value="${i}"/><br>
     </c:forEach>
     <c:set value="12" var="age"/>
     <c:choose>
        <c:when test="${age>=18}">
          <c:out value="valid age to cast vote "></c:out> 
        </c:when>
        <c:when test="${age<18 }">
          <c:out value="Nadan balak"></c:out>
        </c:when>
        <c:otherwise>
          <c:out value="you are in other universe "></c:out>
        </c:otherwise>
     
     
     </c:choose>
     <c:set var="name" value="jetha laal"/>
     <c:set var="lname" value="motawani"/>
     <c:if test="${fn:endsWith(name,'laal')}">
       <c:out value="endswth mo"></c:out>
       ${fn:length(name)} 
     </c:if>
     <c:set var="tax" value="30000.6789"/>
     <fmt:parseNumber integerOnly="true" type="number" value="${tax}" var="t"></fmt:parseNumber>
     Tax is ${t}
     
     <c:set var="tdate" value="02-09-2022"></c:set>
     <fmt:parseDate value="${tdate}"  var="parseddate" pattern="dd-MM-yyyy"/>
     Date is ${parseddate} 
    
    <c:set var="today" value="<%=new Date() %>" ></c:set>
    <fmt:formatDate value="${today}" type="time" var="tt"/>
    <fmt:formatDate value="${today}" type="date" var="dt"/>
    <fmt:formatDate value="${today}" type="time" var="stt" timeStyle="short"/>
     <fmt:formatDate value="${today}" type="date" var="mtt" dateStyle="medium"/>
   <fmt:formatDate value="${today}" type="both" var="ndt" dateStyle="short" 
   timeStyle="medium"/> 
   <br>
   time is  ${tt}  <br>
   date is  ${dt}  <br>
   short time is   ${stt} <br>
   medium date is  ${mtt}     <br>
   dateandtime both is ${ndt}  <br>
    
     
</body>
</html>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First Jsp Java Server Pages</title>
</head>
<body>
  <h1> Hello JSP </h1>
  <ul>
    <li>Faster Deployment</li>
    <li>Easy To Maintain</li>
    <li>Extension Of Servlet</li>
    
    <%! int i =10; %>
  
    
    <%
       if(i%2==0){ 
       
     %>
    	<h1>  <%="even" %>  </h1>
    <%    } 
      else{ 
    	  
        %>
    	   <%="odd" %>
      <% 
      }  
      %>
    
   
    
   
   
   </ul>

</body>
</html>
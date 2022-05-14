package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondLogin
 */
@WebServlet("/SecondLogin")
public class SecondLogin extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String name="aayush";
		String pass="1234";
		 PrintWriter out=  response.getWriter();
		 String user=request.getParameter("uname");
		  // getParameter(param name) it return string object 
		 String password =request.getParameter("upass").trim();
		 if(name.equals(user) && password.equals(pass)) {
			 out.print("Successfull login");
			 //  creating cookie 
			 Cookie cookie = new Cookie("name",user);
			 cookie.setHttpOnly(true);
			 cookie.setDomain("www.cdac.com");
			
			 // sending cookie in response
			 response.addCookie(cookie);
			 
		 }
		 else {
			 out.println("invalid username or password");
		 }
	}

}

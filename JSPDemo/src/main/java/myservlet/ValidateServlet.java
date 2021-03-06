package myservlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbService;

/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	try {
		String user=request.getParameter("user");
		String password = request.getParameter("pass");
		ResultSet rs =DbService.validate(user, password);
		if(rs.next()) {
			response.sendRedirect("ViewStudent.jsp");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			request.setAttribute("msg", "Invalid username or password");
			rd.forward(request, response);
		}
	}catch(SQLException e) {
		System.err.println("sql exception while validate"+e);
	  }
	}

}

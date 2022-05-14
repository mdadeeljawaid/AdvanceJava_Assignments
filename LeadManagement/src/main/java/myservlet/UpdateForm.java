package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateForm
 */
@WebServlet("/UpdateForm")
public class UpdateForm extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		HttpSession hs = request.getSession();
		if(!hs.isNew() && hs!=null) {
	    response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String eid =request.getParameter("id").trim();
		String n = request.getParameter("name");
		hs.setAttribute("employeeid",eid);
		 out.println("<html>");
		  out.println("<body>");
		  out.println("<form action=UpdateServlet method=post>");
		 // out.println("<input type =text name=uid value="+eid+" hidden > <br>");
		  out.println("<input type =text name=uname value="+n+"> <br>");
		  out.println("<input type =password name=upass > <br>");
		  out.println("<input type =submit value=Update > <br>");
		  out.println("</form>");
		  out.println("</body>");
		  out.println("</html>");
		}
		else {
			response.sendRedirect("index.html");
		 }
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

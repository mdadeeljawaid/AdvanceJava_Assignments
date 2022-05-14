package myservlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbFactory;
import dao.IDbService;

/**
 * Servlet implementation class GetCity
 */
@WebServlet("/GetCity")
public class GetCity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stateid=request.getParameter("s_id");
		if(stateid!=null) {
			IDbService service=DbFactory.getDbService();
            ResultSet rs;
			try {
				rs = service.fetchData("select city_id,city_name from city_master "
						+ "where city_state_id="+stateid);
				StringBuilder sb=new StringBuilder();
				while(rs.next()){					    
		            sb.append("<option value="+rs.getString(1)+">"+rs.getString(2)+"</option>");
		            }
				//final response
				response.getWriter().println(sb.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

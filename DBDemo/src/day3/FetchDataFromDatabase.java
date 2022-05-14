package day3;

import java.sql.*;
import java.util.Scanner;

public class FetchDataFromDatabase {
	
	
	static void displayStudentData(Statement stmt) throws SQLException {
		
		String selQry="select sid,sname,sdept from student";
		//String selQry="select * from student";
		ResultSet rs=stmt.executeQuery(selQry);	//passing query for getting ResultSet reference	
		//Boolean found=rs.next();
		System.out.println("*******Student Details********");
		System.out.println("________________________________________________");
		System.out.println("ID\t\tName\t\tDepartment");
		//fetching data row by row
		while(rs.next()) {
			//getting and displaying row data
			System.out.println(rs.getInt(1)+"\t\t|"+rs.getString(2)+"\t\t|"+rs.getString(3));
			System.out.println("_______________________________________________");
		}
		/*else
			System.out.println("No record found!!!!");*/
	}
	
   static boolean authStudent(Statement stmt,String sid,String spass) throws SQLException {
		String authQry="select sname from student where sid="+sid+" and spass='"+spass+"'";
		ResultSet rs=stmt.executeQuery(authQry);
		Boolean found=false;//flag
		if(rs.next()) {
			System.out.println("Login Success!!!");
			System.out.println("Welcome:"+rs.getString(1));
			found=true;			
		}
		else
		{
			System.out.println("Invalid ID/Password");
		}	
		return found;
	}
   

	public static void main(String[] args) {
		
		String user="root";
		String password="mysql";
		String dbName="cdac";
		String url="jdbc:mysql://127.0.0.1/"+dbName;
		Connection con=null;
       try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    con=DriverManager.getConnection(url, user, password);
		if(con!=null) {
			//System.out.println("connected");
			Statement stmt=con.createStatement();
			//displayStudentData(stmt);	//to display data
			//to check authStudent method
			Scanner sc=new Scanner(System.in);
			System.out.println("Input your credientails to login:");
			System.out.print("Enter your Student Id:");
			String sid=sc.nextLine();
			System.out.print("Enter your Password:");
			String spass=sc.nextLine();			
			//authStudent(stmt, id, pwd);
			if(authStudent(stmt, sid, spass)) {
				displayStudentData(stmt);
			}
			
		}		
		
	} catch (ClassNotFoundException | SQLException e) {		
		e.printStackTrace();
	}
       finally {
    	   try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }
       
	}

}
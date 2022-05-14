package day3;

import java.sql.*;
import java.util.Scanner;

public class PreparedStatementDemo {

	static boolean authStudentPrepared(PreparedStatement pstmt) throws SQLException {
		ResultSet rs=pstmt.executeQuery();
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
			
			PreparedStatement stmt=con.prepareStatement("select sname from student where sid=? and spass=?");
			
			//to check authStudent method
			Scanner sc=new Scanner(System.in);
			System.out.println("Input your credientails to login:");
			System.out.print("Enter your Student Id:");
			int id=sc.nextInt();
			System.out.print("Enter your Password:");
			sc.nextLine();
			String pwd=sc.nextLine();	
			stmt.setInt(1, id);//setting/passing parameter id value
			stmt.setString(2, pwd);//setting/passing parameter password value			
			authStudentPrepared(stmt);
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

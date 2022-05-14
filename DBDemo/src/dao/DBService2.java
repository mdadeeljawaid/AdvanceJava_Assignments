package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DBService2 implements DbInterface{
	static Connection con=null;
	private static String user="root";
	private static String password="1234";
	private  static String dbName="cdac";
	@Override
	public Connection getConnection() {
		try {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/"+dbName;
		//Step 1 load driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Step 2  establish connection 
	    con=  DriverManager.getConnection(url,user,password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch(ClassNotFoundException ex) {
			System.out.println("Driver class not found"+ex);
	   
	    }
		return con;
	}

	@Override
	public void insertData() {
		int i =0;
		// TODO Auto-generated method stub
		  String query ="insert into student values(?,?,?,?)";
		    PreparedStatement ps;
			try {
				   ps = con.prepareStatement(query);
				   Scanner sc = new Scanner(System.in);
				   	System.out.println("enter student id");
				   	int id =sc.nextInt();
				   	System.out.println("enter student name");
				   	String name = sc.next();
				   	System.out.println("enter student password");
				   	String pass=sc.next();
				   	System.out.println("enter student department ");
				   	String dept=sc.next();
				   	ps.setInt(1, id);
				   	ps.setString(2,name);
				   	ps.setString(3,pass);
				   	ps.setString(4, dept);
				   	i = ps.executeUpdate();
				   	if(i>0) {
				   		System.out.println("data is inserted ");
				   	}else {
				   		System.out.println("data insertion failed");
				   	}
				   	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		 
		
	}

}

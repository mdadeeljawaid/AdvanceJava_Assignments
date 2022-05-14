package day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DbOps {
    private static String user="root";
    private static String password="mysql";
    private  static String dbName="cdac";
    
    public static void insertData(Statement s) throws SQLException {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("enter student id");
    	int id =sc.nextInt();
    	System.out.println("enter student name");
    	String name = sc.next();
    	System.out.println("enter student password");
    	String pass=sc.next();
    	System.out.println("enter student department ");
    	String dept=sc.next();
    	String query ="insert into student values ("+id+",'"+name+"','"+pass+"','"+dept+"')";
    	int i =s.executeUpdate(query);
    	if(i!=0) {
    		System.out.println("Data is inserted");
    	}
    	else {
    		System.err.println("Data insertion failed ");
    	}
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try {
		String url="jdbc:mysql://localhost:3306/"+dbName;
		//Step 1 load driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Step 2  establish connection 
		Connection con=  DriverManager.getConnection(url,user,password);
	    if (con!=null) {
	    	System.out.println("Connection done successfully");
	    	// Step 3  create statement interface refrence 
	        Statement s = con.createStatement();
	        insertData(s);
	    }
	   }
	catch(ClassNotFoundException ex) {
		System.out.println("Driver class not found"+ex);
	    }
	catch(SQLException ex) {
		System.err.println("SQL exception while connection"+ex);
	  }
	}

}

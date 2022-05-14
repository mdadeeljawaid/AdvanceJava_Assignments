package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import beans.StudentBean; 

public class DbService {
	static Connection con=null;
	private static String user="root";
	private static String password="mysql";
	private  static String dbName="cdac";
	static {
		try {
			String url="jdbc:mysql://localhost:3306/"+dbName;
			//Step 1 load driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Step 2  establish connection 
			con=  DriverManager.getConnection(url,user,password);
			if (con!=null) {
				System.out.println("Connection done successfully");
				// Step 3  create statement interface refrence 
			}
		}
		catch(ClassNotFoundException ex) {
			System.out.println("Driver class not found"+ex);
		}   catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int insertData() throws SQLException {
		String query ="insert into student values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
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
		int i = ps.executeUpdate();
		return i;
	}


	public static ResultSet fetchData() throws SQLException { 
		String query="select * from student"; 
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		return rs;


	}
	
	public static int updateStatus(StudentBean s) throws SQLException {
		String query = "update student set status = 1 where sid = ? and sname = ? and spass=?";
		PreparedStatement ps = con.prepareStatement(query) ;
		ps.setInt(1, s.getId());
		ps.setString(2, s.getName());
		ps.setString(3, s.getPassword());
		int i = ps.executeUpdate();
		return i;	
	}
	
	public static ArrayList<StudentBean> studentNames() throws SQLException{
		ArrayList<StudentBean> al = new ArrayList<StudentBean>();
		
		String query = "select * from student";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			StudentBean sb = new StudentBean();
			String name= rs.getString(2);
			sb.setName(name);
			al.add(sb);
		}
		return al;
	}
	
	public static void addData(int id,String dname) throws SQLException {
		CallableStatement cs = con.prepareCall("call addDeptData(?,?)");
		cs.setInt(1, id);
		cs.setString(2, dname);
		cs.execute();
//		boolean status = cs.execute();
//		if(status) {
//			System.out.println("dept is added");
//		}
		con.close();
	}

}

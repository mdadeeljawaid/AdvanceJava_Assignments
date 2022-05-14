package day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MenuDriven {

	private static String user="root";
	private static String password="mysql";
	private static String dbName="cdac";

	public static void insertData(Statement s) throws SQLException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student Id");
		int id = sc.nextInt();
		System.out.println("Enter Student Name");
		String name= sc.next();
		System.out.println("Enter Student password");
		String pass=sc.next();
		System.out.println("Enter Student department");
		String dept=sc.next();
		String query="insert into student values("+id+",'"+name+"','"+pass+"','"+dept+"')";
		int i = s.executeUpdate(query);
		if(i!=0) {
			System.out.println("data is inserted");
		}
		else {
			System.out.println("data insertion failed");
		}
	}
	public static void updateData(Statement s) throws SQLException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student Id");
		int id = sc.nextInt();
		System.out.println("Enter Student Name");
		String name= sc.next();
		String query ="update student set sname=('"+name+"') WHERE sid=("+id+")";
//		System.out.println("Enter Student password");
//		String password= sc.next();
//		String query ="update student set spass=('"+pass+"') WHERE sid=("+id+")";
		int i = s.executeUpdate(query);
		if(i!=0) {
			System.out.println("data is updated");
		}
		else {
			System.out.println("data updation failed");
		}
	}
	public static void deleteData(Statement s) throws SQLException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student Id");
		int id = sc.nextInt();
		String query="DELETE FROM student where sid=("+id+")";
		int i = s.executeUpdate(query);
		if(i!=0) {
			System.out.println("data is deleted");
		}
		else {
			System.out.println("data deletion failed");
		}	
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			String url="jdbc:mysql://localhost:3306/"+dbName;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			if(con!=null) {
				System.out.println("Connection done successfuly");
				Statement s = con.createStatement();
				char ch;
				int n;
				do {

					System.out.println("1. for Insert");
					System.out.println("2. for Update");
					System.out.println("3. for Delete");
					System.out.println("enter your choice:");
					n=sc.nextInt();
					switch(n)
					{	
					case 1:	
						insertData(s);
						break;
					case 2:
						updateData(s);
						break;
					case 3:
						deleteData(s);
						break;	
					case 4:
						System.exit(0);
						break;
					default:
						System.out.println("invalid option");	
					}
					System.out.println("Do you want to continue[y/n]: ");
					ch=sc.next().charAt(0);
				}while(ch=='y' || ch=='Y');
				sc.close();
			}

		}
		catch(ClassNotFoundException ex) {
			System.out.println("Driver class not found"+ex);
		}
		catch(SQLException ex) {
			System.out.println("SQL exception while connection"+ex);
		}
	} 

}
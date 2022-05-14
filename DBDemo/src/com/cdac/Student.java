package com.cdac;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import dao.DbService;
import beans.StudentBean;

public class Student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter 1 to insert data");
		System.out.println("enter 2 to view data");
		System.out.println("enter 3 to authorize user");
		System.out.println("enter 4 to fetch user");
		System.out.println("enter 5 to add dept data");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your choice");
		int ch =sc.nextInt();
		switch (ch) {
		case 1:
			try {
			  int i =DbService.insertData();
			  if(i>0) {
				  System.out.println("data is inserted");
			  }
			  else {
				  System.out.println("data insertion failed");
			  }
			}
			catch (SQLException e) {
				System.err.println("sql exception while inserting data"+e);
			}
			break;
		case 2:
			try {
			  ResultSet rs=	DbService.fetchData();
			  String data=" ";
			  while(rs.next()) {
				  int id=rs.getInt(1);
				  String n =rs.getString(2);
				  String p=rs.getString("spass");
				  String d= rs.getString("sdept");
				  data= data+id+"\t" + "\t"+n+"\t"+p+"\t"+d+"\n";
			  }
			  System.out.println(data);
			}
			catch (SQLException e) {
				System.err.println("sql exception while inserting data"+e);
			}
			break;
		case 3:
			try {
			 sc = new Scanner(System.in);
			 System.out.println("enter employee id");
			 int eid = sc.nextInt();
			 System.out.println("enter employee name");
			 String n = sc.next();
			 System.out.println("enter employee password");
			 String p = sc.next();
			 StudentBean sb = new StudentBean(eid,n,p);
			 int i = DbService.updateStatus(sb);
			 if(i>0) {
				  System.out.println("data is updated");
			  }
			  else {
				  System.out.println("data updation failed");
			  }
			}
			catch (SQLException e) {
				System.err.println("sql exception while inserting data"+e);
			}
			break;
		case 4:
			try {
				ArrayList<StudentBean> slist = DbService.studentNames();
				for (StudentBean sb : slist) {
					System.out.println(sb.getName());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			try {
				 sc = new Scanner(System.in);
				 System.out.println("enter dept id");
				 int did = sc.nextInt();
				 System.out.println("enter dept name");
				 String n = sc.next();
				 DbService.addData(did, n);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		default:
			break;
		}
		
	}

}

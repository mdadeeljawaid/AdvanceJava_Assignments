package com.cdac;

import java.sql.Connection;

import dao.DBService2;

public class Employee {
	
	public static void main(String[] args) {
		DBService2 db = new DBService2();
		Connection con =db.getConnection();
		
	}

}

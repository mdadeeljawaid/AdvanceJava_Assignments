package dao;

import java.sql.Connection;
import java.util.ArrayList;

import beans.StudentBean;

public interface DbInterface {
	
	public abstract Connection getConnection();
	public abstract  void insertData();

}

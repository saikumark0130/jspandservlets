package com.firstapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	Connection connection; //int a=5;
	
	public Connection getConnection() throws SQLException, ClassNotFoundException{ //public int add(){
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","123456");
		System.out.println("Connection created.....");
		return connection; //return a;
 
	}
}
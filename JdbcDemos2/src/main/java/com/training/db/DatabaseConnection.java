package com.training.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static Connection connection;
	
	public static Connection getConnection()
	{
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/bookstore";
		
		// load the jdbc driver 
		try {
			Class.forName(jdbcDriver); //loads the driver class
			connection = DriverManager.getConnection(dbUrl, "root", "root");
			if(connection!=null)
				System.out.println("Connection Successful...");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return connection;
	}
	
	public static void main(String[] args) {
		
		getConnection();
	}

}

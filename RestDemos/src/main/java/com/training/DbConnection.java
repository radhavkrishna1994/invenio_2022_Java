package com.training;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
	public static final String PROPERTIES_FILE = "dbconfig.properties";
	public static Properties properties = new Properties();
	
	private  Properties readProperties() {
	    InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE);
	    if (inputStream != null) {
	        try {
	            properties.load(inputStream);
	        } catch (IOException e) {
	            // TODO Add your custom fail-over code here
	            e.printStackTrace();
	        }
	    }
	    return properties;
	}
	
	public  Connection getConnection()
	{
		Properties properties = readProperties();
		Connection connection=null;
		try {
			//step 1  load the driver
			Class.forName(properties.getProperty("jdbcDriverClass"));
			//Step 2 get the connection
			
			connection = DriverManager.getConnection(properties.getProperty("dbUrl"),
					properties.getProperty("username"),
					properties.getProperty("password"));
		//	System.out.println(connection);
				
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
		return connection;
		}
	}
	
}


package com.bv.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnect {
	public static Connection getConnection()
	{
		//step1. create Properties class object
		Connection connection = null;
		try {
		FileInputStream fis = new FileInputStream("C:\\bureau veritas\\Connection.properties");
		Properties properties = new Properties();
		//step2.load the properties file
		properties.load(fis);
		//load the data from properties files using key
		String driverclass = (String) properties.get("driverclass");
		String url = (String) properties.get("url");
		String username = (String) properties.get("username");
		String password = (String) properties.get("password");
		
		Class.forName(driverclass);
		System.out.println("Driver found");
		connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connection established");
		}
		catch(IOException | SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
		return connection ;
	}
}

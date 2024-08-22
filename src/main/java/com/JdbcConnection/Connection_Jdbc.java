package com.JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connection_Jdbc {
	public static Connection con;
	public static Connection getConn()
	{
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/learning_project","root","shamika@12345");

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
	

}

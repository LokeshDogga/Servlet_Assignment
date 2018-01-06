package com.accolite.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {

	private static Connection conn;

	private DB_Connection()
	{

	}
	public static Connection get_Db_Connection() throws SQLException
	{
		try {
			if(conn == null) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/au","root","root");  
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return conn;
	}


}

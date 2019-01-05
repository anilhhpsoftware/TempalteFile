package com.hhpsoftware.util;
 
import java.sql.*;
 
public class DBConnection 
{
	
	public static Connection createConnection()
	{
		 Connection con = null;
		 String url = "jdbc:mysql://localhost:3306/customers"; 
		 String username = "root"; 
		 String DRIVER = "com.mysql.cj.jdbc.Driver";
		 String password = "mysql";
		
			try 
			{
				
				Class.forName(DRIVER); 
				System.out.println("hiiii");
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Printing connection object "+con);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return con; 
	}
}

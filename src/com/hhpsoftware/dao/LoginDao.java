package com.hhpsoftware.dao;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.hhpsoftware.bean.LoginBean;
import com.hhpsoftware.util.DBConnection;
public class LoginDao 
{
	 public String authenticateUser(LoginBean loginBean)
	 {
		 //int id Integer.parseInt(id);
		 //String number = loginBean.getPhoneNumber();
		 String userName = loginBean.getName(); 
		 String password = loginBean.getPassword();
		 //String email = loginBean.getEmail(); 
		
 
		 Connection con = null;
		 Statement statement = null;
		 ResultSet resultSet = null;
 
		 String userNameDB = "";
		 String passwordDB = "";
		 String QUERY = "SELECT * FROM users WHERE name = '"+
				 userName+"'  AND passwords = '"+password+"' ";
		 try
		 {
			 con = DBConnection.createConnection(); 
			 statement = con.createStatement(); 
			 resultSet = statement.executeQuery(QUERY); 
 
			 while(resultSet.next()) 
			 {
				 userNameDB = resultSet.getString("username"); 
				 passwordDB = resultSet.getString("password");
 
				 if(userName.equals(userNameDB) && password.equals(passwordDB))
				 {
					 return "SUCCESS"; 
				 }
			 }
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 return "Invalid user credentials"; 
	}
}

 
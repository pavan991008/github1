package com.studentregistrationapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOimpl implements DAO {
    private Connection con;
    private Statement stmnt;
	@Override
	public void connectDB() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentappreg","root","Pavan@08");
		  stmnt = con.createStatement();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
	@Override
	public boolean verifyCredentials(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("Select * from login where email = '"+email+"' and password = '"+password+"'");
			return result.next();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

	@Override
	public void saveRegistration(String name, String city, String email, String mobile) {
		// TODO Auto-generated method stub
		try {
			stmnt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet listAllRegistrations() {
		// TODO Auto-generated method stub
		try {
			ResultSet result = stmnt.executeQuery("Select * from registration");
			return result;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	


	@Override
	public void deleteRegistration(String email) {
		// TODO Auto-generated method stub
		try {
			stmnt.executeUpdate("Delete from registration where email = '"+email+"'");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	public void UpdateRegistration(String email, String mobile, String city) {
		// TODO Auto-generated method stub
		try {
			stmnt.executeUpdate("Update registration SET mobile = '"+mobile+"', city = '"+city+"' WHERE email= '"+email+"'");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}


	

	

}

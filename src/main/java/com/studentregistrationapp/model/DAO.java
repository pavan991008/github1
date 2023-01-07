package com.studentregistrationapp.model;

import java.sql.ResultSet;

public interface DAO {
	public void connectDB();
	public boolean verifyCredentials(String email,String password);
	public void saveRegistration(String name,String city,String email,String mobile);
	public void deleteRegistration(String email);
	public ResultSet listAllRegistrations();
	public void UpdateRegistration(String email,String mobile, String city);
	

}

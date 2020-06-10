package com.capgemini.flightmanagementsystem.dao;

import com.capgemini.flightmanagementsystem.dto.AdminLogin;

public interface AdminLoginDao
{
	
	public AdminLogin auth(String email,String password);

	public boolean register(AdminLogin bean);
	
	

}

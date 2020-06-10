package com.capgemini.flightmanagementsystem.service;

import com.capgemini.flightmanagementsystem.dto.AdminLogin;

public interface AdminLoginService {

	public AdminLogin auth(String email,String password);

	public boolean register(AdminLogin bean);
	
}

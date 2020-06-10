package com.capgemini.flightmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.flightmanagementsystem.dao.AdminLoginDao;
import com.capgemini.flightmanagementsystem.dto.AdminLogin;

@Service

public class AdminLoginServiceImpl implements AdminLoginService{
	 @Autowired
		private AdminLoginDao dao;
		
		@Override
		public AdminLogin auth(String email, String password) {
			return dao.auth(email, password);
		}

		@Override
		public boolean register(AdminLogin bean) {
			BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
			String encodedPassword = encoder.encode(bean.getPassword());
			bean.setPassword(encodedPassword);
			return dao.register(bean);
		}
}

package com.capgemini.flightmanagementsystem.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.flightmanagementsystem.dto.LoginResponse;
import com.capgemini.flightmanagementsystem.exception.MailAlreadyExistException;

@RestControllerAdvice
public class AdminLoginAdvice {
	@ExceptionHandler(MailAlreadyExistException.class)
	public LoginResponse handleLoginException(MailAlreadyExistException e) {
		LoginResponse response = new LoginResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}
}

package com.capgemini.flightmanagementsystem.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.flightmanagementsystem.dto.Response;
import com.capgemini.flightmanagementsystem.exception.MailAlreadyExistException;

@RestControllerAdvice
public class AirportControllerAdvice {
	@ExceptionHandler(MailAlreadyExistException.class)
	public Response mailAlreadyExist(MailAlreadyExistException e) {
		Response response = new Response();
		response.setStatusCode(501);
		response.setMessage("exception");
		response.setDescription(e.getMessage());	
		return response;
	
	}
	
}

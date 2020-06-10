package com.capgemini.flightmanagementsystem.exception;

@SuppressWarnings("serial")
public class MailAlreadyExistException extends RuntimeException {
	
	public MailAlreadyExistException(String message) {
		super(message);
	}

}

package com.capgemini.flightmanagementsystem.dto;


import java.util.List;

import lombok.Data;

@Data
public class Response {
	private int statusCode;
	private String message;
	private String description;
	private AdminLogin adminLogin;
	
	private ScheduledFlight scheduledFlight;
	private List<ScheduledFlight> flightList;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public AdminLogin getAdminLogin() {
		return adminLogin;
	}
	public void setAdminLogin(AdminLogin adminLogin) {
		this.adminLogin = adminLogin;
	}
	public ScheduledFlight getScheduledFlight() {
		return scheduledFlight;
	}
	public void setScheduledFlight(ScheduledFlight scheduledFlight) {
		this.scheduledFlight = scheduledFlight;
	}
	public List<ScheduledFlight> getFlightList() {
		return flightList;
	}
	public void setFlightList(List<ScheduledFlight> flightList) {
		this.flightList = flightList;
	}
	
	

}

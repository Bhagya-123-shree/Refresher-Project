package com.capgemini.flightmanagementsystem.service;

import java.util.List;

import com.capgemini.flightmanagementsystem.dto.ScheduledFlight;

public interface ScheduledFlightService {
	
public List<ScheduledFlight> getAllFlight();
	
	public boolean addScheduledFlight(ScheduledFlight scheduledflight);
	
	public boolean updateScheduledFlight(ScheduledFlight scheduledflight);
	
	public boolean deleteScheduledFlight(String scheduledFId);
	

}

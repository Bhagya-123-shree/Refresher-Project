package com.capgemini.flightmanagementsystem.dao;

import java.util.List;

import com.capgemini.flightmanagementsystem.dto.ScheduledFlight;

public interface ScheduledFlightDao {
	
	public List<ScheduledFlight> getAllFlight();
	
	public boolean addScheduledFlight(ScheduledFlight scheduledflight);
	
	public boolean updateScheduledFlight(ScheduledFlight scheduledflight);
	
	public boolean deleteScheduledFlight(String scheduledFId);
	
    
}

package com.capgemini.flightmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flightmanagementsystem.dao.ScheduledFlightDao;
import com.capgemini.flightmanagementsystem.dto.ScheduledFlight;

@Service
public class ScheduledFlightServiceImpl implements ScheduledFlightService{

	@Autowired
	private ScheduledFlightDao dao;
	
	@Override
	public List<ScheduledFlight> getAllFlight() {
		return dao.getAllFlight();
	}

	@Override
	public boolean addScheduledFlight(ScheduledFlight scheduledflight) {
		return dao.addScheduledFlight(scheduledflight);
	}

	@Override
	public boolean updateScheduledFlight(ScheduledFlight scheduledflight) {
		return dao.updateScheduledFlight(scheduledflight);
	}

	@Override
	public boolean deleteScheduledFlight(String scheduledFId) {
		return dao.deleteScheduledFlight(scheduledFId);
	}
	

}

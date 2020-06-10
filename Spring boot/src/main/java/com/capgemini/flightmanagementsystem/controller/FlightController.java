package com.capgemini.flightmanagementsystem.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightmanagementsystem.dto.Response;
import com.capgemini.flightmanagementsystem.dto.ScheduledFlight;
import com.capgemini.flightmanagementsystem.service.ScheduledFlightService;

@RestController
@CrossOrigin(origins ="*",allowedHeaders="*",allowCredentials ="true")
public class FlightController {
	
	@Autowired
	private ScheduledFlightService flightService; 
	
	@PostMapping(path = "/addScheduledFlight", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response addScheduledFlight(@RequestBody ScheduledFlight bean) {
		Response response = new Response();
		if (flightService.addScheduledFlight(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Flight Details added successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Flight Details not added successfully");
		}
		return response;
		
	}
	@PostMapping(path = "/update-scheduledflightDetails", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response updateScheduledFlightDetails(@RequestBody ScheduledFlight bean) {
		Response response = new Response();
		if(flightService.updateScheduledFlight(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Flight Details updated successfully");
			response.setFlightList(Arrays.asList(bean));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("unable to update scheduled flight details" );
		}
		return response;
	}
	@GetMapping(path = "/getAllFlight",produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllFlight() {
	List<ScheduledFlight> flightList = flightService.getAllFlight();
		Response response = new Response();
		if(flightList != null && !flightList.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Flights record found");
			response.setFlightList(flightList);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Flights record not found" );
		}
		return response;
		}
	
	@DeleteMapping(path="/delete-scheduledflight/{scheduledFId}", produces= MediaType.APPLICATION_JSON_VALUE)
	public Response deleteScheduledFlight(@PathVariable("scheduledFId") String scheduledFId) {
		Response response = new Response();
		if(flightService.deleteScheduledFlight(scheduledFId)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("deleted");
			
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("deleted" );
		}
			return response;
		}
	}


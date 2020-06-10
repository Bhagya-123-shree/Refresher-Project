package com.capgemini.flightmanagementsystem.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "scheduled_flight")
public class ScheduledFlight implements Serializable {
	@Id
	@Column
	private String scheduledFId;
	@Column
	private String flightName;
	@Column
	private String source;
	@Column
	private String destination;
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private String departureDate;
	@Column
	private String departureTime;
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private String arrivalDate;
	@Column
	@JsonFormat(pattern = "HH:mm")
	private String arrivalTime;
	@Column
	private int availableSeats;

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	
//	public AdminLogin getAdmin() {
//		return admin;
//	}
//
//	public void setAdmin(AdminLogin admin) {
//		this.admin = admin;
//	}
	

	public String getScheduledFId() {
		return scheduledFId;
	}

	public void setScheduledFId(String scheduledFId) {
		this.scheduledFId = scheduledFId;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}



//	@Exclude
//	@ManyToOne(cascade = CascadeType.ALL)
//	private AdminLogin admin;
//	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "flight")
//	// @JsonIgnore
//	// private Collection<Ticket>
//	
//	
}

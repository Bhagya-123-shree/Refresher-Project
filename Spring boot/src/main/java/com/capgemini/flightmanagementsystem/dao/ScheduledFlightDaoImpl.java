package com.capgemini.flightmanagementsystem.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.flightmanagementsystem.dto.ScheduledFlight;

@Repository
public class ScheduledFlightDaoImpl implements ScheduledFlightDao {
	
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public List<ScheduledFlight> getAllFlight() {
		String jpql = "select f from ScheduledFlight f";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<ScheduledFlight> query = manager.createQuery(jpql, ScheduledFlight.class);
		List<ScheduledFlight> flightList = query.getResultList();	
		return flightList;
		
	}

	@Override
	public boolean addScheduledFlight(ScheduledFlight scheduledflight) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			manager.persist(scheduledflight);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			for(StackTraceElement element : e.getStackTrace()) {
				System.out.println(element.toString());
			}
		}
		manager.close();
		return isAdded;
	}

	@Override
	public boolean updateScheduledFlight(ScheduledFlight flight) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		ScheduledFlight flightBean= manager.find(ScheduledFlight.class, flight.getScheduledFId());
		try {
			transaction.begin();
			flightBean.setSource(flight.getScheduledFId());
			flightBean.setSource(flight.getSource());
			flightBean.setDestination(flight.getDestination());
			flightBean.setDepartureDate(flight.getDepartureDate());
			flightBean.setDepartureTime(flight.getDepartureTime());
			flightBean.setArrivalDate(flight.getArrivalDate());
			flightBean.setArrivalTime(flight.getArrivalTime());
			flightBean.setAvailableSeats(flight.getAvailableSeats());
			
			manager.persist(flightBean);
			transaction.commit();
		
		return true;
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		for (StackTraceElement element : e.getStackTrace()) {
			element.toString();
		}
	}
		manager.close();
		return false;
	}

	@Override
	public boolean deleteScheduledFlight(String scheduledFId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		ScheduledFlight bean = manager.find(ScheduledFlight.class, scheduledFId);
		manager.remove(bean);
		transaction.commit();
		
		return true;
	}

}

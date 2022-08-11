package com.flightbook.service;

import java.util.List;

import com.flightbook.entity.FlightEntity;
import com.flightbook.exception.FlightNotFoundException;
import com.flightbook.model.Flight;

public interface FlightService {
	public FlightEntity saveOrUpdateFlight(Flight flight);
	public List<FlightEntity> findByFromAndTo(String from, String to) throws FlightNotFoundException;
	
	// Save flight from ui side
	public FlightEntity saveUIFlight(FlightEntity flightEntity);
	public List<FlightEntity> showAllFlight();
	public void deleteFlightByFlightId(String flightId);
	public FlightEntity editFlightByFlightId(String flightId);
}

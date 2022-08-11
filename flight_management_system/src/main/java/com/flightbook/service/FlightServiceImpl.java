package com.flightbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbook.entity.FlightEntity;
import com.flightbook.exception.FlightNotFoundException;
import com.flightbook.model.Flight;
import com.flightbook.repository.FlightRepo;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepo flightRepo;

	@Override
	public FlightEntity saveOrUpdateFlight(Flight flight) {
		FlightEntity flightEntity = new FlightEntity();
		flightEntity.setFlightId(flight.getFlightId());
		flightEntity.setFlightname(flight.getFlightName());
		flightEntity.setFrom(flight.getFrom());
		flightEntity.setTo(flight.getTo());
		flightEntity.setScheduleDate(flight.getScheduleDate());

		return flightRepo.save(flightEntity);
	}

	@Override
	public List<FlightEntity> findByFromAndTo(String from, String to) throws FlightNotFoundException {
		List<FlightEntity> searchFlight = flightRepo.findByFromAndTo(from, to);
		if (searchFlight.size() == 0) {
			throw new FlightNotFoundException("There is no flight available on this route !!");
		}
		return searchFlight;
	}

	
	// Save flight from ui side
	@Override
	public FlightEntity saveUIFlight(FlightEntity flightEntity) {
		return flightRepo.save(flightEntity);
	}

	@Override
	public List<FlightEntity> showAllFlight() {
		return flightRepo.findAll();
	}

	@Override
	public void deleteFlightByFlightId(String flightId) {
		flightRepo.deleteById(flightId);
	}

	@Override
	public FlightEntity editFlightByFlightId(String flightId) {
		return flightRepo.findById(flightId).get();
	}

}

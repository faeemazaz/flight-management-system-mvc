package com.flightbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightbook.entity.FlightEntity;
import com.flightbook.exception.FlightNotFoundException;
import com.flightbook.model.Flight;
import com.flightbook.service.FlightService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FlightController {

	@Autowired
	private FlightService flightService;

	@RequestMapping(value = "/rest/flight", method = RequestMethod.POST)
	public FlightEntity saveFlight(@RequestBody Flight flight) {
		return flightService.saveOrUpdateFlight(flight);
	}

	@RequestMapping(value = "/rest/flight/{from}/{to}", method = RequestMethod.GET)
	public List<FlightEntity> fetchFlightFindByFromAndTo(@PathVariable String from, @PathVariable String to) throws FlightNotFoundException {
		return flightService.findByFromAndTo(from, to);
	}
	
	@RequestMapping(value = "/rest/flight", method = RequestMethod.PUT)
	public FlightEntity updateFlight(@RequestBody Flight flight) {
		return flightService.saveOrUpdateFlight(flight);
	}

}

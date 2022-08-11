package com.flightbook.uicontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flightbook.entity.FlightEntity;
import com.flightbook.exception.FlightNotFoundException;
import com.flightbook.service.FlightService;

@Controller
public class FlighUiController {
	@Autowired
	private FlightService flightService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goToFlightSearch(Model mdl) {
		mdl.addAttribute("title", "Search Flight");
		mdl.addAttribute("flightfield", new FlightEntity());
		return "getFlights";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchFlight(HttpServletRequest req, Model mdl) throws FlightNotFoundException {
		try {
			
			List<FlightEntity> getFlights = flightService.findByFromAndTo(req.getParameter("from"), req.getParameter("to"));
			mdl.addAttribute("flights", getFlights);
			mdl.addAttribute("flightfield", new FlightEntity());
			System.out.print(getFlights);
		} catch (FlightNotFoundException e) {
			mdl.addAttribute("error", e.getMessage());
			mdl.addAttribute("flightfield", new FlightEntity());
			System.out.print(e.getMessage());
		}
		return "getFlights";
	}
	
	@RequestMapping(value = "/addflight", method = RequestMethod.GET)
	public String goToAddFlight(Model mdl) {
		mdl.addAttribute("title", "Add Flight");
		mdl.addAttribute("flight", new FlightEntity());
		return "addFlight";
	}
	
	@RequestMapping(value = "/flight", method = RequestMethod.POST)
	public String addFlight(@ModelAttribute FlightEntity flight, Model mdl) {
		flightService.saveUIFlight(flight);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/showflight", method = RequestMethod.GET)
	public String showAllFlight(Model mdl) {
		mdl.addAttribute("title", "Flights");
		List<FlightEntity> getFlights = flightService.showAllFlight();
		mdl.addAttribute("flights", getFlights);
		return "getAllFlights";
	}
	
	@RequestMapping(value = "/delflight/{flightId}", method = RequestMethod.GET)
	public String delelteFlightById(@PathVariable String flightId) {
		flightService.deleteFlightByFlightId(flightId);
		return "redirect:/showflight";
	}
	
	@RequestMapping(value = "/editflight/{flightId}", method = RequestMethod.GET)
	public String editFlightById(@PathVariable String flightId, Model mdl) {
		mdl.addAttribute("title", "Update Flight");
		FlightEntity flight = flightService.editFlightByFlightId(flightId);
		mdl.addAttribute("flight", flight);
		return "addFlight";
	}
}

package com.flightbook.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightbook.entity.BookEntity;
import com.flightbook.exception.BookingUnauthorizedException;
import com.flightbook.model.Booking;
import com.flightbook.service.BookingService;

@RestController
public class BookingController {
	@Autowired
	private BookingService bookingService;

	@RequestMapping(value = "/rest/booking", method = RequestMethod.POST)
	public BookEntity insertBooking(@RequestBody Booking booking) {
		return bookingService.saveAndUpdateBooking(booking);
	}

	@RequestMapping(value = "/rest/cancelbooking/{user_id}/{booking_id}", method = RequestMethod.PUT)
	public String cancelBooking(@PathVariable Long user_id, @PathVariable String booking_id) {
		bookingService.cancelBooking("Deactive", user_id, booking_id);
		return "Booking successfully canceled";
	}

	@RequestMapping(value = "/rest/editbooking", method = RequestMethod.PUT)
	public BookEntity updateBooking(@RequestBody Booking booking) throws BookingUnauthorizedException, ParseException {
		return bookingService.getBooking(booking);
	}
}

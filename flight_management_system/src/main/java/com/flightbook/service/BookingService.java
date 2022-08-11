package com.flightbook.service;

import java.text.ParseException;
import java.util.List;

import com.flightbook.entity.BookEntity;
import com.flightbook.exception.BookingUnauthorizedException;
import com.flightbook.model.Booking;
import com.flightbook.model.BookingList;

public interface BookingService {
	public BookEntity saveAndUpdateBooking(Booking booking);
	public BookEntity getBooking(Booking booking) throws BookingUnauthorizedException, ParseException;
	public void cancelBooking(String status, Long user_id, String booking_id);
	
	// methods for ui controller
	public List<BookEntity> getBookingAllBooking(String status);
	List<BookingList> getFlightBookingByUserId(Long user_id, String status);
	Booking editBookingByBookinId(String booking_id) throws BookingUnauthorizedException;
}

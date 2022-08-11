package com.flightbook.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbook.entity.BookEntity;
import com.flightbook.entity.FlightEntity;
import com.flightbook.entity.UserEntity;
import com.flightbook.exception.BookingUnauthorizedException;
import com.flightbook.model.Booking;
import com.flightbook.model.BookingList;
import com.flightbook.repository.BookRepo;
import com.flightbook.repository.FlightRepo;
import com.flightbook.repository.UserRepo;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookRepo bookRepo;

	@Autowired
	private FlightRepo flightRepo;
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public BookEntity saveAndUpdateBooking(Booking booking) {

		Optional<FlightEntity> getFlightReference = flightRepo.findById(booking.getFlightId());
		Optional<UserEntity> getUserReference = userRepo.findById(booking.getId());

		BookEntity bookEntity = new BookEntity();
		bookEntity.setBookingId(booking.getBookingId());
		bookEntity.setPasengerName(booking.getPasengerName());
		bookEntity.setStatus(booking.getStatus());
		bookEntity.setFlightEntity(getFlightReference.get());
		bookEntity.setUserEntity(getUserReference.get());

		return bookRepo.save(bookEntity);
	}

	@Override
	public BookEntity getBooking(Booking booking) throws BookingUnauthorizedException, ParseException {
		Optional<FlightEntity> getFlightReference = flightRepo.findById(booking.getFlightId());
		Optional<UserEntity> getUserReference = userRepo.findById(booking.getId());
		Date today = new Date();
		Date scheduledDate = getFlightReference.get().getScheduleDate();
		int compareDate = scheduledDate.compareTo(today);
		System.out.print(compareDate);
		BookEntity bookEntity = new BookEntity();
		if (compareDate > 0) {
			bookEntity.setBookingId(booking.getBookingId());
			bookEntity.setPasengerName(booking.getPasengerName());
			bookEntity.setStatus(booking.getStatus());
			bookEntity.setFlightEntity(getFlightReference.get());
			bookEntity.setUserEntity(getUserReference.get());
			bookRepo.save(bookEntity);
		} else {
			throw new BookingUnauthorizedException(
					"You are unauthorized to edit booking ticket beacause sheduled flight date is gone !!");
		}
		return bookEntity;
	}

	// methods for ui controller
	@Override
	public List<BookEntity> getBookingAllBooking(String status) {
		return bookRepo.findAllByStatus(status);
	}

	@Override
	public void cancelBooking(String status, Long user_id, String booking_id) {
		bookRepo.cancelBooking(status, user_id, booking_id);
	}

	@Override
	public List<BookingList> getFlightBookingByUserId(Long user_id, String status) {
		return bookRepo.getFlightBookingByUserId(user_id, status);
	}

	@Override
	public Booking editBookingByBookinId(String booking_id) throws BookingUnauthorizedException {
		BookingList getFlightByBookingId = bookRepo.getFlightId(booking_id);
		Booking getBookings = bookRepo.getFlightByBookingId(getFlightByBookingId.getBookingId());
		Date today = new Date();
		Date scheduledDate = getFlightByBookingId.getScheduleDate();
		int compareDate = scheduledDate.compareTo(today);
		if (compareDate < 0) {
			throw new BookingUnauthorizedException(
					"You are unauthorized to edit booking ticket beacause sheduled flight date is gone !!");
		}
		
		return getBookings;
	}

}

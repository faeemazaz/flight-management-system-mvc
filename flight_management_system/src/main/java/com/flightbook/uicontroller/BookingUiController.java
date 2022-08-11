package com.flightbook.uicontroller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flightbook.entity.UserEntity;
import com.flightbook.exception.BookingUnauthorizedException;
import com.flightbook.model.Booking;
import com.flightbook.model.BookingList;
import com.flightbook.repository.UserRepo;
import com.flightbook.service.BookingService;

@Controller
public class BookingUiController {
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private UserRepo userRepo;
	
	@RequestMapping(value = "/bookflight/{flightId}", method = RequestMethod.GET)
	public String goToBookingFlight(@PathVariable String flightId, Model mdl, Principal principal) {
		mdl.addAttribute("title", "Book Tickets");
		UserEntity userEntity = userRepo.findByUserName(principal.getName());
		Booking booking = new Booking();
		booking.setFlightId(flightId);
		booking.setId(userEntity.getId());
		
		mdl.addAttribute("book", booking);
		return "addBooking";
	}
	
	@RequestMapping(value = "/booking", method = RequestMethod.POST)
	public String bookingFlight(Model mdl, @ModelAttribute Booking booking) {
		bookingService.saveAndUpdateBooking(booking);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/mybooking", method = RequestMethod.GET)
	public String gotToMyBooking(Model mdl, Principal principal) {
		mdl.addAttribute("title", "Your Bookings");
		UserEntity userEntity = userRepo.findByUserName(principal.getName());
		List<BookingList> getbookings = bookingService.getFlightBookingByUserId(userEntity.getId(), "Active");
		mdl.addAttribute("bookings", getbookings);
		return "myBooking";
	}
	
	@RequestMapping(value = "/editBooking/{bookingId}", method = RequestMethod.GET)
	public String editMyBooking(Model mdl, @PathVariable String bookingId, Principal principal) throws BookingUnauthorizedException {
		mdl.addAttribute("title", "Update Bookings");
		try {
			Booking bookingList = bookingService.editBookingByBookinId(bookingId);
			mdl.addAttribute("book", bookingList);
			return "addBooking";
		} catch (BookingUnauthorizedException e) {
			UserEntity userEntity = userRepo.findByUserName(principal.getName());
			List<BookingList> getbookings = bookingService.getFlightBookingByUserId(userEntity.getId(), "Active");
			mdl.addAttribute("error", "You are not authorized to edit this booking because flight is already flying !!");
			mdl.addAttribute("bookings", getbookings);
			System.out.println(e.getMessage());
			return "myBooking";
		}
	}
	
	@RequestMapping(value = "/cancelBooking/{bookingId}", method = RequestMethod.GET)
	public String cancelBooking(@PathVariable String bookingId, Model mdl, Principal principal) {
		UserEntity userEntity = userRepo.findByUserName(principal.getName());
		bookingService.cancelBooking("Deactive", userEntity.getId(), bookingId);
		return "redirect:/mybooking";
	}
}

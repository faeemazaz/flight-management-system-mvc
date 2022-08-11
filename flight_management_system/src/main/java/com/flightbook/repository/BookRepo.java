package com.flightbook.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightbook.entity.BookEntity;
import com.flightbook.exception.BookingUnauthorizedException;
import com.flightbook.model.Booking;
import com.flightbook.model.BookingList;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, String> {
	List<BookEntity> findAllByStatus(String status);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "UPDATE book_table SET status = ?1 WHERE user_id = ?2 and booking_id = ?3")
	void cancelBooking(String status, Long user_id, String booking_id);
	
	@Query("SELECT new com.flightbook.model.BookingList(b.bookingId, b.pasengerName, b.status, f.scheduleDate, f.flightname) FROM BookEntity b JOIN b.flightEntity f JOIN b.userEntity u WHERE u.id = ?1 AND b.status = ?2")
	List<BookingList> getFlightBookingByUserId(Long user_id, String status);
	
	@Query("SELECT new com.flightbook.model.BookingList(b.bookingId, b.pasengerName, b.status, f.scheduleDate, f.flightname) FROM BookEntity b JOIN b.flightEntity f WHERE b.bookingId = ?1")
	BookingList getFlightId(String booking_id)throws BookingUnauthorizedException;
	
	@Query("SELECT new com.flightbook.model.Booking(b.bookingId, b.pasengerName, b.status, f.flightId, u.id) FROM BookEntity b JOIN b.flightEntity f JOIN b.userEntity u WHERE b.bookingId = ?1")
	Booking getFlightByBookingId(String booking_id);
}

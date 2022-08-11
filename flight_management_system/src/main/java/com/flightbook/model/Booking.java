package com.flightbook.model;

public class Booking {

	private String bookingId;
	private String pasengerName;
	private String status;
	private String flightId;
	private Long id;

	public Booking(String bookingId, String pasengerName, String status, String flightId, Long id) {
		super();
		this.bookingId = bookingId;
		this.pasengerName = pasengerName;
		this.status = status;
		this.flightId = flightId;
		this.id = id;
	}

	public Booking() {

	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getPasengerName() {
		return pasengerName;
	}

	public void setPasengerName(String pasengerName) {
		this.pasengerName = pasengerName;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

//	public Long getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}

	public String getStatus() {
		return status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

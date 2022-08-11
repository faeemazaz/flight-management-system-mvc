package com.flightbook.model;

import java.util.Date;

public class BookingList {
	private String bookingId;
	private String pasengerName;
	private String status;
	private Date scheduleDate;
	private String flightname;

	public BookingList(String bookingId, String pasengerName, String status, Date scheduleDate, String flightname) {
		this.bookingId = bookingId;
		this.pasengerName = pasengerName;
		this.status = status;
		this.scheduleDate = scheduleDate;
		this.flightname = flightname;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getFlightname() {
		return flightname;
	}

	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}

}

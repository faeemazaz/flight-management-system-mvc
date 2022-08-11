package com.flightbook.model;

import java.util.Date;

public class Flight {

	private String flightId;
	private String flightName;
	private String from;
	private String to;
	private Date scheduleDate;

	public Flight() {

	}

	public Flight(String flightId, String flightName, String from, String to, Date scheduleDate) {
		this.flightId = flightId;
		this.flightName = flightName;
		this.from = from;
		this.to = to;
		this.scheduleDate = scheduleDate;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

}

package com.flightbook.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "FLIGHT_TABLE")
public class FlightEntity {
	@Id
	@Column
	private String flightId;

	@Column
	private String flightname;

	@Column(name = "from_location")
	private String from;

	@Column(name = "to_location")
	private String to;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date scheduleDate;

	@JsonManagedReference("flight")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "flightEntity")
	private List<BookEntity> bookEntities;

	public FlightEntity() {

	}

	public FlightEntity(String flightId, String flightname, String from, String to, Date scheduleDate,
			List<BookEntity> bookEntities) {
		super();
		this.flightId = flightId;
		this.flightname = flightname;
		this.from = from;
		this.to = to;
		this.scheduleDate = scheduleDate;
		this.bookEntities = bookEntities;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getFlightname() {
		return flightname;
	}

	public void setFlightname(String flightname) {
		this.flightname = flightname;
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

	public List<BookEntity> getBookEntities() {
		return bookEntities;
	}

	public void setBookEntities(List<BookEntity> bookEntities) {
		this.bookEntities = bookEntities;
	}

}

package com.flightbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "BOOK_TABLE")
public class BookEntity {
	@Id
	@Column
	private String bookingId;

	@Column
	private String pasengerName;

	private String status;

	@JsonBackReference("flight")
	@ManyToOne(targetEntity = FlightEntity.class)
	@JoinColumn(name = "flight_id")
	private FlightEntity flightEntity;

	@JsonBackReference("booking")
	@ManyToOne(targetEntity = UserEntity.class)
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;

	public BookEntity() {

	}

	public BookEntity(String bookingId, String pasengerName, String status, FlightEntity flightEntity,
			UserEntity userEntity) {
		this.bookingId = bookingId;
		this.pasengerName = pasengerName;
		this.status = status;
		this.flightEntity = flightEntity;
		this.userEntity = userEntity;
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

	public FlightEntity getFlightEntity() {
		return flightEntity;
	}

	public void setFlightEntity(FlightEntity flightEntity) {
		this.flightEntity = flightEntity;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

}

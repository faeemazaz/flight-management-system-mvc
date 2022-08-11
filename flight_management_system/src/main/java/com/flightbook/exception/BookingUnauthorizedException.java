package com.flightbook.exception;

public class BookingUnauthorizedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookingUnauthorizedException(String message) {
		super(message);
	}
}

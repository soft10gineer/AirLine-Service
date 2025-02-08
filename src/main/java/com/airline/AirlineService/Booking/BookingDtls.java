package com.airline.AirlineService.Booking;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="flight_booking", schema="air_booking")

public class BookingDtls {
	
	@Id
	@Column(name= "bkng_id")
	private String bookingId;
	
	@Column(name= "usr_id")
	private String userId;
	
	@Column(name= "flight_id")
	private String flightId;
	
	@Column(name= "seat_nmbr")
	private String seatNumber;
	
	@Column(name= "crtd_at")
	private LocalDateTime createdDate;
	
	@Column(name= "bkng_sts")
	private String bookingStatus;
	
	
	public BookingDtls(){
		
	};
	
	public BookingDtls(String bookingId, String userId, String flightId, String seatNumber, LocalDateTime createdDate,
			String bookingStatus) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.flightId = flightId;
		this.seatNumber = seatNumber;
		this.createdDate = createdDate;
		this.bookingStatus = bookingStatus;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
	

}

package com.airline.AirlineService.Flight;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "airlines_names", schema= "air_name")

public class FlightDtls {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="air_id")
	private Integer airId;
	
	@Column(name="air_airline_name")
	private String airName;
	
	@Column(name="air_flight_number")
	private String airFlightNumber;
	
	@Column(name="air_departure_time")
	private LocalDateTime airDepartureTime;
	
	@Column(name="air_arrival_time")
	private LocalDateTime airArrivalTime;
	
	@Column(name="air_price")
	private Long airPrice;
	
	@Column(name="air_departure_airport_id")
	private String airDepartureId;
	
	@Column(name = "air_arrival_airport_id")
	private String airArrivalId;
	
	@Column(name="air_available_seats")
	private Integer airSeats;
	
	public FlightDtls() {}
	
	public FlightDtls(Integer airId, String airName, String airFlightNumber, LocalDateTime airDepartureTime,
			LocalDateTime airArrivalTime, Long airPrice, String airDepartureId, String airArrivalId, Integer airSeats) {
		super();
		this.airId = airId;
		this.airName = airName;
		this.airFlightNumber = airFlightNumber;
		this.airDepartureTime = airDepartureTime;
		this.airArrivalTime = airArrivalTime;
		this.airPrice = airPrice;
		this.airDepartureId = airDepartureId;
		this.airArrivalId = airArrivalId;
		this.airSeats = airSeats;
	}

	public Integer getAirId() {
		return airId;
	}

	public void setAirId(Integer airId) {
		this.airId = airId;
	}

	public String getAirName() {
		return airName;
	}

	public void setAirName(String airName) {
		this.airName = airName;
	}

	public String getAirFlightNumber() {
		return airFlightNumber;
	}

	public void setAirFlightNumber(String airFlightNumber) {
		this.airFlightNumber = airFlightNumber;
	}

	public LocalDateTime getAirDepartureTime() {
		return airDepartureTime;
	}

	public void setAirDepartureTime(LocalDateTime airDepartureTime) {
		this.airDepartureTime = airDepartureTime;
	}

	public LocalDateTime getAirArrivalTime() {
		return airArrivalTime;
	}

	public void setAirArrivalTime(LocalDateTime airArrivalTime) {
		this.airArrivalTime = airArrivalTime;
	}

	public Long getAirPrice() {
		return airPrice;
	}

	public void setAirPrice(Long airPrice) {
		this.airPrice = airPrice;
	}

	public String getAirDepartureId() {
		return airDepartureId;
	}

	public void setAirDepartureId(String airDepartureId) {
		this.airDepartureId = airDepartureId;
	}

	public String getAirArrivalId() {
		return airArrivalId;
	}

	public void setAirArrivalId(String airArrivalId) {
		this.airArrivalId = airArrivalId;
	}

	public Integer getAirSeats() {
		return airSeats;
	}

	public void setAirSeats(Integer airSeats) {
		this.airSeats = airSeats;
	}
	
	
	
}

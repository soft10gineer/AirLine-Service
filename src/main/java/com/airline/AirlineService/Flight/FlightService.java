package com.airline.AirlineService.Flight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
	
	@Autowired
	private FlightRepository flightrepository;
	
	public List<FlightDtls> getAllFlight() {
		return flightrepository.findAll(); 
	}
	
	public String flightSeatAvailability(String flightNumber) {
		FlightDtls flight = flightrepository.findByFlightNumber(flightNumber);
		if(flight==null) {
			return "No Flight Found";
		} else {
			if(flight.getAirSeats()==0) {
				return "No Seats Left";
			}
			
			return flight.getAirSeats().toString();
		}
		
	}

}

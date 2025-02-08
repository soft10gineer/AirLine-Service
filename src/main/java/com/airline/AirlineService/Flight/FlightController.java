package com.airline.AirlineService.Flight;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired
	private FlightService flightservice;
	
	@GetMapping("/all")
	public List<FlightDtls> getAllFlights() {
		return flightservice.getAllFlight();
	}
	
	@GetMapping("/seat-available")
	public String flightSeatAvailability(@RequestBody Map<String, Object> userBody) {
		String flightNumber = (String) userBody.get(("Flight Number"));
		return flightservice.flightSeatAvailability(flightNumber);
		 
	}
}

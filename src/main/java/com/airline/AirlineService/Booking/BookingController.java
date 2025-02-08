package com.airline.AirlineService.Booking;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingservice;
	
	public String newTicketBooking(@RequestBody Map<String, Object> userBody) {
		
		bookingservice.ticketBooking(userBody);
		return "String";
	}
}

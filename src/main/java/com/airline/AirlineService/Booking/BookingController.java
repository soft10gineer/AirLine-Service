package com.airline.AirlineService.Booking;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingservice;
	
	@PostMapping("/ticket")
	public String newTicketBooking(@RequestBody Map<String, Object> userBody) {
		
		return bookingservice.ticketBooking(userBody);
	}
	
	@GetMapping("/user")
	public List<BookingDtls> findBookingsOfUser(@RequestBody Map<String, String> userBody) {
		String leadId = userBody.get("LeadId");
		System.out.println(leadId);
		return bookingservice.findBookingsOfUser(leadId);
	}
}

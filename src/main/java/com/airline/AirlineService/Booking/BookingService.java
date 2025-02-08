package com.airline.AirlineService.Booking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.AirlineService.Flight.FlightDtls;
import com.airline.AirlineService.Flight.FlightRepository;
import com.airline.AirlineService.User.UserOnboarding;
import com.airline.AirlineService.User.UserRepository;

@Service
public class BookingService {
	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private FlightRepository flightrepository;
	
	@Autowired
	private BookingRepository bookingrepository;
	
	public String ticketBooking(Map<String, Object> userBody) {
		String leadId = (String) userBody.get("leadId");
		String flightId = (String) userBody.get("Flight Id");
		
		UserOnboarding user = userrepository.findById(leadId).get();
		FlightDtls flight = flightrepository.findByFlightNumber(flightId);
		
		if(user==null && flight == null) {
			return "Some Technical Exception Occured";
		} else {
			
			if (flight.getAirSeats().equals(0)) {
				return "Sorry The Flight is full";
			} else {
				String bookingId = "";
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmssSSS");
				LocalDateTime now = LocalDateTime.now();
				String formattedDateTime = now.format(formatter);
		        
				char randomLowercase = (char) ('a' + new Random().nextInt(26));
		        char randomUppercase = (char) ('A' + new Random().nextInt(26));
		        Integer seatNumber = flight.getAirSeats() - 1 ;
		         bookingId = "BOOK" + formattedDateTime + randomLowercase + randomUppercase + "AIR";
		         BookingDtls booking = new BookingDtls(bookingId, user.getUserId(), flightId, seatNumber.toString(), LocalDateTime.now(), "Confirmed");
		         bookingrepository.save(booking);
		         flight.setAirSeats(seatNumber);
		         flightrepository.save(flight);
		         
		         return "Congrats your tickets are booked. Thanks for booking with us";
			}
		}
		
	}

}

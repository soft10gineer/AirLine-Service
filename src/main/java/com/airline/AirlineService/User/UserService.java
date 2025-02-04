package com.airline.AirlineService.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.AirlineService.OtpService.OtpService;

@Service
public class UserService {
	
	
	@Autowired
	private OtpService otpservice;
	
	public String registerUser(String mobileNumber) {
		String resultMobileNumber = "+91"+mobileNumber;
		System.out.println(resultMobileNumber);
		return otpservice.generateOtp(resultMobileNumber);
		
	} 
	 
	public String generateLeadId() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmssSSS");
		LocalDateTime now = LocalDateTime.now();
		String formattedDateTime = now.format(formatter);
        
		char randomLowercase = (char) ('a' + new Random().nextInt(26));
        char randomUppercase = (char) ('A' + new Random().nextInt(26));
        
        String leadId = "AIR" + formattedDateTime + randomLowercase + randomUppercase ;
		return leadId;
	}

}

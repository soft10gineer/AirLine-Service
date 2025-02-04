package com.airline.AirlineService.User;

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

}

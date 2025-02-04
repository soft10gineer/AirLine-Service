package com.airline.AirlineService.OtpService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/otp")
public class OtpController {
	
	
	@Autowired
	private OtpService otpservice;
	
	@PostMapping("/validate")
	public String validateOtp(@RequestBody Map<String, Object> userBody) {
		String mobileNumber = (String) userBody.get("Mobile Number");
		String userOtp = (String) userBody.get("Otp");
		otpservice.validateOtp(mobileNumber,userOtp);
		return "STRING"; 
	}
	

}

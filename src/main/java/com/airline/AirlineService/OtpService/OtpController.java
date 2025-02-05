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
		String leadId = (String) userBody.get("leadId");
		String userOtp = (String) userBody.get("Otp");
		return otpservice.validateOtp(leadId,userOtp);
		 
	}
	
	@PostMapping("/generate")
	public String generateOtp(@RequestBody Map<String, String> userBody) {
		String leadId = userBody.get("leadId");
		return 	otpservice.generateOtp(leadId);
		
	}
	

}

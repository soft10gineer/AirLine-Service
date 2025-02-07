package com.airline.AirlineService.User;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.AirlineService.OtpService.OtpService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private OtpService otpservice;
	
	
	@PostMapping("/register")
	public String registerUser(@RequestBody Map<String, String> userBody) {
		
		String mobileNumber = userBody.get("Mobile Number");
		System.out.println(mobileNumber);
		return userservice.registerUser(mobileNumber); 
		 
	}
	
	@PostMapping("/personal_details")
	public String userPersonalDetails(@RequestBody Map<String, Object> userBody) {
		return userservice.personalDtls(userBody);
	}
	
	@PostMapping("/login")
	public String userLogin(@RequestBody Map<String, Object> userBody) {
		return "String";
	}
	
	@PostMapping("/forgot-password")
	public String userForgotPassword(@RequestBody Map<String, Object> userBody) {
		String user = userservice.forgotPassword(userBody);
		return otpservice.generateOtpUsingEmail(user);
	}
	
	@PostMapping("/forgot-password-validation")
	public String userForgotPasswordValidation(@RequestBody Map<String, Object> userBody) {
		String validationCode = (String) userBody.get("Verification Code");
		String validationEmail = (String) userBody.get("Email");
		otpservice.validateOtpUsingCode(validationEmail, validationCode);
		return "String";
		
	}
	
	
	
}

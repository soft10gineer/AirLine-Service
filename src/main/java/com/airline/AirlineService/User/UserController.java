package com.airline.AirlineService.User;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/register")
	public String registerUser(@RequestBody Map<String, String> userBody) {
		
		String mobileNumber = userBody.get("Mobile Number");
		System.out.println(mobileNumber);
		return userservice.registerUser(mobileNumber);
		
	}
}

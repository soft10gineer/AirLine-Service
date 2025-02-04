package com.airline.AirlineService.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {
	
	@GetMapping("/hello")
	public String printHello() {
		return "Hello";
	}
}

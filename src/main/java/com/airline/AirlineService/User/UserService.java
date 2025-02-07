package com.airline.AirlineService.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.airline.AirlineService.OtpService.OtpService;

@Service
public class UserService {
	
	
	
	@Autowired
	private UserRepository userrepository;
	
	
	
	public String registerUser(String mobileNumber) {
		String resultMobileNumber = "+91"+mobileNumber;
		UserOnboarding user = userrepository.findbyMobile(resultMobileNumber);
		if (user == null) {
			UserOnboarding userdtls = new UserOnboarding();
			userdtls.setUserMobileNumber(resultMobileNumber);
			userdtls.setCreatedDateTimestamp(LocalDateTime.now());
			String leadId = generateLeadId();
			userdtls.setUserId(leadId);
			userrepository.save(userdtls);
			return "User Registered Succesfully with leadid "+ " "+ leadId  ;
		} else {
			return "User Already Exist with leadId "+ " "+ user.getUserId();
		} 
		
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
	
	public String userLogin(Map<String, Object> userBody) {
		String email  = (String) userBody.get("Email");
		String password = (String) userBody.get("Password");
		
		UserOnboarding user = userrepository.findByEmail(email);
		if(user == null) {
			return "User Not Found";
		} else {
			
		if(user.getUserPasswordHash().equals(password)) {
			
			return "User Logged In";
			
		} else {
			
			return "Entered Password is Wrong";
		}
			
		}
		}
	
	public String forgotPassword(Map<String, Object> userBody) {
	    String email = (String) userBody.get("Email");

	    UserOnboarding user = userrepository.findByEmail(email);
	    
	    if (user == null) {
	        return "User not found";
	    }
	    
	   return user.getUserMobileNumber() ;
	}
	
	public String personalDtls(Map<String, Object> userBody) {
		String leadId = (String) userBody.get("LeadId");
		
		UserOnboarding user = userrepository.findById(leadId).get();
		
		if(user != null) {
		
		String firstName = (String) userBody.get("First Name");
		String lastName = (String) userBody.get("Last Name");
		Integer age = (Integer) userBody.get("Age");
		String gender = (String) userBody.get("Gender");
		String email = (String) userBody.get("Email");
		String password = (String) userBody.get("Password");
		
		
		
		user.setUserFirstName(firstName);
		user.setUserLastName(lastName);
		user.setUserAge(age);
		user.setUserGender(gender);
		user.setUserEmail(email);
		user.setUserPasswordHash(password);
		userrepository.save(user);
		return "User Details Saved Succesfully";
		
		} else {
			
		return "User not found with the above credentials";
		}
		}

}

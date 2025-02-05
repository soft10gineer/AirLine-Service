package com.airline.AirlineService.OtpService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.AirlineService.User.UserOnboarding;
import com.airline.AirlineService.User.UserRepository;
import com.airline.AirlineService.User.UserService;

@Service
public class OtpService {
	
	@Autowired
	private OtpRepository otprepository;
	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private UserService userservice;
	
	
	public String generateOtp(String leadId) { 
		
		OtpDtls otp = new OtpDtls();
		String generatedOtp = "";
		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			int rand_int = rand.nextInt(9);
			generatedOtp = generatedOtp + Integer.toString(rand_int);
			}
		Optional<UserOnboarding> user =  userrepository.findById(leadId);
		if(otprepository.findById(user.get().getUserMobileNumber()).isEmpty()) {
			System.out.println("If Case"); 
			otp.setGeneratedOtp(generatedOtp);
			otp.setUserMblNb(user.get().getUserMobileNumber());
			otp.setOtpGenerateTime(LocalDateTime.now());
			otp.setOtpAttempt(1);
			otprepository.save(otp);
			return ("Otp Generated Succesfully "+ " " + generatedOtp); 
		} else {
			
			OtpDtls otpdtls =  otprepository.findById(user.get().getUserMobileNumber()).get();
			Integer otpAttempt = otpdtls.getOtpAttempt();
			if (otpAttempt.equals(3)) {
				return "Sorry! Please Try Next Day";
			} else {
				
			otpdtls.setGeneratedOtp(generatedOtp);
			otpdtls.setOtpAttempt(otpAttempt+1);
			otp.setOtpGenerateTime(LocalDateTime.now());
			otprepository.save(otpdtls);
			return "Otp Generated Succesfully"+ " " + generatedOtp ;
			}
			}
		
	}
	
	public String validateOtp(String leadId, String validateOtp) {
		
		UserOnboarding user = userrepository.findById(leadId).get();
		OtpDtls otpUser = otprepository.findById(user.getUserMobileNumber()).get();
		
		
		if(otpUser.getGeneratedOtp().equals(validateOtp)) {
			LocalDateTime otpTime = otpUser.getOtpGenerateTime();
			LocalDateTime userOtpTime = LocalDateTime.now();
			
			Duration duration = Duration.between(otpTime, userOtpTime);
			if(duration.getSeconds()<=60) {
				otpUser.setUsrVldty(true);
				otprepository.save(otpUser);
				
				
				return "User Authenticated Succesfully" ;
			
			} else {
				return "Time Limit Exceeded";
			}
			} else {
				
			return "Wrong Otp" ;
		}
		
		
	}
	
	
	
	
}

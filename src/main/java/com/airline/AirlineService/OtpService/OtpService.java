package com.airline.AirlineService.OtpService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.AirlineService.User.UserOnboarding;
import com.airline.AirlineService.User.UserRepository;

@Service
public class OtpService {
	
	@Autowired
	private OtpRepository otprepository;
	
	@Autowired
	private UserRepository userrepository;
	
	public String validateOtpUsingCode(String validationEmail, String validationCode) {
		UserOnboarding user = userrepository.findByEmail(validationEmail);
		if( user == null ) {
			return "User Not Found";
		} else {
			String userMobile = user.getUserMobileNumber();
			OtpDtls userOtp = otprepository.findById(userMobile).get();
			
			if (validationCode.equals(userOtp.getGeneratedOtp())) {
				
				return "User Validated Succesfully";
			
			} else {}
			
				return "Wrong Code Entered";
		}
	}
	
	public String generateOtpUsingEmail(String mobileNumber) {
		UserOnboarding user = userrepository.findbyMobile(mobileNumber);
		OtpDtls otp = otprepository.findById(mobileNumber).get();
		
		if (user == null) {
			return "User Not Found";
		} else {
			
			
			String generatedOtp = "";
			Random rand = new Random();
			for (int i = 0; i < 6; i++) {
				int rand_int = rand.nextInt(9);
				generatedOtp = generatedOtp + Integer.toString(rand_int);
				}
			otp.setGeneratedOtp(generatedOtp);
			otp.setUserMblNb(mobileNumber);
			otp.setOtpGenerateTime(LocalDateTime.now());
			otp.setOtpAttempt(1);
			otprepository.save(otp);
			return ("Otp Generated Succesfully "+ " " + generatedOtp); 
			
		}
	}
	
	
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
				otpUser.setOtpAttempt(0);
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

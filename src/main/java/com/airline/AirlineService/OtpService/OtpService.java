package com.airline.AirlineService.OtpService;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtpService {
	
	@Autowired
	private OtpRepository otprepository;
	
	public String generateOtp(String mobileNumber) {
		
		OtpDtls otp = new OtpDtls();
		String generatedOtp = "";
		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			int rand_int = rand.nextInt(9);
			generatedOtp = generatedOtp + Integer.toString(rand_int);
			}
		
		if(otprepository.findById(mobileNumber).isEmpty()) {
			System.out.println("If Case"); 
			otp.setGeneratedOtp(generatedOtp);
			otp.setUserMblNb(mobileNumber);
			otp.setOtpGenerateTime(LocalDateTime.now());
			otp.setOtpAttempt(1);
			otprepository.save(otp);
			return ("Otp Generated Succesfully"+generatedOtp); 
		} else {
			
			OtpDtls otpdtls =  otprepository.findById(mobileNumber).get();
			Integer otpAttempt = otpdtls.getOtpAttempt();
			if (otpAttempt.equals(3)) {
				return "Sorry! Please Try Next Day";
			} else {
				
			otpdtls.setGeneratedOtp(generatedOtp);
			otpdtls.setOtpAttempt(otpAttempt+1);
			otp.setOtpGenerateTime(LocalDateTime.now());
			otprepository.save(otpdtls);
			return "Otp Generated Succesfully"+generatedOtp ;
			}
			}
		
	}
}

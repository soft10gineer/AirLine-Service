package com.airline.AirlineService.OtpService;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="otp_dtls", schema="air_otp")


public class OtpDtls {
	
	@Id
	@Column(name="mbl_nb")
	private String userMblNb;
	
	@Column(name="gnrtd_otp")
	private String generatedOtp;
	
	@Column(name="otp_attmpt")
	private Integer otpAttempt;
	
	@Column(name="otp_gnrt_tm")
	private LocalDateTime otpGenerateTime;
	
	@Column(name = "usr_vldty")
	private Boolean usrVldty = false; 
	
	public OtpDtls() {
	}

	public OtpDtls(String userMblNb, String generatedOtp, Integer otpAttempt, LocalDateTime otpGenerateTime,
			Boolean usrVldty) {
		super();
		this.userMblNb = userMblNb;
		this.generatedOtp = generatedOtp;
		this.otpAttempt = otpAttempt;
		this.otpGenerateTime = otpGenerateTime;
		this.usrVldty = usrVldty;
	}

	public Boolean getUsrVldty() {
		return usrVldty;
	}

	public void setUsrVldty(Boolean usrVldty) {
		this.usrVldty = usrVldty;
	}

	
	public String getUserMblNb() {
		return userMblNb;
	}

	public void setUserMblNb(String userMblNb) {
		this.userMblNb = userMblNb;
	}

	public String getGeneratedOtp() {
		return generatedOtp;
	}

	public void setGeneratedOtp(String generatedOtp) {
		this.generatedOtp = generatedOtp;
	}

	public Integer getOtpAttempt() {
		return otpAttempt;
	}

	public void setOtpAttempt(Integer otpAttempt) {
		this.otpAttempt = otpAttempt;
	}

	public LocalDateTime getOtpGenerateTime() {
		return otpGenerateTime;
	}

	public void setOtpGenerateTime(LocalDateTime localDateTime) {
		this.otpGenerateTime = localDateTime;
	}
	
	
	
	
	
}

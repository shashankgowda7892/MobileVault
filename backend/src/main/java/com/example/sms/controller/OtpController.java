package com.example.sms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.service.AccountHolderService;
import com.example.sms.service.Fast2SmsService;
import com.example.sms.service.OtpService;

import jakarta.servlet.http.HttpSession;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class OtpController {
	@Autowired
	private OtpService otpservice;
	
	@Autowired
    private Fast2SmsService fast2SmsService;
	
	@Autowired
	private AccountHolderService accholderservice;
	
	@PostMapping("/sendOtp")
    public String sendOtp(@RequestBody Map<String, String> requestBody) {
		String phoneNumber = requestBody.get("phoneNumber");
        String otp = otpservice.generateOtp(phoneNumber);
        String response = fast2SmsService.sendOtp(phoneNumber, otp);
        return "OTP sent successfully!"+otp;
    }


    @PostMapping("/verifyOtp")
    public ResponseEntity<String> verifyOtp(@RequestBody Map<String, String> requestBody, HttpSession session) {
    	String phoneNumber = requestBody.get("phoneNumber");
    	String otp = requestBody.get("otp");
        boolean isValid = otpservice.validateOtp(phoneNumber, otp);
        if (isValid) {
        	int userId = accholderservice.getUserId(phoneNumber);
        	otpservice.clearOtp(phoneNumber);
        	session.setAttribute("UserId", userId);
        	return ResponseEntity.ok("OTP verified, login successful!");
        }	
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid OTP!");
    }
    
    @GetMapping("/login")
    public void getMethodName(HttpSession session) {
        session.setAttribute("UserId" , 1);
    }
    
}

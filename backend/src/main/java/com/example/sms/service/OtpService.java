package com.example.sms.service;

import java.util.HashMap;
import java.util.Random;

import org.springframework.stereotype.Service;
@Service
public class OtpService {
	private final HashMap<String, String> otpData = new HashMap<>();
	
    
    public String generateOtp(String phoneNumber) {
        String otp = String.format("%04d", new Random().nextInt(10000));
        otpData.put(phoneNumber, otp);
        System.out.println(otpData);
        
        return otp;
    }
	
	public boolean validateOtp(String phoneNumber, String otp) {
		System.out.println(phoneNumber);
		System.out.println(otp);
        String storedOtp = otpData.get(phoneNumber);
        
        System.out.println(otpData);
        return storedOtp != null && storedOtp.equals(otp);
    }
	
	
	public void clearOtp(String phoneNumber) {
        otpData.remove(phoneNumber);
    }
}

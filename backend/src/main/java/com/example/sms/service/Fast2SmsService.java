package com.example.sms.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class Fast2SmsService {

    @Value("${fast2sms.api.url}")
    private String fast2SmsApiUrl;

    @Value("${fast2sms.api.key}")
    private String fast2SmsApiKey;

    public String sendOtp(String phoneNumber, String otp) {
        RestTemplate restTemplate = new RestTemplate();

        
        Map<String, String> payload = new HashMap<>();
        payload.put("sender_id", "FSTSMS");
        payload.put("message", "Otp From LocalHost " + otp);
        payload.put("language", "english");
        payload.put("route", "q");
        payload.put("numbers", phoneNumber);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("authorization", fast2SmsApiKey);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(payload, headers);

        
        ResponseEntity<String> response = restTemplate.postForEntity(fast2SmsApiUrl, entity, String.class);
        System.out.println(response.getBody());
        return response.getBody();
    }
}

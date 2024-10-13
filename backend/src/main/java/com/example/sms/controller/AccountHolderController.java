package com.example.sms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.model.AccountHolder;
import com.example.sms.service.AccountHolderService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class AccountHolderController {
	@Autowired
	private AccountHolderService userservice;
	
	@PostMapping("/adduser")
	public AccountHolder createAccountHolder(@RequestBody Map<String, String> request) {
		String name = request.get("name");
		String phoneNumber = request.get("phoneNumber");
		
		return userservice.createAccountHolder(name,phoneNumber);
		
	}
	
	@GetMapping("/userinfo")
	public AccountHolder getUserInfo(HttpSession session) {
//		int id =1;
		Integer id = (Integer) session.getAttribute("UserId");
		return userservice.getUserInfo(id);
	}
	
//	@GetMapping("/getbalance/{id}")
//	public double getBalance(@PathVariable int id) {
//			return userservice.getBalance(id);
//	}
	
//	@PutMapping("withdraw/{id}/{amount}")
//	public double withdrawCash(@PathVariable int id,@PathVariable double amount) {
//		
//		return userservice.withdraw(id,amount);
//	}
	
	
	@PutMapping("/withdraw")
	public String withdrawCash(@RequestBody Map<String, Double> request,HttpSession session) {
//		int userId = 1;
		Integer userId = (Integer) session.getAttribute("UserId");
		boolean success = userservice.withdrawAmount(userId, request.get("amount"));
		
		if (success) {
            return "Amount withdrawn successfully!";
        } else {
            return "Insufficient balance or an error occurred!";
        }
	}
	
//	@PutMapping("deposite/{id}/{amount}")
//	public double depositeCash(@PathVariable int id,@PathVariable double amount) {
//		
//		return userservice.deposite(id,amount);
//	}
	
	
	@PutMapping("/deposit")
	public String depositCash(@RequestBody Map<String, Double> request,HttpSession session) {
//		int userId = 1;
		Integer userId = (Integer) session.getAttribute("UserId");
		boolean success = userservice.depositAmount(userId, request.get("amount"));
		
		if (success) {
            return "Amount deposited successfully!";
        } else {
            return "There was a problem while depositing !!";
        }
	}
	

	
	
	
}

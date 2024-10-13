package com.example.sms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sms.model.AccountHolder;
import com.example.sms.model.TranscationHistory;
import com.example.sms.repository.AccountHolderRepository;
import com.example.sms.repository.TransactionHistoryRepository;

@Service
public class AccountHolderService {
	@Autowired
	private AccountHolderRepository repository;
	
	@Autowired
	private TransactionHistoryRepository threpository;
	
	
	public int getUserId(String number) {
		AccountHolder user = repository.findByphoneNumber(number);
		return user.getId();
	}
	
//	public double getBalance(int id) {
//		Optional<AccountHolder> userById = repository.findById(id);
//		AccountHolder user = userById.get();
//		return user.getAmount();
//	}
	
	public boolean withdrawAmount(Integer id, double amount) {
		Optional<AccountHolder> userById = repository.findById(id);
		
		AccountHolder user = userById.get();
		
		if (user.getAmount() >= amount) {
			user.setAmount(user.getAmount() - amount);
			
			TranscationHistory transcation = new TranscationHistory();
			transcation.setAmount(amount );
			transcation.setType("withdraw");
			transcation.setAc(user);
			
			
            repository.save(user);
            threpository.save(transcation);
			
            return true; 
        }
		return false;
    }
		
		
	
	
	public boolean depositAmount(Integer id, double amount) {
		Optional<AccountHolder> userById = repository.findById(id);
		AccountHolder user = userById.get();
			user.setAmount(user.getAmount() + amount);
			
			TranscationHistory transcation = new TranscationHistory();
			transcation.setAmount(amount );
			transcation.setType("deposit");
			transcation.setAc(user);
			
			repository.save(user);
			threpository.save(transcation);
            return true; 
        

    }

	public AccountHolder getUserInfo(int id) {
		
		Optional<AccountHolder> user = repository.findById(id);
		AccountHolder userinfo = user.get();
		return userinfo;
	}

	public AccountHolder createAccountHolder(String name, String phoneNumber) {
		
		AccountHolder ah = new AccountHolder();
		ah.setName(name);
		ah.setPhoneNumber(phoneNumber);
		ah.setAmount(500); 		
		
		 return repository.save(ah);
	}
}

package com.example.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sms.model.AccountHolder;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer>  {
	public AccountHolder findByphoneNumber(String number);
}

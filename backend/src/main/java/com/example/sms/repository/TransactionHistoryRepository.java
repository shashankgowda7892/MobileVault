package com.example.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sms.model.TranscationHistory;

public interface TransactionHistoryRepository extends JpaRepository<TranscationHistory, Integer>{

}

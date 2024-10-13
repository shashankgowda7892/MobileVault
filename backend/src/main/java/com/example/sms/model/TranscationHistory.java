package com.example.sms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TranscationHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double amount;
	private String type;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "account_id")
	private AccountHolder ac;
	
	public TranscationHistory() {
		
	}
	public TranscationHistory(int id, double amount, String type, AccountHolder ac) {
		super();
		this.id = id;
		this.amount = amount;
		this.type = type;
		this.ac = ac;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public AccountHolder getAc() {
		return ac;
	}
	public void setAc(AccountHolder ac) {
		this.ac = ac;
	}

}

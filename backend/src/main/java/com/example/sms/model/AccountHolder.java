package com.example.sms.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class AccountHolder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="holder_name")
	private String name;
	private String phoneNumber;
	private double amount;
	
	@OneToMany(mappedBy = "ac",cascade = CascadeType.ALL )
	private List<TranscationHistory> th;
	
	public AccountHolder() {
		// TODO Auto-generated constructor stub
	}

	public AccountHolder(int id, String name, String phoneNumber, double amount, List<TranscationHistory> th) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.amount = amount;
		this.th = th;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<TranscationHistory> getTh() {
		return th;
	}

	public void setTh(List<TranscationHistory> th) {
		this.th = th;
	}

	
	
	
	
}

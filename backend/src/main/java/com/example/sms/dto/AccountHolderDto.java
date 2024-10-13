package com.example.sms.dto;

public class AccountHolderDto {
	private int id;
	private String name;
	private String phoneNumber;
	private double amount;
	
	public AccountHolderDto() {
		// TODO Auto-generated constructor stub
	}

	public AccountHolderDto(int id, String name, String phoneNumber, double amount) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.amount = amount;
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
	
}

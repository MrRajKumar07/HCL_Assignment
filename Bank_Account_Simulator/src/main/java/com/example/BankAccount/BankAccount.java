package com.example.BankAccount;

public class BankAccount {

    private String name;
	private double balance;
    private final String accountNumber;

    public BankAccount(String name, String accountNumber, double initialBalance) {
        this.name = name;
    	this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

}
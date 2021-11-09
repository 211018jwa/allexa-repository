package com.revature.model;

import java.util.Objects;

public class BankAccount {
	private int accountID;
	private String accountType;
	private double balance;
	
	public BankAccount() {
		
	}
	
	public BankAccount(int clientID, String accountType, double balance) {
		super();
		this.accountID = clientID;
		this.accountType = accountType;
		this.balance = balance;
	}

	public int getClientID() {
		return accountID;
	}

	public void setClientID(int clientID) {
		this.accountID = clientID;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountType, balance, accountID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		return Objects.equals(accountType, other.accountType)
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& accountID == other.accountID;
	}

	@Override
	public String toString() {
		return "BankAccount [clientID=" + accountID + ", accountType=" + accountType + ", balance=" + balance + "]";
	}
	
}

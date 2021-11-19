package com.revature.model;

import java.util.Objects;

public class BankAccount {
	private int accountID;
	private String accountType;
	private int balance;
	private int clientID;
	
	public BankAccount() {
		
	}
	
	public BankAccount(int accountID, String accountType, int balance, int clientID) {
		super();
		this.accountID = accountID;
		this.accountType = accountType;
		this.balance = balance;
		this.clientID = clientID;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountID, accountType, balance, clientID);
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
		return accountID == other.accountID && Objects.equals(accountType, other.accountType)
				&& balance == other.balance && clientID == other.clientID;
	}

	@Override
	public String toString() {
		return "BankAccount [accountID=" + accountID + ", accountType=" + accountType + ", balance=" + balance
				+ ", clientID=" + clientID + "]";
	}
	
}

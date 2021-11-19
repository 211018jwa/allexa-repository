package com.revature.dto;

import java.util.Objects;

public class AddBankAccountDTO {
	private int clientID;
	private String accountType;
	private int balance;
	
	public AddBankAccountDTO() {
		
	}
	
	public AddBankAccountDTO(int clientID, String accountType, int balance) {
		super();
		this.clientID = clientID;
		this.accountType = accountType;
		this.balance = balance;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
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

	@Override
	public int hashCode() {
		return Objects.hash(accountType, balance, clientID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddBankAccountDTO other = (AddBankAccountDTO) obj;
		return Objects.equals(accountType, other.accountType) && Objects.equals(balance, other.balance)
				&& clientID == other.clientID;
	}

	@Override
	public String toString() {
		return "AddBankAccountDTO [clientID=" + clientID + ", accountType=" + accountType + ", balance=" + balance
				+ "]";
	}
	
}

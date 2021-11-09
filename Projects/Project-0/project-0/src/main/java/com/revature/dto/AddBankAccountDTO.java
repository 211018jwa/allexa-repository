package com.revature.dto;

import java.util.Objects;

public class AddBankAccountDTO {
	private String accountType;
	private double balance;
	
	public AddBankAccountDTO() {
		
	}
	
	public AddBankAccountDTO(String accountType, double balance) {
		super();
		this.accountType = accountType;
		this.balance = balance;
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
		return Objects.hash(accountType, balance);
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
		return Objects.equals(accountType, other.accountType)
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance);
	}

	@Override
	public String toString() {
		return "AddBankAccountDTO [accountType=" + accountType + ", balance=" + balance + "]";
	}
	
}

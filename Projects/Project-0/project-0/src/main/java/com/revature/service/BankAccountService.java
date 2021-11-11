package com.revature.service;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.revature.dao.BankAccountDAO;
import com.revature.dto.AddBankAccountDTO;
import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.InvalidParameterException;
import com.revature.model.BankAccount;

import io.javalin.http.Context;

public class BankAccountService {
	
	private BankAccountDAO bankAccountDao;

	public BankAccountService() {
		this.bankAccountDao = new BankAccountDAO();
	}

	public BankAccountService(BankAccountDAO bankAccountDao) {
		super();
		this.bankAccountDao = bankAccountDao;
	}
	
	public BankAccount editAccountType(String accountID, String changeType) throws SQLException, AccountNotFoundException, InvalidParameterException {
		try {
			int id = Integer.parseInt(accountID);
			
			BankAccount accountToEdit = this.bankAccountDao.getAccountByID(id);
			
			if(accountToEdit == null) {
				throw new AccountNotFoundException("Account with id of " + accountID + " was not found.");
			}
			
			AddBankAccountDTO dto = new AddBankAccountDTO(changeType, accountToEdit.getBalance());
			
			BankAccount updatedAccount = this.bankAccountDao.updateAccount(id, dto);
			
			return updatedAccount;
		}
		catch(NumberFormatException e) {
			throw new InvalidParameterException("ID provided is not an int compatible value.");
		}
	}
	
	public List<BankAccount> getAllAccounts() throws SQLException {
		List<BankAccount> accounts = this.bankAccountDao.getAllAccounts();
		
		return accounts;
	}
	
	public BankAccount getAccountByID(String accountID) throws SQLException, AccountNotFoundException, InvalidParameterException {
		try {
			int id = Integer.parseInt(accountID);
			
			BankAccount b = this.bankAccountDao.getAccountByID(id);
			
			if(b == null) {
				throw new AccountNotFoundException("Account with id of " + accountID + " was not found.");
			}
			
			return b;
		}
		catch(NumberFormatException e) {
			throw new InvalidParameterException("ID provided is not an int compatible value.");
		}
	}
	
	public BankAccount addAccount(AddBankAccountDTO dto) throws SQLException, InvalidParameterException {
		if(dto.getAccountType().trim().equals("")) {
			throw new InvalidParameterException("Account Type cannot be blank");
		}
		
		Set<String> validAccountType = new HashSet<>();
		validAccountType.add("Checking");
		validAccountType.add("Savings");
		
		if(!validAccountType.contains(dto.getAccountType())) {
			throw new InvalidParameterException("You entered an invalid bank account type.");
		}
		
		//Balance check
		
		BankAccount insertedAccount = this.bankAccountDao.addBankAccount(dto);
		return insertedAccount;
	}
	
	public void deleteAccountByID(String accountID) throws SQLException, InvalidParameterException, AccountNotFoundException {
		try {
			int id = Integer.parseInt(accountID);
			
			BankAccount account = this.bankAccountDao.getAccountByID(id);
			
			if(account == null) {
				throw new AccountNotFoundException("Account with id " + accountID + " was not found, therefore could not be deleted.");
			}
		}
		catch(NumberFormatException e) {
			throw new InvalidParameterException("ID provided is not an int");
		}
	}

	public List<BankAccount> getAllAccountsByClientID(String clientID, Context ctx) throws SQLException {
		List<BankAccount> accounts;
		
		int id = Integer.parseInt(clientID);
		
		accounts = this.bankAccountDao.getAllAccountsByClientID(id);
		
		return accounts;
	}
		
}

package com.revature.service;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.dao.BankAccountDAO;
import com.revature.dto.AddBankAccountDTO;
import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.ClientNotFoundException;
import com.revature.exceptions.InvalidParameterException;
import com.revature.model.BankAccount;

import io.javalin.http.Context;

public class BankAccountService {

	private BankAccountDAO bankAccountDao;

	private Logger logger = LoggerFactory.getLogger(BankAccountService.class);

	public BankAccountService() {
		this.bankAccountDao = new BankAccountDAO();
	}

	public BankAccountService(BankAccountDAO bankAccountDao) {
		super();
		this.bankAccountDao = bankAccountDao;
	}

	public BankAccount editBalance(String clientID, String accountID, String balance)
			throws SQLException, AccountNotFoundException, InvalidParameterException {
		try {
			int cID = Integer.parseInt(clientID);
			int aID = Integer.parseInt(accountID);
			int balan = Integer.parseInt(balance);
			
			logger.info("AccountService layer: balance {}", balan);

			BankAccount accountToEdit = this.bankAccountDao.getAccountByIDAndClientID(cID, aID);

			if (accountToEdit == null) {
				throw new AccountNotFoundException("Account with id of " + accountID + " was not found.");
			}

			AddBankAccountDTO dto = new AddBankAccountDTO(cID, accountToEdit.getAccountType(), balan);

			BankAccount updatedAccount = this.bankAccountDao.updateAccount(cID, aID, dto);

			return updatedAccount;
		} catch (NumberFormatException e) {
			throw new InvalidParameterException("ID provided is not an int compatible value.");
		}
	}

	public List<BankAccount> getAllAccounts() throws SQLException {
		List<BankAccount> accounts = this.bankAccountDao.getAllAccounts();

		return accounts;
	}

	public BankAccount getAccountByIDAndClientID(String clientID, String accountID)
			throws SQLException, AccountNotFoundException, InvalidParameterException {
		try {
			int cID = Integer.parseInt(clientID);
			int aID = Integer.parseInt(accountID);

			BankAccount b = this.bankAccountDao.getAccountByIDAndClientID(cID, aID);

			if (b == null) {
				throw new AccountNotFoundException(
						"Client of id " + clientID + "and/or Account with id of " + accountID + " was not found.");
			}

			return b;
		} catch (NumberFormatException e) {
			throw new InvalidParameterException("ID provided is not an int compatible value.");
		}
	}

	public BankAccount addAccount(AddBankAccountDTO dto, String clientID)
			throws SQLException, InvalidParameterException, ClientNotFoundException {
		logger.info("addAccount in Service layer invoked");

		int cID = Integer.parseInt(clientID);

		if (dto.getAccountType().trim().equals("")) {
			throw new InvalidParameterException("Account Type cannot be blank");
		}

		Set<String> validAccountType = new HashSet<>();
		validAccountType.add("Checking");
		validAccountType.add("Savings");

		if (!validAccountType.contains(dto.getAccountType())) {
			throw new InvalidParameterException("You entered an invalid bank account type.");
		}

		if (dto.getBalance() < 0) {
			throw new InvalidParameterException("You entered an invalid amount for the balance.");
		}

		BankAccount insertedAccount = this.bankAccountDao.addBankAccount(dto, cID);
		return insertedAccount;
	}

	public void deleteBankAccountByID(String clientID, String accountID)
			throws SQLException, InvalidParameterException, AccountNotFoundException {
		try {
			int cID = Integer.parseInt(clientID);
			int aID = Integer.parseInt(accountID);

			BankAccount account = this.bankAccountDao.getAccountByIDAndClientID(cID, aID);

			if (account == null) {
				throw new AccountNotFoundException(
						"Client of id " + clientID + "and/or Account with id of " + accountID + " was not found.");
			}
			
			this.bankAccountDao.deleteBankAccountByID(cID, aID);
		} catch (NumberFormatException e) {
			throw new InvalidParameterException("ID provided is not an int");
		}
	}

	public List<BankAccount> getAllAccountsByClientID(String clientID, int greaterThan, int lessThan) throws SQLException, InvalidParameterException, ClientNotFoundException {
		List<BankAccount> accounts;
		
		try {
			int id = Integer.parseInt(clientID);
			logger.info("AccountService layer: client id {}", clientID);
			accounts = this.bankAccountDao.getAllAccountsByClientID(id, greaterThan, lessThan);
			
			return accounts;
		
		}
		catch (NumberFormatException e) {
			throw new InvalidParameterException("Client id not found");
		}
	}

}

package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dto.AddBankAccountDTO;
import com.revature.model.BankAccount;
import com.revature.util.JDBCUtility;

public class BankAccountDAO {
	
	public BankAccount addBankAccount(AddBankAccountDTO bankAccount) throws SQLException {
		try(Connection con = JDBCUtility.getConnection()){
			
			String sql = "INSERT INTO bankAccount (bank_account_type, bank_account_balance) "
					+ "VALUES (?, ?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, bankAccount.getAccountType());
			pstmt.setDouble(2, bankAccount.getBalance());
			
			int numOfRecordsInserted = pstmt.executeUpdate();
			
			if(numOfRecordsInserted != 1) {
				throw new SQLException("Adding a new Bank Account was unsuccessful.");
			}
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			rs.next();
			int generatedID = rs.getInt(1);
			
			return new BankAccount(generatedID, bankAccount.getAccountType(), bankAccount.getBalance());
		}
	}
	
	public List<BankAccount> getAllAccounts() throws SQLException {
		List<BankAccount> listOfAccounts = new ArrayList<>();
		
		try(Connection con = JDBCUtility.getConnection()) {
			String sql = "SELECT * FROM bankAccount";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("account_id");
				String accountType = rs.getString("bank_account_type");
				double accountBalance = rs.getDouble("bank_account_balance");
				
				BankAccount b = new BankAccount(id, accountType, accountBalance);
				listOfAccounts.add(b);
			}
		}
		
		return listOfAccounts;
	}
	
	public BankAccount getAccountByID(int id) throws SQLException {
		try(Connection con = JDBCUtility.getConnection()){
			String sql = "SELECT * FROM bankAccount WHERE client_bank_account_id = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new BankAccount(rs.getInt("account_id"), rs.getString("bank_account_type"), rs.getDouble("bank_account_balance"));
			}
			else {
				return null;
			}
		}
	}
	
	public BankAccount updateAccount(int accountID, AddBankAccountDTO account) throws SQLException {
		try(Connection con = JDBCUtility.getConnection()) {
			String sql = "Update bankAccount "
					+ "SET bank_account_type = ? "
					+ "		bank_account_balance = ?, "
					+ "WHERE "
					+ "account_id = ?; ";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, account.getAccountType());
			pstmt.setDouble(1, account.getBalance());
			pstmt.setInt(3, accountID);
			
			int numOfRecordsUpdated = pstmt.executeUpdate();
			
			if(numOfRecordsUpdated != 1) {
				throw new SQLException("Unable to update bank acoount with an id of "+ accountID);
			}
		}
		return new BankAccount(accountID, account.getAccountType(), account.getBalance());
	}
	
	public void deleteBankAccountByID(int id) throws SQLException {
		try(Connection con = JDBCUtility.getConnection()){
			String sql = "DELETE FROM bankAccount WHERE account_id = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			int numberOfRecordsDeleted = pstmt.executeUpdate();
			
			if(numberOfRecordsDeleted != 1) {
				throw new SQLException("Unable to delete bank account with an id of " + id);
			}
		}
	}
	
	public void deleteAllBankAccounts() throws SQLException {
		try(Connection con = JDBCUtility.getConnection()) {
			String sql = "DELETE FROM bankAccount";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			int numberOfRecordsDeleted = pstmt.executeUpdate();
			
			if(numberOfRecordsDeleted == 0) {
				throw new SQLException("Unable to delete any records(check if records exist in the table)");
			}
		}
	}

	public List<BankAccount> getAllAccountsByClientID(int clientID) throws SQLException {
		List<BankAccount> accounts = new ArrayList<>();
		
		try(Connection con = JDBCUtility.getConnection()) {
			String sql = "SELECT * FROM bankAccount WHERE client_id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, clientID);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("account_id");
				String type = rs.getString("account_type");
				double balance = rs.getDouble("account_balance");
				
				BankAccount a = new BankAccount(id, type, balance);
				
				accounts.add(a);
			}
		}
		
		return accounts;
	}
	
}

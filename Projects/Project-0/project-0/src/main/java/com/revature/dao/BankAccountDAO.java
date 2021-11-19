package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.dto.AddBankAccountDTO;
import com.revature.model.BankAccount;
import com.revature.util.JDBCUtility;

public class BankAccountDAO {
	
	private Logger logger = LoggerFactory.getLogger(BankAccountDAO.class);
	
	public BankAccount addBankAccount(AddBankAccountDTO bankAccount, int clientID) throws SQLException {
		logger.info("addAccount in DAO layer invoked");
		
		try(Connection con = JDBCUtility.getConnection()){
			
			String sql = "INSERT INTO bankAccount (account_type, balance, client_id) "
					+ "VALUES (?, ?, ?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, bankAccount.getAccountType());
			pstmt.setInt(2, bankAccount.getBalance());
			pstmt.setInt(3, clientID);
			
			int numOfRecordsInserted = pstmt.executeUpdate();
			
			if(numOfRecordsInserted != 1) {
				throw new SQLException("Adding a new Bank Account was unsuccessful.");
			}
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			rs.next();
			int generatedID = rs.getInt(1);
			
			return new BankAccount(generatedID, bankAccount.getAccountType(), bankAccount.getBalance(), clientID);
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
				String accountType = rs.getString("account_type");
				int accountBalance = rs.getInt("balance");
				int clientID = rs.getInt("client_id");
				
				BankAccount b = new BankAccount(id, accountType, accountBalance, clientID);
				listOfAccounts.add(b);
			}
		}
		
		return listOfAccounts;
	}
	
	public BankAccount getAccountByIDAndClientID(int clientID, int accountID) throws SQLException {
		try(Connection con = JDBCUtility.getConnection()){
			String sql = "SELECT * FROM bankAccount WHERE client_id = ? AND account_id = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, clientID);
			pstmt.setInt(2, accountID);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new BankAccount(rs.getInt("account_id"), rs.getString("account_type"), rs.getInt("balance"), rs.getInt("client_id"));
			}
			else {
				return null;
			}
		}
	}
	
	public BankAccount updateAccount(int clientID, int accountID, AddBankAccountDTO account) throws SQLException {
		try(Connection con = JDBCUtility.getConnection()) {
			String sql = "Update bankAccount "
					+ "SET account_type = ? "
					+ "		balance = ?, "
					+ "WHERE "
					+ "client_id = ? AND account_id = ?; ";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, account.getAccountType());
			pstmt.setInt(2, account.getBalance());
			pstmt.setInt(3, clientID);
			pstmt.setInt(4, accountID);
			
			int numOfRecordsUpdated = pstmt.executeUpdate();
			
			if(numOfRecordsUpdated != 1) {
				throw new SQLException("Unable to update bank acoount with an id of "+ accountID);
			}
		}
		return new BankAccount(accountID, account.getAccountType(), account.getBalance(), account.getClientID());
	}
	
	public void deleteBankAccountByID(int clientID, int accountID) throws SQLException {
		try(Connection con = JDBCUtility.getConnection()){
			String sql = "DELETE FROM bankAccount WHERE client_id = ? AND account_id = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, clientID);
			pstmt.setInt(2, accountID);
			
			int numberOfRecordsDeleted = pstmt.executeUpdate();
			
			if(numberOfRecordsDeleted != 1) {
				throw new SQLException("Unable to delete bank account with an client id of " + clientID + " and account id of " + accountID);
			}
		}
	}
	
	public void deleteAllBankAccountsByClientID(int clientID) throws SQLException {
		try(Connection con = JDBCUtility.getConnection()){
			String sql = "DELETE FROM bankAccount WHERE client_id = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, clientID);
			
			pstmt.executeUpdate();
			
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

	public List<BankAccount> getAllAccountsByClientID(int clientID, int greaterThan, int lessThan) throws SQLException {
		List<BankAccount> accounts = new ArrayList<>();
		
		try (Connection con = JDBCUtility.getConnection()) {
			String sql = "SELECT * FROM bankAccount WHERE client_id = ? AND balance >= ? AND balance <= ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, clientID);
			pstmt.setInt(2, greaterThan);
			pstmt.setInt(3, lessThan);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("account_id");
				String accountType = rs.getString("account_type");
				int balance = rs.getInt("balance");
				
				BankAccount b = new BankAccount(id, accountType, balance, clientID);
				
				accounts.add(b);
			}
		}
		
		return accounts;
	}
	
}

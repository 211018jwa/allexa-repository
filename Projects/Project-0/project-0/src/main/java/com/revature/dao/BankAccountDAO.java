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
			
			String sql = "INSERT INTO students (client_first_name, client_last_name, client_bank_account_type) "
					+ "VALUES (?, ?, ?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, bankAccount.getClientFirstName());
			pstmt.setString(2, bankAccount.getClientLastName());
			pstmt.setString(3, bankAccount.getClientAccountType());
			
			int numOfRecordsInserted = pstmt.executeUpdate();
			
			if(numOfRecordsInserted != 1) {
				throw new SQLException("Adding a new new Bank Account was unsuccessful.");
			}
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			rs.next();
			int generatedID = rs.getInt(1);
			
			return new BankAccount(generatedID, bankAccount.getClientFirstName(), bankAccount.getClientLastName(), bankAccount.getClientAccountType());
		}
	}
	
	public List<BankAccount> getAllAccounts() throws SQLException {
		List<BankAccount> listOfAccounts = new ArrayList<>();
		
		try(Connection con = JDBCUtility.getConnection()) {
			String sql = "SELECT * FROM bankAccount";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("client_bank_account_id");
				String firstName = rs.getString("client_first_name");
				String lastName = rs.getString("client_last_name");
				String accountType = rs.getString("client_bank_account_type");
				
				BankAccount b = new BankAccount(id, firstName, lastName, accountType);
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
				return new BankAccount(rs.getInt("client_bank_account_id"), rs.getString("client_first_name"),
						rs.getString("client_last_name"), rs.getString("client_bank_account_type"));
			}
			else {
				return null;
			}
		}
	}
	
	public BankAccount updateAccount(int accountID, AddBankAccountDTO account) throws SQLException {
		try(Connection con = JDBCUtility.getConnection()) {
			String sql = "Update bankAccount "
					+ "SET client_first_name = ?, "
					+ "		client_first_name = ?, "
					+ "		client_bank_account_type = ? "
					+ "WHERE "
					+ "client_bank_account_id = ?; ";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, account.getClientFirstName());
			pstmt.setString(2, account.getClientLastName());
			pstmt.setString(3, account.getClientAccountType());
			pstmt.setInt(4, accountID);
			
			int numOfRecordsUpdated = pstmt.executeUpdate();
			
			if(numOfRecordsUpdated != 1) {
				throw new SQLException("Unable to update bank acoount with an id of "+ accountID);
			}
		}
		return new BankAccount(accountID, account.getClientFirstName(), account.getClientLastName(), account.getClientAccountType());
	}
	
	public void deleteBankAccountByID(int id) throws SQLException {
		try(Connection con = JDBCUtility.getConnection()){
			String sql = "DELETE FROM students WHERE client_bank_account_id = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			int numberOfRecordsDeleted = pstmt.executeUpdate();
			
			if(numberOfRecordsDeleted != 1) {
				throw new SQLException("Unable to delete bank account with an id of " + id);
			}
		}
	}
	
	public void deleteAllStudents() throws SQLException {
		try(Connection con = JDBCUtility.getConnection()) {
			String sql = "DELETE FROM bankAccount";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			int numberOfRecordsDeleted = pstmt.executeUpdate();
			
			if(numberOfRecordsDeleted == 0) {
				throw new SQLException("Unable to delete any records(check if records exist in the table)");
			}
		}
	}
	
}

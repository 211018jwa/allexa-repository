package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
}

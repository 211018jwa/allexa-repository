package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dto.AddClientDTO;
import com.revature.model.Client;
import com.revature.util.JDBCUtility;

public class ClientDAO {
	public Client addBankAccount(AddClientDTO client) throws SQLException {
		try(Connection con = JDBCUtility.getConnection()){
			
			String sql = "INSERT INTO clients (client_first_name, client_last_name) "
					+ "VALUES (?, ?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, client.getClientFirstName());
			pstmt.setString(2, client.getClientLastName());
			
			int numOfRecordsInserted = pstmt.executeUpdate();
			
			if(numOfRecordsInserted != 1) {
				throw new SQLException("Adding a new Client was unsuccessful.");
			}
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			rs.next();
			int generatedID = rs.getInt(1);
			
			return new Client(generatedID, client.getClientFirstName(), client.getClientLastName());
		}
	}
	
	public List<Client> getAllClients() throws SQLException {
		List<Client> listOfClients = new ArrayList<>();
		
		try(Connection con = JDBCUtility.getConnection()) {
			String sql = "SELECT * FROM clients";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("client_id");
				String firstName = rs.getString("client_first_name");
				String lastName = rs.getString("client_last_name");
				
				Client b = new Client(id, firstName, lastName);
				listOfClients.add(b);
			}
		}
		
		return listOfClients;
	}
	
	public Client getClientByID(int id) throws SQLException {
		try(Connection con = JDBCUtility.getConnection()){
			String sql = "SELECT * FROM clients WHERE client_id = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new Client(rs.getInt("client_id"), rs.getString("client_first_name"),
						rs.getString("client_last_name"));
			}
			else {
				return null;
			}
		}
	}
	
	public Client updateAccount(int clientID, AddClientDTO account) throws SQLException {
		try(Connection con = JDBCUtility.getConnection()) {
			String sql = "Update clients "
					+ "SET client_first_name = ?, "
					+ "		client_last_name = ?, "
					+ "WHERE "
					+ "client_id = ?; ";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, account.getClientFirstName());
			pstmt.setString(2, account.getClientLastName());
			pstmt.setInt(3, clientID);
			
			int numOfRecordsUpdated = pstmt.executeUpdate();
			
			if(numOfRecordsUpdated != 1) {
				throw new SQLException("Unable to update client with an id of "+ clientID);
			}
		}
		return new Client(clientID, account.getClientFirstName(), account.getClientLastName());
	}
	
	public void deleteClientByID(int id) throws SQLException {
		try(Connection con = JDBCUtility.getConnection()){
			String sql = "DELETE FROM clients WHERE client_id = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			int numberOfRecordsDeleted = pstmt.executeUpdate();
			
			if(numberOfRecordsDeleted != 1) {
				throw new SQLException("Unable to delete client with an id of " + id);
			}
		}
	}
	
	public void deleteAllClients() throws SQLException {
		try(Connection con = JDBCUtility.getConnection()) {
			String sql = "DELETE FROM clients";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			int numberOfRecordsDeleted = pstmt.executeUpdate();
			
			if(numberOfRecordsDeleted == 0) {
				throw new SQLException("Unable to delete any records(check if records exist in the table)");
			}
		}
	}
	
}

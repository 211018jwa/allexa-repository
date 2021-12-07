package com.revature.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.model.Reimbursement;
import com.revature.utiliy.JDBCUtility;

public class ReimbursementDAO {
	
	private Logger logger = LoggerFactory.getLogger(ReimbursementDAO.class);

	public List<Reimbursement> getAllReimbursements() throws SQLException {
		logger.info("getAllReimbursements in DAO layer invoked");
		
		try(Connection con = JDBCUtility.getConnection()) {
			List<Reimbursement> reimbursements = new ArrayList<>();
			
			String sql = "SELECT * FROM reimbursement_p1.reimbursements";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int reimbursementID = rs.getInt("id");
				int amount = rs.getInt("amount");
				String submittedTimeStamp = rs.getString("submitted_time_stamp");
				String resolvedTimeStamp = rs.getString("resolved_time_stamp");
				String status = rs.getString("status");
				String type = rs.getString("type");
				String description = rs.getString("description");
				InputStream receipt = rs.getBinaryStream("receipt");
				int managerID = rs.getInt("manager_id");
				int employeeID = rs.getInt("employee_id");
				
				Reimbursement assignment = new Reimbursement(reimbursementID, amount, submittedTimeStamp, 
						resolvedTimeStamp, status, type, description, receipt, managerID, employeeID);
				
				reimbursements.add(assignment);
			}
			
			return reimbursements;
		}
	}

	public List<Reimbursement> getAllReimbursementssByEmployee(int id) throws SQLException {
		logger.info("getAllReimbursements in DAO layer invoked");
		
		try(Connection con = JDBCUtility.getConnection()) {
			List<Reimbursement> reimbursements = new ArrayList<>();
			
			String sql = "SELECT * FROM reimbursement_p1.reimbursements WHERE id = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int reimbursementID = rs.getInt("id");
				int amount = rs.getInt("amount");
				String submittedTimeStamp = rs.getString("submitted_time_stamp");
				String resolvedTimeStamp = rs.getString("resolved_time_stamp");
				String status = rs.getString("status");
				String type = rs.getString("type");
				String description = rs.getString("description");
				InputStream receipt = rs.getBinaryStream("receipt");
				int managerID = rs.getInt("manager_id");
				int employeeID = rs.getInt("employee_id");
				
				Reimbursement reimbursement = new Reimbursement(reimbursementID, amount, submittedTimeStamp, 
						resolvedTimeStamp, status, type, description, receipt, managerID, employeeID);
				
				reimbursements.add(reimbursement);
			}
			
			return reimbursements;
		}
	}

}

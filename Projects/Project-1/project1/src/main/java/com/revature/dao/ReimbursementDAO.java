package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.model.Reimbursement;
import com.revature.utiliy.JDBCUtility;

public class ReimbursementDAO {
	
	private Logger logger = LoggerFactory.getLogger(ReimbursementDAO.class);

	public List<Reimbursement> getAllReimbursements() {
		logger.info("getAllReimbursements in DAO layer invoked");
		
		try(Connection con = JDBCUtility.getConnection()) {
			List<Reimbursement> assignments = new ArrayList<>();
			
			String sql = "SELECT id, assignment_name, grade, grader_id, author_id FROM httpsession_demo.assignments";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String assignmentName = rs.getString("assignment_name");
				int grade = rs.getInt("grade");
				int graderID = rs.getInt("grader_id");
				int authorID = rs.getInt("author_id");
				
				Reimbursement assignment = new Reimbursement(id, assignmentName, grade, graderID, authorID);
				
				assignments.add(assignment);
			}
			
			return assignments;
		}
	}

	public List<Reimbursement> getAllReimbursementssByEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

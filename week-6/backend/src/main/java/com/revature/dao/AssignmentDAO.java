package com.revature.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.model.Assignment;
import com.revature.utility.JDBCUtility;

public class AssignmentDAO {
	
	private Logger logger = LoggerFactory.getLogger(AssignmentDAO.class);
	
	public List<Assignment> getAllAssignments() throws SQLException {
		logger.info("getAllAssignments in DAO layer invoked");
		
		try(Connection con = JDBCUtility.getConnection()) {
			List<Assignment> assignments = new ArrayList<>();
			
			String sql = "SELECT id, assignment_name, grade, grader_id, author_id FROM httpsession_demo.assignments";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String assignmentName = rs.getString("assignment_name");
				int grade = rs.getInt("grade");
				int graderID = rs.getInt("grader_id");
				int authorID = rs.getInt("author_id");
				
				Assignment assignment = new Assignment(id, assignmentName, grade, graderID, authorID);
				
				assignments.add(assignment);
			}
			
			return assignments;
		}
	}
	
	public List<Assignment> getAllAssignmentsByAssociate(int associateID) throws SQLException {
		logger.info("getAllAssignmentsByAssociate in DAO layer invoked");
		
		try (Connection con = JDBCUtility.getConnection()) {
			List<Assignment> assignments = new ArrayList<>();
			
			String sql = "SELECT id, assignment_name, grade, grader_id, author_id FROM httpsession_demo.assignments WHERE author_id = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, associateID);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String assignmentName = rs.getString("assignment_name");
				int grade = rs.getInt("grade");
				int graderId = rs.getInt("grader_id");
				int authorId = rs.getInt("author_id");
				
				Assignment assignment = new Assignment(id, assignmentName, grade, graderId, authorId);
				
				assignments.add(assignment);
			}
			
			return assignments;
		}
	}

	public Assignment getAssignmentById(int assignmentId) throws SQLException {
		try (Connection con = JDBCUtility.getConnection()) {
			
			String sql = "SELECT id, assignment_name, grade, grader_id, author_id FROM httpsession_demo.assignments WHERE id = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, assignmentId);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int id = rs.getInt("id");
				String assignmentName = rs.getString("assignment_name");
				int grade = rs.getInt("grade");
				int graderId = rs.getInt("grader_id");
				int authorId = rs.getInt("author_id");
				
				return new Assignment(id, assignmentName, grade, graderId, authorId);
			} else {
				return null;
			}
			
		}
	}

	public void changeGrade(int id, int grade, int graderId) throws SQLException {
		try (Connection con = JDBCUtility.getConnection()) {
			String sql = "UPDATE httpsession_demo.assignments "
					+ "SET "
					+ "grade = ?, "
					+ "grader_id = ? "
					+ "WHERE id = ?;";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, grade);
			pstmt.setInt(2, graderId);
			pstmt.setInt(3, id);
			
			int updatedCount = pstmt.executeUpdate();
			
			if (updatedCount != 1) {
				throw new SQLException("Something bad occurred when trying to update grade");
			}
		}
		
	}
	
	public Assignment addAssignment(String assignmentName, int authorID, InputStream image) throws SQLException {
		try(Connection con = JDBCUtility.getConnection()) {
			con.setAutoCommit(false);
			
			String sql = "INSERT INTO httpsession_demo.assignments (assignment_name, author_id, assignment_image)"
					+ " VALUES (?, ?, ?);";
			
			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, assignmentName);
			pstmt.setInt(2, authorID);
			pstmt.setBinaryStream(3, image);
			
			int numberOfInsertedRecords = pstmt.executeUpdate();
			
			if(numberOfInsertedRecords != 1) {
				throw new SQLException("Issue occurres when adding assignment");
			}
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			rs.next();
			int generatedID = rs.getInt(1);
			
			con.commit();
			
			return new Assignment(generatedID, assignmentName, 0, 0, authorID);
		}
	}
	
	public InputStream getImageFromAssignmentByID(int id) throws SQLException {
		try(Connection con = JDBCUtility.getConnection()) {
			String sql = "SELECT assigent_image From httpsession_demo.assigments WHERE id = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				InputStream image = rs.getBinaryStream("assigment_image");
				
				return image;
			}
			
			return null;
		}
	}
}

package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dto.AddOrUpdateStudentDTO;
import com.revature.model.Student;
import com.revature.util.JDBCUtility;

public class StudentDAO {
	public Student addStudent(AddOrUpdateStudentDTO student) throws SQLException {
		try(Connection con = JDBCUtility.getConnection()) {
			String sql = "INSERT INTO students (student_first_name, student_last_name, student_classification, student_age) "
					+ " VALUES (?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, student.getFirstName());
			pstmt.setString(2, student.getLastName());
			pstmt.setString(3, student.getClassification());
			pstmt.setInt(4, student.getAge());
			
			int numberOfRecordsInserted = pstmt.executeUpdate();
			
			if(numberOfRecordsInserted != 1) {
				throw new SQLException("Adding a new Student was unsuccessful.");
			}
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			rs.next();
			int automaticallyGeneratedID = rs.getInt(1);
			
			return new Student(automaticallyGeneratedID, student.getFirstName(), student.getLastName(), student.getClassification(), student.getAge());
		}
	}
	
	public List<Student> getAllStudents() throws SQLException {
		List<Student> listOfStudents = new ArrayList<>();
		
		//Obtain Connection
		try(Connection con = JDBCUtility.getConnection()) {
			//obtain a statement object
			String sql = "SELECT * FROM students";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//execute the query
			ResultSet rs = pstmt.executeQuery();
			
			//iterate over the queried data using the ResultSet object
			while(rs.next()) {
				//grab info of current row and create a Student object based on info
				
				int id = rs.getInt("student_id");
				String firstName = rs.getString("student_first_name");
				String lastName = rs.getString("student_last_name");
				String classification = rs.getString("student_classification");
				int age = rs.getInt("student_age");
				
				Student s = new Student(id, firstName, lastName, classification, age);
				
				listOfStudents.add(s);
			}
		}
		return listOfStudents;
	}
	
	public Student getStudentByID(int id) throws SQLException {
		try(Connection con = JDBCUtility.getConnection()) {
			String sql = "SELECT * FROM students WHERE student_id = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new Student(rs.getInt("student_id"), rs.getString("student_first_name"),
						rs.getString("student_last_name"), rs.getString("student_classification"), 
						rs.getInt("student_age"));
			}
			else {
				return null;
			}
		}
	}
	
	public Student updateStudent(int studentID, AddOrUpdateStudentDTO student) throws SQLException {
		try(Connection con = JDBCUtility.getConnection()) {
			String sql = "UPDATE students "
					+ "SET student_first_name = ?,"
					+ "		student_last_name = ?,"
					+ "		student_classification = ?,"
					+ "		student_age = ? "
					+ "WHERE "
					+ "student_id = ?;";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student.getFirstName());
			pstmt.setString(2, student.getLastName());
			pstmt.setString(3, student.getClassification());
			pstmt.setInt(4, student.getAge());
			pstmt.setInt(5, studentID);
			
			int numberOfRecordsUpdated = pstmt.executeUpdate();
			
			if(numberOfRecordsUpdated != 1) {
				throw new SQLException("Unable to update the student w/ id of" + studentID);
			}
		}
		return new Student(studentID, student.getFirstName(), student.getLastName(), student.getClassification(), student.getAge());
	}

	public void deleteStudentByID(int id) throws SQLException {
		try(Connection con = JDBCUtility.getConnection()) {
			String sql = "DELETE FROM students WHERE student_id = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			int numberOfRecordsDeleted = pstmt.executeUpdate();
			
			if(numberOfRecordsDeleted != 1) {
				throw new SQLException("Unable to delete student w/ id of" + id);
			}
		}
	}
	
	public void deleteAllStudents() throws SQLException {
		try(Connection con = JDBCUtility.getConnection()) {
			String sql = "DELETE FROM students";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			int numberOfRecordsDeleted = pstmt.executeUpdate();
			
			if(numberOfRecordsDeleted == 0 ) {
				throw new SQLException("Unable to delete any records(check if records exist in the table)");
			}
		}
	}
}

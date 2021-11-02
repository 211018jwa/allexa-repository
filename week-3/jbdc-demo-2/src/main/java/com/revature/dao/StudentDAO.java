package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Student;
import com.revature.util.JDBCUtility;

public class StudentDAO {
//	public void addStudent(Student student) throws SQLException {
//		try(Connection con = JDBCUtility.getConnection()) {
//			
//		}
//	}
	
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
			String sql = "Select * From students Where student_id = ?";
			
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
//	
//	public void updateStudent(Student student) throws SQLException {
//		try(Connection con = JDBCUtility.getConnection()) {
//			
//		}
//	}
//	
//	public void deleteStudentById(int id) throws SQLException {
//		try(Connection con = JDBCUtility.getConnection()) {
//			
//		}
//	}
}

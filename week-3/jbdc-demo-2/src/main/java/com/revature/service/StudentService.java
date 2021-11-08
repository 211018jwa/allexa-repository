package com.revature.service;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.dao.StudentDAO;
import com.revature.dto.AddOrUpdateStudentDTO;
import com.revature.exceptions.InvalidParameterException;
import com.revature.exceptions.StudentNotFoundException;
import com.revature.model.Student;

public class StudentService {
	
	private Logger logger = LoggerFactory.getLogger(StudentService.class);
	
	private StudentDAO studentDao;
	
	public StudentService() {
		this.studentDao = new StudentDAO();
	}
	
	public StudentService(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}
	
	public Student editFirstName(String studentID, String changeName) throws SQLException, StudentNotFoundException, InvalidParameterException {
		
		try {
			int id = Integer.parseInt(studentID);
			
			Student studentToEdit = this.studentDao.getStudentByID(id);
			
			if(studentToEdit == null) {
				throw new StudentNotFoundException("Student with an id of " + studentID + " was not found");
			}
			
			AddOrUpdateStudentDTO dto = new AddOrUpdateStudentDTO(changeName, studentToEdit.getLastName(), studentToEdit.getClassification(), studentToEdit.getAge());
			
			Student updatedStudent = this.studentDao.updateStudent(id, dto);
			
			return updatedStudent;
		}
		catch(NumberFormatException e) {
			throw new InvalidParameterException("ID provided is not an int compatible value");
		}
	}
	
	public List<Student> getAllStudents() throws SQLException {
		logger.info("getAllStudents() invoked");
		
		List<Student> students = this.studentDao.getAllStudents();
		
		return students;
	}
	
	public Student getStudentByID(String studentID) throws SQLException, InvalidParameterException, StudentNotFoundException{
		try {
			int id = Integer.parseInt(studentID);
			
			Student s = this.studentDao.getStudentByID(id);
			
			if(s == null) {
				throw new StudentNotFoundException("Student with id " + studentID + " was not found ");
			}
			
			return s;
		}
		catch (NumberFormatException e) {
			throw new InvalidParameterException("ID provided is not an int convertable value");
		}
	}
	
	public Student addStudent(AddOrUpdateStudentDTO dto) throws SQLException, InvalidParameterException {
		if(dto.getFirstName().trim().equals("") || dto.getLastName().trim().equals("")) {
			throw new InvalidParameterException("First nameand/or last name cannot be blank");
		}
		
		Set<String> validClassifications = new HashSet<>();
		validClassifications.add("Freshman");
		validClassifications.add("Sophmore");
		validClassifications.add("Junior");
		validClassifications.add("Senior");
		
		if(!validClassifications.contains(dto.getClassification())) {
			throw new InvalidParameterException("You entered an invalid classification");
		}
		
		if(dto.getAge() < 0) {
			throw new InvalidParameterException("Age canot be less than 0");
		}
		
		dto.setFirstName(dto.getFirstName().trim());
		dto.setLastName(dto.getLastName().trim());
		
		Student insertedStudent = this.studentDao.addStudent(dto);
		
		return insertedStudent;
	}
	
	public void deleteStudentByID(String studentID) throws SQLException, StudentNotFoundException, InvalidParameterException {
		try {
			int id = Integer.parseInt(studentID);
			
			Student student = this.studentDao.getStudentByID(id);
			
			if(student == null) {
				throw new StudentNotFoundException("Student with id " + studentID + " was not found, therefore could not be deleted");
			}
			
			this.studentDao.deleteStudentByID(id);
		}
		catch(NumberFormatException e) {
			throw new InvalidParameterException("ID provided is not am int");
		}
		
	}
}

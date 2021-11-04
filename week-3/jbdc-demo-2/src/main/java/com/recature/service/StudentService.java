package com.recature.service;

import java.sql.SQLException;

import com.recature.exceptions.StudentNotFoundException;
import com.revature.dao.StudentDAO;
import com.revature.dto.AddOrUpdateStudentDTO;
import com.revature.model.Student;

public class StudentService {
	
	private StudentDAO studentDao;
	
	public StudentService() {
		this.studentDao = new StudentDAO();
	}
	
	public Student editFirstName(int studentID, String changeName) throws SQLException {
		
		Student studentToEdit = this.studentDao.getStudentByID(studentID);
		
		if(studentToEdit == null) {
			throw new StudentNotFoundException("Student with an id of" + studentID + "was not found");
		}
		
		AddOrUpdateStudentDTO dto = new AddOrUpdateStudentDTO(changeName, studentToEdit.getLastName(), studentToEdit.getClassification(), studentToEdit.getAge());
		
		Student updatedStudent = this.studentDao.updateStudent(studentID, dto);
		
		System.out.println(updatedStudent);
		
		return updatedStudent;
	}
}

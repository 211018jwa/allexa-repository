package com.revature.demo;

import java.sql.SQLException;
import java.util.List;

import com.revature.dao.StudentDAO;
import com.revature.model.Student;

public class Application {
	public static void main(String[] args) {
		
		StudentDAO studentDao = new StudentDAO();
		
		try {
			List<Student> results = studentDao.getAllStudents();
			
			System.out.println(results);
			
			Student s = studentDao.getStudentByID(1);
			System.out.println(s);
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
	}
}
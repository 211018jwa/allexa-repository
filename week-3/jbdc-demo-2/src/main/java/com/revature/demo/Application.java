package com.revature.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.ExceptionMappingController;
import com.revature.controller.GradeController;
import com.revature.controller.StudentController;

import io.javalin.Javalin;


public class Application {
	public static void main(String[] args) {
		
		Javalin app = Javalin.create((config) -> {
			config.enableCorsForOrigin("http://localhost:5500", "http://127.0.0.1:5500", "http://student-app-01.s3-website.us-east-2.amazonaws.com");
		});
		
		Logger logger = LoggerFactory.getLogger(Application.class);
		
		app.before(ctx -> {
			logger.info(ctx.method() + " request received to the " + ctx.path() + " endpoint");
		});
		
		StudentController controller = new StudentController();
		controller.registerEndpoints(app);
		
		ExceptionMappingController exceptionController = new ExceptionMappingController();
		exceptionController.mapExceptions(app);
		
		GradeController gradeController = new GradeController();
		gradeController.registerEndpoints(app);
		
		app.start();
		
//		StudentDAO studentDao = new StudentDAO();
//		
//		StudentService studentService = new StudentService();
//		
//		try {
//			studentService.editFirstName(2, "Jane");
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		catch(StudentNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("Nothing crashed");
//		
//		try {
//			List<Student> results = studentDao.getAllStudents();
//			
//			System.out.println(results);
//			
//			Student s = studentDao.getStudentByID(1);
//			System.out.println(s);
//			Student studentToBeAdded = new Student(0, "Andrew", "Doe", "Junior", 21);
//			
//			AddOrUpdateStudentDTO studentToUpdate = new AddOrUpdateStudentDTO("Megan", "Doe", "Sophmore", 19);
//			Student updatedStudent = studentDao.updateStudent(2, studentToUpdate);
//			System.out.println(updatedStudent);
//			
//			//Student insertedRecord = studentDao.addStudent(studentToBeAdded);
//			//System.out.println(insertedRecord);
//		}
//		catch (SQLException e){
//			e.printStackTrace();
//		}
		
	}
}
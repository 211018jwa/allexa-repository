package com.revature.controller;

import java.util.List;

import com.revature.dto.AddOrUpdateStudentDTO;
import com.revature.dto.ExceptionMessageDTO;
import com.revature.exceptions.InvalidParameterException;
import com.revature.exceptions.StudentNotFoundException;
import com.revature.model.Student;
import com.revature.service.StudentService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class StudentController {
	
	private StudentService studentService;
	
	public StudentController() {
		this.studentService = new StudentService();
	}
	
	private Handler editStudentFirstName = (ctx) -> {
		String studentID = ctx.pathParam("id");
		
		AddOrUpdateStudentDTO dto = ctx.bodyAsClass(AddOrUpdateStudentDTO.class);
		
		Student studentThatWasJustEdited = this.studentService.editFirstName(studentID, dto.getFirstName());
		
		ctx.json(studentThatWasJustEdited);
	};
	
	private Handler addStudent = ctx -> {
		AddOrUpdateStudentDTO dto = ctx.bodyAsClass(AddOrUpdateStudentDTO.class);
		
		Student s = this.studentService.addStudent(dto);
		
		ctx.json(s);
		ctx.status(201);
		
	};
	
	private Handler getAllStudents = ctx -> {
		List<Student> students = this.studentService.getAllStudents();
		ctx.json(students);
	};
	
	private Handler getStudentByID = ctx -> {
		String id = ctx.pathParam("id");
		
		Student s = this.studentService.getStudentByID(id);
		
		ctx.json(s);
	};
	
	private Handler editStudentByID = ctx -> {
		
	};
	
	private Handler deleteStudentByID = ctx -> {
		String id = ctx.pathParam("id");
		
		this.studentService.deleteStudentByID(id);
	};
	
	private Handler deleteAllStudents = ctx -> {
		
	};
	
	public void registerEndpoints(Javalin app) {
		app.patch("/students/{id}/firstname", editStudentFirstName);
		
		app.post("/students", addStudent);
		app.get("/students", getAllStudents);
		app.get("/students/{id}", getStudentByID);
		app.put("/students/{id}", editStudentByID);
		app.delete("/students/{id}", deleteStudentByID);
		app.delete("/students", deleteAllStudents);
	}
	
}

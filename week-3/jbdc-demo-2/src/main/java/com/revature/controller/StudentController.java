package com.revature.controller;

import com.recature.exceptions.StudentNotFoundException;
import com.recature.service.StudentService;
import com.revature.dto.EditFirstNameDTO;
import com.revature.model.Student;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class StudentController {
	
	private StudentService studentService;
	
	public StudentController() {
		this.studentService = new StudentService();
	}
	
	private Handler editStudentFirstName = (ctx) -> {
		String studentID = ctx.pathParam("id");
		
		int id = Integer.parseInt(studentID);
		
		EditFirstNameDTO dto = ctx.bodyAsClass(EditFirstNameDTO.class);
		
		try{ 
			Student studentThatWasJustEdited = this.studentService.editFirstName(id, dto.getFirstName());
			
			ctx.json(studentThatWasJustEdited);
		}
		catch(StudentNotFoundException e) {
			ctx.status(404);
			ctx.json(e);
		}
		
		//System.out.println(studentID);
	};
	
	public void registerEndpoints(Javalin app) {
		app.patch("/students/{id}/firstname", editStudentFirstName);
	}
	
}

package com.revature.controller;

import com.revature.model.User;
import com.revature.service.AuthorizationService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class StudentController implements Controller{
	
	private AuthorizationService authorizationService;
	
	public StudentController() {
		this.authorizationService = new AuthorizationService();
	}
	
	private Handler getStudentByID = (ctx) -> {
		User user = (User) ctx.req.getSession().getAttribute("currentuser");
		this.authorizationService.authorizeRegularAndAdmin(user);
		
		String id = ctx.pathParam("studentID");
	};
	
	private Handler addStudent = (ctx) -> {
		User user = (User) ctx.req.getSession().getAttribute("currentuser");
		this.authorizationService.authorizeAdmin(user);
	};
	
	@Override
	public void mapEndPoints(Javalin app) {
		app.get("/students/{studentID}", getStudentByID);
		app.post("/students", addStudent);
		
	}
	
}

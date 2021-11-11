package com.revature.controller;

import java.util.List;

import com.revature.model.Grade;
import com.revature.service.GradeService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class GradeController {

	private GradeService gradeService;
	
	public GradeController() {
		this.gradeService = new GradeService();
	}
	
	private Handler getAllGradesByStudentID = (ctx) -> {
		String studentID = ctx.queryParam("id");
		
		List<Grade> grades = this.gradeService.getAllGradesByStudentID(studentID, ctx);
		
		ctx.json(grades);
	};
	
	public void registerEndpoints(Javalin app) {
		app.get("/students/{id}/grades", getAllGradesByStudentID);
	}
}

package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.dao.GradeDAO;
import com.revature.dao.StudentDAO;
import com.revature.exceptions.StudentNotFoundException;
import com.revature.model.Grade;
import com.revature.model.Student;

import io.javalin.http.Context;

public class GradeService {
	
	private GradeDAO gradeDao;
	private StudentDAO studentDao;
	
	public GradeService() {
		this.gradeDao = new GradeDAO();
		this.studentDao = new StudentDAO();
	}
	
	public GradeService(GradeDAO gradeDao, StudentDAO studentDao) {
		this.gradeDao = gradeDao;
		this.studentDao = studentDao;
	}
	
	public List<Grade> getAllGradesByStudentID(String studentID, Context ctx) throws SQLException, StudentNotFoundException {
		
		List<Grade> grades;
		
		int id = Integer.parseInt(studentID);
		
		if(ctx.queryParam("greaterThan") != null && ctx.queryParam("lessThan") != null) {
			int greaterThan = Integer.parseInt(ctx.queryParam("greaterThan"));
			int lessThan = Integer.parseInt(ctx.queryParam("lessThan"));
			
			grades = this.gradeDao.getAllGradesByStudentID(id, greaterThan, lessThan);
		}
		else if(ctx.queryParam("greaterThan") != null) {
			int greaterThan = Integer.parseInt(ctx.queryParam("greaterThan"));
			
			grades = this.gradeDao.getAllGradesByStudentID(id, greaterThan, 100);
		}
		else if(ctx.queryParam("lessThan") != null) {
			int lessThan = Integer.parseInt(ctx.queryParam("lessThan"));
			
			grades = this.gradeDao.getAllGradesByStudentID(id, 0, lessThan);
		}
		else {
			grades = this.gradeDao.getAllGradesByStudentID(id, 0, 100);
		}
		
		return grades;
	}
}

package com.revature.controller;

import java.io.InputStream;
import java.util.List;

import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.dto.ChangeGradeDTO;
import com.revature.dto.MessageDTO;
import com.revature.model.Assignment;
import com.revature.model.User;
import com.revature.service.AssignmentService;
import com.revature.service.AuthorizationService;

import io.javalin.Javalin;
import io.javalin.http.Handler;
import io.javalin.http.UploadedFile;

public class AssignmentController implements Controller {
	
	private AuthorizationService authService;
	private AssignmentService assignmentService;
	
	private Logger logger = LoggerFactory.getLogger(AssignmentController.class);
	
	public AssignmentController() {
		this.authService = new AuthorizationService();
		this.assignmentService = new AssignmentService();
	}
	
	private Handler getAssignments = (ctx) -> {
		User currentlyLoggedInUser = (User) ctx.req.getSession().getAttribute("currentuser");
		this.authService.authorizeAssociateAndTrainer(currentlyLoggedInUser);
		
		logger.info("AssignmentController layer: CurrentUser {}", currentlyLoggedInUser);
		
		List<Assignment> assignments = this.assignmentService.getAssignment(currentlyLoggedInUser);
		
		ctx.json(assignments);
	};
	
	private Handler changeGrade = (ctx) -> {
		User currentlyLoggedInUser = (User) ctx.req.getSession().getAttribute("currentuser");
		this.authService.authorizeTrainer(currentlyLoggedInUser);
		
		String assignmentID = ctx.pathParam("id");
		ChangeGradeDTO dto = ctx.bodyAsClass(ChangeGradeDTO.class);
		
		Assignment changedAssignment = this.assignmentService.changeGrade(currentlyLoggedInUser, assignmentID, dto.getGrade());
		ctx.json(changedAssignment);
	};
	
	private Handler addAssignment = (ctx) -> {
		User currentlyLoggedInUser = (User) ctx.req.getSession().getAttribute("currentuser");
		this.authService.authorizeAssociate(currentlyLoggedInUser);
		
		String assignmentName = ctx.formParam("assignment_name");
		
		UploadedFile file = ctx.uploadedFile("assignment_image");
		
		if(file == null) {
			ctx.status(400);
			ctx.json(new MessageDTO("Must have an image to upload"));
			return;
		}
		
		InputStream content = file.getContent();
		
		Tika tika = new Tika();
		
		String mimeType = tika.detect(content);
		
		Assignment addedAssignment = this.assignmentService.addAssignment(currentlyLoggedInUser, mimeType, assignmentName, content);
		ctx.json(addedAssignment);
		ctx.status();
	};
	
	private Handler getImageFromAssignmentByID = (ctx) -> {
		User currentlyLoggedInUser = (User) ctx.req.getSession().getAttribute("currentuser");
		this.authService.authorizeAssociateAndTrainer(currentlyLoggedInUser);
		
		String assignmentID = ctx.pathParam("id");
		
		InputStream image = this.assignmentService.getImageFromAssignmentByID(currentlyLoggedInUser, assignmentID);
		
		Tika tika = new Tika();
		String mimeType = tika.detect(image);
		
		ctx.contentType(mimeType);
		ctx.result(image);
	};

	@Override
	public void mapEndPoints(Javalin app) {
		app.get("/assignments", getAssignments);
		app.patch("/assignments/{id}/grade", changeGrade);
		app.put("/assignments", addAssignment);
		app.get("assignments/{id}/image", getImageFromAssignmentByID);
	}}

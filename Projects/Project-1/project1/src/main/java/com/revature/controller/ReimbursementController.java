package com.revature.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.service.AuthenticationService;
import com.revature.service.ReimbursementService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ReimbursementController implements Controller {
	
	private AuthenticationService authenService;
	private ReimbursementService reimbursementService;
	
	private Logger logger = LoggerFactory.getLogger(ReimbursementController.class);
	
	public ReimbursementController() {
		this.reimbursementService = new ReimbursementService();
	}
	
	private Handler getReimbursements = (ctx) -> {
		User currentlyLoggedInUser = (User) ctx.req.getSession().getAttribute("currentuser");
		this.authenService.authorizeEmployeeAndManager(currentlyLoggedInUser);
		
		logger.info("ReimbursementController layer: CurrentUser {}", currentlyLoggedInUser);
		
		List<Reimbursement> reimbursements = this.reimbursementService.getReimbursements(currentlyLoggedInUser);
		
		ctx.json(reimbursements);
	};

	@Override
	public void mapEndPoints(Javalin app) {
		app.get("/reimbursements", getReimbursements);
		
	}
}

package com.revature.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.dao.ReimbursementDAO;
import com.revature.model.Reimbursement;
import com.revature.model.User;

public class ReimbursementService {
	
	private ReimbursementDAO reimbursementDao;
	
	private Logger logger = LoggerFactory.getLogger(ReimbursementService.class);

	public List<Reimbursement> getReimbursements(User currentlyLoggedInUser) {
		List<Reimbursement> reimbursements = null;
		
		if(currentlyLoggedInUser.getUserRole().equals("manager")) {
			reimbursements = this.reimbursementDao.getAllReimbursements();
		}
		else if(currentlyLoggedInUser.getUserRole().equals("employee")) {
			reimbursements = this.reimbursementDao.getAllReimbursementssByEmployee(currentlyLoggedInUser.getId());
		}
		
		logger.info("AssignmentService layer: CurrentUser {}", currentlyLoggedInUser);
		
		return reimbursements;
	}

}

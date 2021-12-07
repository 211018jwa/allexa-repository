package com.revature.service;

import java.io.InputStream;
import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.dao.AssignmentDAO;
import com.revature.exception.AssignmentAlreadyGradedException;
import com.revature.exception.AssignmentImageNotFoundException;
import com.revature.exception.AssignmentNotFoundException;
import com.revature.exception.UnauthorizedException;
import com.revature.model.Assignment;
import com.revature.model.User;

public class AssignmentService {
	
	private AssignmentDAO assignmentDao;
	
	private Logger logger = LoggerFactory.getLogger(AssignmentService.class);
	
	public AssignmentService() {
		this.assignmentDao = new AssignmentDAO();
	}
	
	public AssignmentService(AssignmentDAO assignmentDao) {
		this.assignmentDao = assignmentDao;
	}
	
	public List<Assignment> getAssignment(User currentlyLoggedInUser) throws SQLException {
		List<Assignment> assignments = null;
		
		if(currentlyLoggedInUser.getUserRole().equals("trainer")) {
			assignments = this.assignmentDao.getAllAssignments();
		}
		else if(currentlyLoggedInUser.getUserRole().equals("associate")) {
			assignments = this.assignmentDao.getAllAssignmentsByAssociate(currentlyLoggedInUser.getId());
		}
		
		logger.info("AssignmentService layer: CurrentUser {}", currentlyLoggedInUser);
		
		return assignments;
	}

	public Assignment changeGrade(User currentlyLoggedInUser, String assignmentID, int grade) throws SQLException, AssignmentNotFoundException, AssignmentAlreadyGradedException {
		try {
			int id = Integer.parseInt(assignmentID);
			
			Assignment assignment = this.assignmentDao.getAssignmentById(id);
			
			if(assignment == null) {
				throw new AssignmentNotFoundException("Assignment with id " + assignmentID + " was not found");
			}
			
			if(assignment.getGraderID() == 0) {
				this.assignmentDao.changeGrade(id, grade, currentlyLoggedInUser.getId());
			}
			else {
				throw new AssignmentAlreadyGradedException("Assignment has already been graded, so we cannot assign another grade"
						+ " to the assignment");
			}
			
			return this.assignmentDao.getAssignmentById(id);
		}
		catch(NumberFormatException e) {
			throw new InvalidParameterException("Assigment id supplied must be an int");
		}
	}

	public Assignment addAssignment(User currentlyLoggedInUser, String mimeType, String assignmentName, InputStream content) throws SQLException {
		Set<String> allowedFileTypes = new HashSet<>();
		allowedFileTypes.add("image/jpeg");
		allowedFileTypes.add("image/png");
		allowedFileTypes.add("image/gif");
		
		if(!allowedFileTypes.contains(mimeType)) {
			throw new InvalidParameterException("When adding an assignment image, only PNG, JPEG, or GIF are allowed");
		}
		
		int authorID = currentlyLoggedInUser.getId();
		
		Assignment addedAssignment = this.assignmentDao.addAssignment(assignmentName, authorID, content);
		
		return addedAssignment;
		
	}

	public InputStream getImageFromAssignmentByID(User currentlyLoggedInUser, String assignmentID) throws SQLException, UnauthorizedException, AssignmentImageNotFoundException {
		try {
			int id = Integer.parseInt(assignmentID);
			if(currentlyLoggedInUser.getUserRole().equals("associate")) {
				int associateID = currentlyLoggedInUser.getId();
				List<Assignment> assignmentsThatBelongToAssociate = this.assignmentDao.getAllAssignmentsByAssociate(associateID);
				
				Set<Integer> assignmentIDsEncountered = new HashSet<>();
				for(Assignment a : assignmentsThatBelongToAssociate) {
					assignmentIDsEncountered.add(a.getId());
				}
				
				if(!assignmentIDsEncountered.contains(id)) {
					throw new UnauthorizedException("You cannot access the images of assignments that do not belong to yourself");
				}
			}
			
			InputStream image = this.assignmentDao.getImageFromAssignmentByID(id);
			
			if(image == null) {
				throw new AssignmentImageNotFoundException(" Image was not found for assignment id " + id);
			}
			
			return image;
		}
		catch(NumberFormatException e) {
			throw new InvalidParameterException("Assignment id supplied must be an int");
		}
	}
}

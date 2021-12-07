package com.revature.service;

import com.revature.exception.UnauthorizedException;
import com.revature.model.User;

public class AuthorizationService {
	public void authorizeAssociateAndTrainer(User user) throws UnauthorizedException {
		if(!(user.getUserRole().equals("associate") || user.getUserRole().equals("trainer"))) {
			throw new UnauthorizedException("You must have an associate or trainer role to access this resource");
		}
	}

	public void authorizeTrainer(User user) throws UnauthorizedException {
		if(user == null || !user.getUserRole().equals("trainer")) {
			throw new UnauthorizedException("You must have a trainer role to access this resource");
		}
	}

	public void authorizeAssociate(User user) throws UnauthorizedException {
		if(user == null || !user.getUserRole().equals("associate")) {
			throw new UnauthorizedException("You must have a associate role to access this resource");
		}
	}
}

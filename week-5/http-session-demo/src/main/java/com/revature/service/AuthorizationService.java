package com.revature.service;

import com.revature.exception.UnauthorizedException;
import com.revature.model.User;

public class AuthorizationService {
	public void authorizeRegularAndAdmin(User user) throws UnauthorizedException {
		if(!(user.getUserRole().equals("regular") || user.getUserRole().equals("admin"))) {
			throw new UnauthorizedException("You must have a regular or admin role to access this resource");
		}
	}

	public void authorizeAdmin(User user) throws UnauthorizedException {
		if(user == null || !user.getUserRole().equals("admin")) {
			throw new UnauthorizedException("You must have an admin role to access this resource");
		}
		
	}
}

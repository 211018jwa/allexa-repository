package com.revature.app;

import com.revature.controller.ClientController;
import com.revature.controller.ExceptionMappingController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.BankAccountController;

import io.javalin.Javalin;

public class Application {
	
	public static void main(String[] args) {

		Javalin app = Javalin.create();
		
		Logger logger = LoggerFactory.getLogger(Application.class);
		
		app.before(ctx -> {
			logger.info(ctx.method() + " request received to the " + ctx.path() + " endpoint");
		});
		
		ClientController clientController = new ClientController();
		BankAccountController  bankAccountController = new BankAccountController();
		
		clientController.registerEndpoints(app);
		bankAccountController.registerEndpoints(app);
		
		ExceptionMappingController exceptionController = new ExceptionMappingController();
		exceptionController.mapExceptions(app);
		
		app.start();
	}
	
}

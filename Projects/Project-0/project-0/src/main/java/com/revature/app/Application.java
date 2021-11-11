package com.revature.app;

import com.revature.controller.ClientController;
import com.revature.controller.BankAccountController;

import io.javalin.Javalin;

public class Application {
	
	public static void main(String[] args) {

		Javalin app = Javalin.create();
		
		ClientController clientController = new ClientController();
		BankAccountController  bankAccountController = new BankAccountController();
		
		clientController.registerEndpoints(app);
		bankAccountController.registerEndpoints(app);
		
		app.start();
	}
	
}

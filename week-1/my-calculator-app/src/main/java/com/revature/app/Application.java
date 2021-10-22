package com.revature.app;

import com.revature.controller.ArithmeticController;

import io.javalin.Javalin;

public class Application {
	
	public static void main(String[] args) {
		Javalin app = Javalin.create();
		
		ArithmeticController controller1 = new ArithmeticController();
		controller1.registerEndpoint(app);
		
		app.start(8080); // start server on port 8080
	}
	
}

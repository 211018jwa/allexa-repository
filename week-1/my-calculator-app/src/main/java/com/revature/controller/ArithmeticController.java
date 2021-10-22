package com.revature.controller;

import com.revature.service.ArithmeticService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ArithmeticController {
	
	public ArithmeticService arithmeticService;
	
	public ArithmeticController() {
		this.arithmeticService = new ArithmeticService();
	}
	
	public Handler add = (ctx) -> {
		//System.out.println("add lambda invoked");
		ctx.result("add lambda invoked");
		
		String num1Str = ctx.formParam("number1");
		String num2Str = ctx.formParam("number2");
		
		ctx.result(arithmeticService.doAddition(num1Str, num2Str));
	};
	
	public void registerEndpoint(Javalin app) {
		app.post("/add", add);
	}
	
}

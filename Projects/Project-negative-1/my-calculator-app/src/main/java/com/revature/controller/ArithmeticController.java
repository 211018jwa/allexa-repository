package com.revature.controller;

import com.revature.service.ArithmeticService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ArithmeticController {
	
	public ArithmeticService arithmeticService;
	
	public ArithmeticController(ArithmeticService arithmeticService) {
		this.arithmeticService = arithmeticService;
	}
	
	public Handler add = (ctx) -> {
		//System.out.println("add lambda invoked");
		//ctx.result("add lambda invoked");
		
		String number1Str = ctx.formParam("number1");
		String number2Str = ctx.formParam("number2");
		
		ctx.result(arithmeticService.doAddition(number1Str, number2Str));
	};
	
	public Handler subtract = (ctx) -> {
		String number3Str = ctx.formParam("number1");
		String number4Str = ctx.formParam("number2");
		
		ctx.result(arithmeticService.doSubtraction(number3Str, number4Str));
	};
	
	public Handler multiply = (ctx) -> {
		String number5Str = ctx.formParam("number1");
		String number6Str = ctx.formParam("number2");
		
		ctx.result(arithmeticService.doMultiplication(number5Str, number6Str));
	};
	
	public Handler divide = (ctx) -> {
		String number7Str = ctx.formParam("number1");
		String number8Str = ctx.formParam("number2");
		
		ctx.result(arithmeticService.doDivision(number7Str, number8Str));
	};
	
	public void registerEndpoint(Javalin app) {
		app.post("/add", add);
		app.post("/subtract", subtract);
		app.post("/multiply", multiply);
		app.post("/divide", divide);
	}
	
}

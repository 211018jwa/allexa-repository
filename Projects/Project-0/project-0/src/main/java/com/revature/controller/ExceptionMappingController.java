package com.revature.controller;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.revature.dto.ExceptionMessageDTO;
import com.revature.exceptions.InvalidParameterException;
import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.ClientNotFoundException;

import io.javalin.Javalin;

public class ExceptionMappingController {

	public void mapExceptions(Javalin app) {
		app.exception(UnrecognizedPropertyException.class, (e, ctx) -> {
			ctx.status(400);
			ctx.json(new ExceptionMessageDTO(e));
		});
		
		app.exception(InvalidParameterException.class, (e, ctx) -> {
			ctx.json(new ExceptionMessageDTO(e));
			ctx.status(400);
		});
		
		app.exception(AccountNotFoundException.class, (e, ctx) -> {
			ctx.json(new ExceptionMessageDTO(e));
			ctx.status(404);
		});
		
		app.exception(ClientNotFoundException.class, (e, ctx) -> {
			ctx.json(new ExceptionMessageDTO(e));
			ctx.status(404);
		});
		
	}
	
}
package com.revature.controller;

import java.util.List;

import com.revature.model.BankAccount;
import com.revature.service.BankAccountService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class BankAccountController {
	private BankAccountService bankAccountService;
	
	public BankAccountController() {
		this.bankAccountService = new BankAccountService();
	}
	
	private Handler getAllAccountsByClientID = (ctx) -> {
		String studentID = ctx.queryParam("id");
		
		List<BankAccount> accounts = this.bankAccountService.getAllAccountsByClientID(studentID, ctx);
		
		ctx.json(accounts);
	};
	
	
	public void registerEndpoints(Javalin app) {
		app.get("/clients/{id}/accounts", getAllAccountsByClientID);
	}

}

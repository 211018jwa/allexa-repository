package com.revature.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.dto.AddBankAccountDTO;
import com.revature.model.BankAccount;
import com.revature.service.BankAccountService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class BankAccountController {
	private BankAccountService bankAccountService;
	
	private Logger logger = LoggerFactory.getLogger(BankAccountController.class);
	
	public BankAccountController() {
		this.bankAccountService = new BankAccountService();
	}
	
	private Handler addBankAccount = (ctx) -> {
		String clientID = ctx.pathParam("client_id");
		AddBankAccountDTO dto = ctx.bodyAsClass(AddBankAccountDTO.class);
		
		BankAccount b = this.bankAccountService.addAccount(dto, clientID);
		
		ctx.json(b);
		ctx.status(201);
	};
	
	private Handler getAllAccountsByClientID = (ctx) -> {
		String clientID = ctx.pathParam("client_id");
		
		logger.info("AccountController layer: client id {}", clientID);
		
		List<BankAccount> accounts;
		
		if (ctx.queryParam("greaterThan") != null && ctx.queryParam("lessThan") != null) { // Using both
			int greaterThan = Integer.parseInt(ctx.queryParam("greaterThan"));
			int lessThan = Integer.parseInt(ctx.queryParam("lessThan"));
			
			accounts = this.bankAccountService.getAllAccountsByClientID(clientID, greaterThan, lessThan);
		} else if (ctx.queryParam("lessThan") != null) { // using only lessThan
			
			int lessThan = Integer.parseInt(ctx.queryParam("lessThan"));
					
			accounts = this.bankAccountService.getAllAccountsByClientID(clientID, 0, lessThan);
		} else if (ctx.queryParam("greaterThan") != null) { // using only greaterThan
			
			int greaterThan = Integer.parseInt(ctx.queryParam("greaterThan"));
			
			accounts = this.bankAccountService.getAllAccountsByClientID(clientID, greaterThan, 1000000);
			
		} else {
			accounts = this.bankAccountService.getAllAccountsByClientID(clientID, 0, 1000000);
		}
			
		ctx.json(accounts);
		ctx.status(201);
	};
	
	private Handler getAccountByIDAndClientID = (ctx) -> {
		String clientID = ctx.pathParam("client_id");
		String accountID = ctx.pathParam("account_id");
		
		BankAccount account = this.bankAccountService.getAccountByIDAndClientID(clientID, accountID);
		
		ctx.json(account);
	};
	
	private Handler editBalance = (ctx) -> {
		String clientID = ctx.pathParam("client_id");
		String accountID = ctx.pathParam("account_id");
		String balance1 = ctx.pathParam("balance");
		
		logger.info("AccountController layer: balance {}", balance1);
		
		BankAccount accountEdited = this.bankAccountService.editBalance(clientID, accountID, balance1);
		
		ctx.json(accountEdited);
	};
	
	private Handler deleteBankAccountByID = (ctx) -> {
		String clientID = ctx.pathParam("client_id");
		String accountID = ctx.pathParam("account_id");
		
		this.bankAccountService.deleteBankAccountByID(clientID, accountID);
	};
	
	
	public void registerEndpoints(Javalin app) {
		app.post("/clients/{client_id}/accounts", addBankAccount);
		app.get("/clients/{client_id}/accounts", getAllAccountsByClientID);
		app.get("/clients/{client_id}/accounts/{account_id}", getAccountByIDAndClientID);
		app.patch("/clients/{client_id}/accounts/{account_id}/{balance}", editBalance);
		app.delete("/clients/{client_id}/accounts/{account_id}",deleteBankAccountByID);
	}

}

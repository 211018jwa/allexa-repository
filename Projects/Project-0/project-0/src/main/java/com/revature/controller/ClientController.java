package com.revature.controller;

import java.util.List;

import com.revature.dto.AddClientDTO;
import com.revature.model.Client;
import com.revature.service.ClientService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ClientController {
	
	private ClientService clientService;

	public ClientController() {
		this.clientService = new ClientService();
	}
	
	private Handler addClient = ctx -> {
		AddClientDTO dto = ctx.bodyAsClass(AddClientDTO.class);
		
		Client c = this.clientService.addClient(dto);
		
		ctx.json(c);
		ctx.status(201);
	};
	
	private Handler getAllClients = ctx -> {
		List<Client> clients = this.clientService.getAllClients();
		ctx.json(clients);
	};
	
	private Handler getClientByID = ctx -> {
		String clientID = ctx.pathParam("client_id");
		
		Client c = this.clientService.getClientByID(clientID);
		
		ctx.json(c);
	};
	
	private Handler editClientByID = ctx -> {
		String id = ctx.pathParam("client_id");
		String firstName = ctx.pathParam("firstname");
		
		Client s = this.clientService.editFirstName(id, firstName);
		
		ctx.json(s);
		ctx.status(201);
	};
	
	private Handler deleteClientByID = ctx -> {
		String clientID = ctx.pathParam("client_id");
		
		this.clientService.deleteClientByID(clientID);
	};
	
	private Handler editClientFirstName = (ctx) -> {
		String clientID = ctx.pathParam("client_id");
		
		AddClientDTO dto = ctx.bodyAsClass(AddClientDTO.class);
		
		Client EditedClient = this.clientService.editFirstName(clientID, dto.getClientFirstName());
		
		ctx.json(EditedClient);
	};
	
	
	
	public void registerEndpoints(Javalin app) {
		app.post("/clients", addClient);
		app.get("/clients", getAllClients);
		app.get("/clients/{client_id}", getClientByID);
		app.put("/clients/{client_id}", editClientByID);
		app.delete("/clients/{client_id}", deleteClientByID);
		
		app.patch("/clients/{client_id}/firstname", editClientFirstName);
	}
}

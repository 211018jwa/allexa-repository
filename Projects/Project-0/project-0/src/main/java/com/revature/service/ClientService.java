package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.dao.ClientDAO;
import com.revature.dto.AddClientDTO;
import com.revature.exceptions.ClientNotFoundException;
import com.revature.exceptions.InvalidParameterException;
import com.revature.model.Client;

public class ClientService {
	private ClientDAO clientDao;

	public ClientService() {
		this.clientDao = new ClientDAO();
	}
	
	public ClientService(ClientDAO clientDao) {
		this.clientDao = clientDao;
	}
	
	public Client editFirstName(String clientID, String changeName) throws SQLException, ClientNotFoundException, InvalidParameterException {
		try {
			int id = Integer.parseInt(clientID);
			
			Client clientToEdit = this.clientDao.getClientByID(id);
			
			if(clientToEdit == null) {
				throw new ClientNotFoundException("Client with id of " + clientID + " was not found.");
			}
			
			AddClientDTO dto = new AddClientDTO(changeName, clientToEdit.getClientLastName());
			
			Client updatedClient = this.clientDao.updateClient(id, dto);
			
			return updatedClient;
		}
		catch(NumberFormatException e) {
			throw new InvalidParameterException("ID provided is not an int compatible value.");
		}
	}
	
	public List<Client> getAllClients() throws SQLException {
		List<Client> clients = this.clientDao.getAllClients();
		
		return clients;
	}
	
	public Client getClientByID(String clientID) throws SQLException, ClientNotFoundException, InvalidParameterException {
		try {
			int id = Integer.parseInt(clientID);
			
			Client c = this.clientDao.getClientByID(id);
			
			if(c == null) {
				throw new ClientNotFoundException("Client with id of " + clientID + " was not found.");
			}
			
			return c;
		}
		catch(NumberFormatException e) {
			throw new InvalidParameterException("ID provided is not an int compatible value.");
		}
	}
	
	public Client addClient(AddClientDTO dto) throws SQLException, InvalidParameterException {
		if(dto.getClientFirstName().trim().equals("") || dto.getClientLastName().trim().equals("")) {
			throw new InvalidParameterException("First name and/pr last name cannot be blank");
		}
		
		dto.setClientFirstName(dto.getClientFirstName().trim());
		dto.setClientLastName(dto.getClientLastName().trim());
		
		Client insertedClient = this.clientDao.addClient(dto);
		return insertedClient;
	}
	
	public void deleteClientByID(String clientID) throws SQLException, InvalidParameterException, ClientNotFoundException {
		try {
			int id = Integer.parseInt(clientID);
			
			Client client = this.clientDao.getClientByID(id);
			
			if(client == null) {
				throw new ClientNotFoundException("Client with id " + clientID + " was not found, therefore could not be deleted.");
			}
		}
		catch(NumberFormatException e) {
			throw new InvalidParameterException("ID provided is not an int");
		}
	}
	
}

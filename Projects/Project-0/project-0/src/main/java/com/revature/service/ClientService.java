package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.dao.ClientDAO;
import com.revature.dto.AddClientDTO;
import com.revature.model.Client;

public class ClientService {
	private ClientDAO clientDao;

	public ClientService() {
		this.clientDao = new ClientDAO();
	}
	
	public ClientService(ClientDAO clientDao) {
		this.clientDao = clientDao;
	}
	
	public Client editFirstName(String clientID, String changeName) {
		
		return null;
	}
	
	public List<Client> getAllClients() throws SQLException {
		List<Client> clients = this.clientDao.getAllClients();
		
		return clients;
	}
	
	public Client getClientByID(String clientID) {
		
		return null;
	}
	
	public Client addClient(AddClientDTO dto) {
		
		return null;
	}
	
	public void deleteClientByID(String clientID) {
		
	}
	
}

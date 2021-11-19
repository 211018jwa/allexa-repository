package com.revature.tests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.revature.dao.BankAccountDAO;
import com.revature.dao.ClientDAO;
import com.revature.dto.AddClientDTO;
import com.revature.exceptions.ClientNotFoundException;
import com.revature.exceptions.InvalidParameterException;
import com.revature.model.BankAccount;
import com.revature.model.Client;
import com.revature.service.BankAccountService;
import com.revature.service.ClientService;

import io.javalin.http.Context;

public class ClientTesting {
	@Test
	public void testGetAllClientsPositive() throws SQLException {
		ClientDAO mockClientDao = mock(ClientDAO.class);
		
		Client client1 = new Client(10,"Ray", "Monroe");
		Client client2 = new Client(11,"Alex", "Russo");
		Client client3 = new Client(12,"Jane", "Adams");
		Client client4 = new Client(13,"Tori", "Cooper");
		
		List<Client> clientsFromDao = new ArrayList<>();
		clientsFromDao.add(client1);
		clientsFromDao.add(client2);
		clientsFromDao.add(client3);
		clientsFromDao.add(client4);
		
		BankAccountDAO mockBankAccountDao = mock(BankAccountDAO.class);
		
		when(mockClientDao.getAllClients()).thenReturn(clientsFromDao);
		
		ClientService clientService = new ClientService(mockClientDao, mockBankAccountDao);
		
		List<Client> actual = clientService.getAllClients();
		
		List<Client> expected = new ArrayList<>();
		expected.add(new Client(10,"Ray", "Monroe"));
		expected.add(new Client(11,"Alex", "Russo"));
		expected.add(new Client(12, "Jane", "Adams"));
		expected.add(new Client(13,"Tori", "Cooper"));
		
		Assertions.assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGetClientByIDPositive() throws SQLException, ClientNotFoundException, InvalidParameterException {
		ClientDAO mockClientDao = mock(ClientDAO.class);
		
		Client client1 = new Client(10, "Ray", "Monroe");
		
		BankAccountDAO mockBankAccountDao = mock(BankAccountDAO.class);
		
		when(mockClientDao.getClientByID(eq(10))).thenReturn(client1);
		
		ClientService clientService = new ClientService(mockClientDao, mockBankAccountDao);
		
		Client actual = clientService.getClientByID("10");
		
		Client expected = new Client(10,"Ray", "Monroe");
		
		Assertions.assertEquals(expected, actual);
		
	}
	
	@Test
	public void testADDClientPositive() throws SQLException, ClientNotFoundException, InvalidParameterException {
		ClientDAO mockClientDao = mock(ClientDAO.class);
		
		BankAccountDAO mockBankAccountDao = mock(BankAccountDAO.class);
		
		AddClientDTO client5 = new AddClientDTO("James", "Tanner");
		ClientService clientService = new ClientService(mockClientDao, mockBankAccountDao);
		
		when(mockClientDao.addClient(eq(client5))).thenReturn(new Client(200, "James", "Tanner"));
		Client actual = clientService.addClient(client5);
		
		Assertions.assertEquals(new Client(200, "James", "Tanner"), actual);
		
	}
	
	@Test
	public void testGetAllAccountsByIDPositive() throws SQLException, InvalidParameterException, ClientNotFoundException {
		BankAccountDAO mockBankAccountDao = mock(BankAccountDAO.class);
		
		BankAccount account1 = new BankAccount(1, "Checking", 30000, 10);
		BankAccount account5 = new BankAccount(2, "Checking", 70000, 10);
		
		List<BankAccount> accountsFromDao = new ArrayList<>();
		accountsFromDao.add(account1);
		accountsFromDao.add(account5);
		
		when(mockBankAccountDao.getAllAccountsByClientID(eq(10), eq(0), eq(1000000))).thenReturn(accountsFromDao);
		
		BankAccountService accountService = new BankAccountService(mockBankAccountDao);
		
		List<BankAccount> actual = accountService.getAllAccountsByClientID("10", 0, 1000000);
		
		List<BankAccount> expected = new ArrayList<>();
		expected.add(new BankAccount(1, "Checking", 30000, 10));
		expected.add(new BankAccount(2, "Checking", 70000, 10));
		
		Assertions.assertEquals(expected, actual);
		
	}
}

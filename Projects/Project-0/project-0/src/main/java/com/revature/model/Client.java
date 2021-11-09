package com.revature.model;

import java.util.Objects;

public class Client {
	private int clientID;
	private String clientFirstName;
	private String clientLastName;
	
	public Client() {
		
	}
	
	public Client(int clientID, String clientFirstName, String clientLastName) {
		super();
		this.clientID = clientID;
		this.clientFirstName = clientFirstName;
		this.clientLastName = clientLastName;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public String getClientFirstName() {
		return clientFirstName;
	}

	public void setClientFirstName(String clientFirstName) {
		this.clientFirstName = clientFirstName;
	}

	public String getClientLastName() {
		return clientLastName;
	}

	public void setClientLastName(String clientLastName) {
		this.clientLastName = clientLastName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientFirstName, clientID, clientLastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(clientFirstName, other.clientFirstName) && clientID == other.clientID
				&& Objects.equals(clientLastName, other.clientLastName);
	}

	@Override
	public String toString() {
		return "Client [clientID=" + clientID + ", clientFirstName=" + clientFirstName + ", clientLastName="
				+ clientLastName + "]";
	}
	
}

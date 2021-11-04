package com.revature.model;

public class BankAccount {
	private int clientID;
	private String clientFirstName;
	private String clientLastName;
	private String clientAccountType;
	
	public BankAccount() {
		
	}
	
	public BankAccount(int clientID, String clientFirstName, String clientLastName, String clientAccountType) {
		super();
		this.clientID = clientID;
		this.clientFirstName = clientFirstName;
		this.clientLastName = clientLastName;
		this.clientAccountType = clientAccountType;
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

	public String getClientAccountType() {
		return clientAccountType;
	}

	public void setClientAccountType(String clientAccountType) {
		this.clientAccountType = clientAccountType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientAccountType == null) ? 0 : clientAccountType.hashCode());
		result = prime * result + ((clientFirstName == null) ? 0 : clientFirstName.hashCode());
		result = prime * result + clientID;
		result = prime * result + ((clientLastName == null) ? 0 : clientLastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (clientAccountType == null) {
			if (other.clientAccountType != null)
				return false;
		} else if (!clientAccountType.equals(other.clientAccountType))
			return false;
		if (clientFirstName == null) {
			if (other.clientFirstName != null)
				return false;
		} else if (!clientFirstName.equals(other.clientFirstName))
			return false;
		if (clientID != other.clientID)
			return false;
		if (clientLastName == null) {
			if (other.clientLastName != null)
				return false;
		} else if (!clientLastName.equals(other.clientLastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BankAccount [clientID=" + clientID + ", clientFirstName=" + clientFirstName + ", clientLastName="
				+ clientLastName + ", clientAccountType=" + clientAccountType + "]";
	}
	
}

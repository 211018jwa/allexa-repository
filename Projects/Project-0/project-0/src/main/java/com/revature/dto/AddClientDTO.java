package com.revature.dto;

import java.util.Objects;

public class AddClientDTO {
	private String clientFirstName;
	private String clientLastName;
	
	public AddClientDTO() {
		
	}
	
	public AddClientDTO(String clientFirstName, String clientLastName) {
		super();
		this.clientFirstName = clientFirstName;
		this.clientLastName = clientLastName;
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
		return Objects.hash(clientFirstName, clientLastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddClientDTO other = (AddClientDTO) obj;
		return Objects.equals(clientFirstName, other.clientFirstName)
				&& Objects.equals(clientLastName, other.clientLastName);
	}

	@Override
	public String toString() {
		return "AddClientDTO [clientFirstName=" + clientFirstName + ", clientLastName=" + clientLastName + "]";
	}
	
}

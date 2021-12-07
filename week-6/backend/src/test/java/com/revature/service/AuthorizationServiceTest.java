package com.revature.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthorizationServiceTest {
	
	private AuthorizationService authService;
	
	@BeforeEach
	public void setup() {
		this.authService = new AuthorizationService();
	}
	
	@Test
	public void authorizeTrainer_negativeTest_userIsAssociate() {
		
	}
	
	@Test
	public void authorizeTrainer_negativeTest_userIsNull() {
		
	}
	
	@Test
	public void authorizeTrainer_positiveTest_userIsATrainer() {
		
	}
	
	@Test
	public void authorizeAssociate_negativeTest_userIsTrainerButRequiresAssociateRole() {
		
	}
	
	@Test
	public void authorizeAssociate_positivaTest_userIsAnAssociate() {
		
	}
	
	@Test
	public void authorizeAssociate_negativeTest_userIsNotAssociateOrTrainer() {
		
	}
	
	@Test
	public void authorizeAssociateAndTrainer_negativeTest_userIsNull() {
		
	}
	
	@Test
	public void authorizeAssociateAndTrainer_positiveTest_userIsAssociate() {
		
	}
	
	@Test
	public void authorizeAssociateAndTrainer_positiveTest_userIsTrainer() {
		
	}
}

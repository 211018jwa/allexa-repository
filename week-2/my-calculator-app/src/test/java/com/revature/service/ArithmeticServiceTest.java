package com.revature.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArithmeticServiceTest {
	public ArithmeticService arithmeticService;
	
	@BeforeEach
	public void setUp() {
		this.arithmeticService = new ArithmeticService();
	}
	
	@Test
	public void testCheckInputsMethodWithNoBlankInputs() {
		int result = this.arithmeticService.checkInputs("10.5", "100.34");
		
		Assertions.assertEquals(0, result);
	}
	
	@Test
	public void testCheckInputsMethodWithLeftBlankInputAndNonBlankRightInput() {
		int result = this.arithmeticService.checkInputs("      ", "10.53");
		
		Assertions.assertEquals(1, result);
	}
	
	@Test
	public void testCheckInputsMethodWithNonBlankLeftInputAndBlackRightInput() {
		int result = this.arithmeticService.checkInputs("10.3", "      ");
		
		Assertions.assertEquals(2, result);
	}
	
	@Test
	public void testCheckInputsMethodWithBothInputsBlank() {
		int result = this.arithmeticService.checkInputs("     ", "      ");
		
		Assertions.assertEquals(3, result);
	}
}

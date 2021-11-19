package com.revature.service;

import com.revature.exceptions.MissingNumberInputException;

// The service layer is responsible for the processing of data. We would perform business logic inside of the service layer.
// Ex. imagine you are developing the backend for facebook. The service layer of Facebook's backend would contain business logic related to providing friend
// recommendations, ad recommendations, etc. for a particular Facebook user.
// All sorts of complex algorithms could be developed, and those would ultimately be part of this "service" layer.
// Sometimes, the service layer will be pretty simple (especially for CRUD applications)
// CRUD = Create, Read, Update, Delete
// CRUD applications are applications that are primarily designed to keep records of data
public class ArithmeticService {

	public void checkInputs(String leftInput, String rightInput) {
		
		// Both are missing
		if (leftInput.trim().equals("") && rightInput.trim().equals("")) {
			throw new MissingNumberInputException("Both inputs are missing");
		}
		
		// Left is missing
		if (leftInput.trim().equals("")) {
			throw new MissingNumberInputException("Left input is missing");
		}
		
		// Right is missing
		if (rightInput.trim().equals("")) {
			throw new MissingNumberInputException("Right input is missing");
		}
		
		// We're ok
	}
	
	public String doAddition(String number1String, String number2String) {
		checkInputs(number1String, number2String);
		
		double number1 = Double.parseDouble(number1String);
		double number2 = Double.parseDouble(number2String);
		
		double sum = number1 + number2;
		
		String result = "" + sum; // Convert from double representation of a number to a String representation
		
		return result;
	}

	public String doSubtraction(String number1String, String number2String) {
		checkInputs(number1String, number2String);
		
		double number1 = Double.parseDouble(number1String);
		double number2 = Double.parseDouble(number2String);
		
		double difference = number1 - number2;
		
		String result = "" + difference; // Convert from double representation of a number to a String representation
		
		return result;
	}

	public String doMultiplication(String number1String, String number2String) {
		checkInputs(number1String, number2String);
		
		double number1 = Double.parseDouble(number1String);
		double number2 = Double.parseDouble(number2String);
		
		double product = number1 * number2;
		
		String result = "" + product; // Convert from double representation of a number to a String representation
		
		return result;
	}

	public String doDivision(String number1String, String number2String) {
		checkInputs(number1String, number2String);
		
		double number1 = Double.parseDouble(number1String);
		double number2 = Double.parseDouble(number2String);
		
		double quotient = number1 / number2;
		
		String result = "" + quotient; // Convert from double representation of a number to a String representation
		
		return result;
	}
	
}

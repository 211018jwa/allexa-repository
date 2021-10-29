package com.revature.service;

public class ArithmeticService {
	
	public int checkInputs(String input1, String input2) {
		if(input1.trim().equals("") && input2.trim().equals("")) {
			return 3;
		}
		if(input1.trim().equals("")) {
			return 1;
		}
		if(input2.trim().equals("")) {
			return 2;
		}
		return 0;
	}
	
	public String doOperation(String input1, String input2, char operator) {
		int condition = checkInputs(input1, input2);
		
		switch(condition) {
			case 1:
				return "Left input is missing";
			case 2: 
				return "Right input is missing";
			case 3: 
				return "Both inputs are missing";
		}
		
		switch(operator) {
		case '+':
			return doAddition(input1, input2);
		case '-':
			return doAddition(input1, input2);
		case '*':
			return doAddition(input1, input2);
		case '/':
			return doAddition(input1, input2);
			
		}
		
		return "Something went wrong because it didn't use any of the opperations";
	}
	
	public String doAddition(String number1Str, String number2Str) {
		double number1 = Double.parseDouble(number1Str);
		double number2 = Double.parseDouble(number2Str);
		
		double sum = number1 + number2;
		
		String addResult = "" + sum;
		
		return addResult;
	}
	
	public String doSubtraction(String number1Str, String number2Str) {
		double number1 = Double.parseDouble(number1Str);
		double number2 = Double.parseDouble(number2Str);
		
		double difference = number1 - number2;
		
		String subResult = "" + difference;
		
		return subResult;
	}
	
	public String doMultiplication(String number1Str, String number2Str) {
		double number1 = Double.parseDouble(number1Str);
		double number2 = Double.parseDouble(number2Str);
		
		double product = number1 * number2;
		
		String mulResult = "" + product;
		
		return mulResult;
	}
	
	public String doDivision(String number1Str, String number2Str) {
		double number1 = Double.parseDouble(number1Str);
		double number2 = Double.parseDouble(number2Str);
		
		double quotient = number1 / number2;
		
		String divResult = "" + quotient;
		
		return divResult;
	}
}

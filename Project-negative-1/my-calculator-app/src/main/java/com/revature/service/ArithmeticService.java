package com.revature.service;

public class ArithmeticService {
	
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

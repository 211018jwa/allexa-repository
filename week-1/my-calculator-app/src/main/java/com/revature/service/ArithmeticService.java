package com.revature.service;

public class ArithmeticService {
	
	/*
	public String doCompare(String number1Str, String number2Str) {
		double number1 = Double.parseDouble(number1Str);
		double number2 = Double.parseDouble(number2Str);
		
		double sum = number1 + number2;
		double difference = number1 - number2;
		double product = number1 * number2;
		double quotient = number1 / number2;
		
		String result1 = "Sum: " + sum;
		String result2 = "Difference: " + difference;
		String result3 = "Product: " + product;
		String result4 = "Quotient: " + quotient;
		
		String result = result1 + "\n" + result2 + "\n" + result3 + "\n" + result4;
		
		return result;
	} 
	*/
	
	public String doAddition(String number1Str, String number2Str) {
		double number1 = Double.parseDouble(number1Str);
		double number2 = Double.parseDouble(number2Str);
		
		double sum = number1 + number2;
		
		String addResult = "Sum: " + sum;
		
		return addResult;
	}
	
	public String doSubtraction(String number1Str, String number2Str) {
		double number1 = Double.parseDouble(number1Str);
		double number2 = Double.parseDouble(number2Str);
		
		double difference = number1 - number2;
		
		String subResult = "Difference: " + difference;
		
		return subResult;
	}
	
	public String doMultiplication(String number1Str, String number2Str) {
		double number1 = Double.parseDouble(number1Str);
		double number2 = Double.parseDouble(number2Str);
		
		double product = number1 * number2;
		
		String mulResult = "Product: " + product;
		
		return mulResult;
	}
	
	public String doDivision(String number1Str, String number2Str) {
		double number1 = Double.parseDouble(number1Str);
		double number2 = Double.parseDouble(number2Str);
		
		double quotient = number1 / number2;
		
		String divResult = "Quotient: " + quotient;
		
		return divResult;
	}
}

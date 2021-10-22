package com.revature.service;

public class ArithmeticService {
	public String doAddition(String num1Str, String num2Str) {
		double num1 = Double.parseDouble(num1Str);
		double num2 = Double.parseDouble(num2Str);
		
		double sum = num1 + num2;
		
		String result = "" + sum;
		
		return result;
	}
}

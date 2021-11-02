package com.revature.app;

public class UncheckedDemo {
	
	public static void demo() {
		int userInput1 = 10;
		int userInput2 = 0;
		
		try {
			System.out.println(userInput1/userInput2);
		}
		catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
	}
	
}

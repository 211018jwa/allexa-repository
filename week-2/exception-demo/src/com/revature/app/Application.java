package com.revature.app;

public class Application {
	public static void main(String[] args) {
		System.out.println("This line RUNS");
		
		try {
			System.out.println(10/0);
		}
		catch(ArithmeticException e) {
			System.out.println("Cannot divide by 0");
		}
		
		System.out.println("This line CAN NOW RUN");
	}
}

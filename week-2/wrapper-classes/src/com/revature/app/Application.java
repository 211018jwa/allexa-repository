package com.revature.app;

public class Application {
	public static void main(String[] args) {
		/*
		 * Wrapper classes: classes that serve as blueprints for objects
		 * that wrap up primitive values
		 * 
		 * Unboxing: the automatic "extraction" of  the primitive 
		 * value from the wrapper object
		 * Autoboxing: the automatic creation of a wrapper object
		 * from a primitive
		 * 
		 */
		
		Integer i = new Integer(10);
		
		System.out.println(i + 5);
		
		int someInt = i;
		System.out.println(someInt);
		
		printInt(i);
		
		//Autoboxing
		
		Integer i2 = 10;
		Integer i3 = 15;
		//Unboxing and Autoboxing
		Integer i4 = i2 + i3;
		
	}
	
	public static void printInt(int a ) {
		System.out.println(a);
	}
}

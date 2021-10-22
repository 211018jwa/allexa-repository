package com.revature.app;

public class Application {
	
	/*
	 * Casting is a conversion from one type to another
	 * 
	 * 2 Variable types
	 * 1. primitive
	 * 2. reference
	 * 
	 * 2 types of casting
	 * 1. widening/narrowing conversion (primitive)
	 * 2. upcasting/downcasting conversions (reference)
	 * 
	 * Widening/narrowing conversion
	 * 
	 * This type of casting is either implicit or explicit
	 * 
	 * implicit: occurs when you want to fit a narrower type into a larger type
	 * explicit: we need to explicitly specify that we want to convert from a wider
	 *  	type to a narrower type
	 *  
	 * 
	 */
	
	public static void main(String[] args) {
		//Implicit
		long myLong;
		int myInt = 1000;
		
		myLong = myInt;
		
		//Explicit
		int myInt2;
		myInt2 = (int)myLong;
		System.out.println("myInt2: " + myInt2);
		
		myInt2 = (int)3_000_000_000L;
		System.out.println("myInt2: " + myInt2);
		
		/*
		 * Reference type casting
		 * 
		 * 1. upcasting: from a more specific type to a less specific type
		 * 2. downcasting: from a less specific type to a more specific type(unsafe operation)
		 * 
		 * This has to do particularly with inheritance
		 * 
		 * 
		 * 
		 */
		
	}
}

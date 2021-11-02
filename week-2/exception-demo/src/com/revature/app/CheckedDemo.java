package com.revature.app;

import com.revature.exceptions.DivideByZeroException;

public class CheckedDemo {
	public static void demo() {
		try {
			System.out.println(divide(10,0));
			
			System.out.println("Exception did not occur since we were able to get to this line");
		}
		catch(DivideByZeroException e) { //multiple catches can be used
			System.out.println(e.getMessage());
		}
		finally {
			//will always run unless your computer crashes or the app is purposefully terminated
			System.out.println("Finally block will always be executed.");
		}
	}
	
	public static double divide(double d1, double d2) throws DivideByZeroException {
		if(d2 == 0) {
			throw new DivideByZeroException("Tried to divide " + d1 + " by " + d2);
		}
		
		return d1;
	}
}

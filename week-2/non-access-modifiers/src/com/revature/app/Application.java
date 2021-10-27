package com.revature.app;

public class Application {
	
	/*
	 * non-access modifiers
	 * 1. static:
	 * 2. final
	 * 3. abstract
	 * 4. synchronized: (multi-threading)
	 */
	
	public static void main(String[] args) {
		System.out.println(MyClass.property1);
		System.out.println(MyClass.property2);
		MyClass.method1();
		MyClass.method2();
		
		final int a;
		a = 10;
		//a = 20; // ca't because final means can't be changed
	}
	
}

package com.revature.app;

public class Driver {
	
	public static void main(String[] args) {
		String s1 = "Hello World!";
		char[] myChar = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd','!'};
		String s2 = new String(myChar);
		
		System.out.println("s1: " + s1);
		System.out.println("s2: " + s2);
		
		System.out.println("s1 == s2: " + (s1 == s2)); 
		//false b/c s1 and s2 don't point to the same object
		System.out.println("s1.equals(s2): " + s1.equals(s2));
		//true b/c they have the same underlining value
		
		String s3 = "Hello";
		String s4 = " World!";
		s3 = s3.concat(s4);
		System.out.println("Hello" + " World!" == s3);
		System.out.println("Hello" + " World!" == "Hello World!");
		
		System.out.println(s3);
		s3 = s3.replace("l", "x");
		System.out.println(s3);
		
		String s5 = "Hello, World!, My, name, is, Allexa!";
		String[] myStrings = s5.split(", ");
		
		for (int i = 0; i < myStrings.length; i++) {
			System.out.println(myStrings[i]);
		}
	}
	
}

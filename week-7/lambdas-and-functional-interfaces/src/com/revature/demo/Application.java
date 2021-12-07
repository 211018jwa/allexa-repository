package com.revature.demo;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

public class Application {

	public static void main(String[] args) {
		SomeClass sc = new SomeClass();
		
		boolean b1 = sc.test("Hello World");
		System.out.println(b1);
		
		Predicate<String> myLambda = (s) -> {
			if(s.length() > 10) {
				return false;
			}
			return true;
		};
		
		boolean b2 = myLambda.test("Hello World");
		System.out.println(b2);
		
		BiPredicate<String, Integer> checkIfStringIsCertainLength = (s, i) -> {
			if(s.length() == i) {
				return true;
			}
			return false;
		};
		
		boolean b4 = checkIfStringIsCertainLength.test("abc", 3);
		System.out.println(b4);
		
		Consumer<String> printStringWithPunctuation = (s) -> {
			System.out.println(s + "!!!!!!!!!");
		};
		
		printStringWithPunctuation.accept("Hello");
		
		Function<String, String> transformString = (s) -> {
			return s + "!!!";
		};
		
		String s1 = transformString.test("hey", " hello");
		System.out.println(s1);
		
		Function<String, Integer> countNumberOfsCharacters = (s) -> {
			int numOfsChars;
			for(int i = 0; i < s.length(); i++) {
				
			}
		};
		
	}
}

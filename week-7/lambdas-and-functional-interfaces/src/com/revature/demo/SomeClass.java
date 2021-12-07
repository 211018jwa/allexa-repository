package com.revature.demo;

public class SomeClass implements Predicate<String> {

	@Override
	public boolean test(String t) {
		
		if(t.length() > 10) {
			return false;
		}
		
		return true;
	}
}

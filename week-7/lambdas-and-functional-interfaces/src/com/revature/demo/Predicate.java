package com.revature.demo;

@FunctionalInterface
public interface Predicate<T> {

	public boolean test(T t);
	
	//public void someOtherMethod();
	//can't have more than one method in a functional interface
}

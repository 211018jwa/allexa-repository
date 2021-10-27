package com.revature.dao;

import java.util.ArrayList;

import com.revature.model.Person;

public interface PersonDAO {
	int someVar = 10;
	
	void add(Person p);
	
	default ArrayList<Person> getall() {
		System.out.println("default implimentation of getAll");
		return null;
	}
	
	default void defaultImplementationExample() {
		System.out.println("This is an example of an instance method with an actual body inside of an interface");
	}
	
	public static void someStaticMethod() {
		System.out.println("This is a static method contained inside the interface");
	}
}

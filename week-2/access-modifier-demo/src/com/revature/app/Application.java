package com.revature.app;

import com.revature.model.Person;

public class Application {

	public static void main(String[] args) {
		System.out.println(Person.numOfInstances);
		
		Person p1 = new Person("Billy", "Bob", 25 ,"512-000-0000");
		System.out.println(p1.firstName);
		
		//Application a1 = new Application();
		//System.out.println(a1.lastName);
		
		System.out.println(p1.getPhonenumber());
	}
}

package com.revature.app;

import com.revature.model.Person;
import com.revature.service.PersonService;

public class Application {
	
	public static void main(String[] args) {
		
		String firstName = "Batch";
		String lastName = "Tran";
		int age = 24;
		String phoneNum = "512-826-2486";
		
		Person p1 = new Person();
		
		p1.setFirstName(firstName);
		p1.setLastName(lastName);
		p1.setAge(age);
		p1.setPhoneNum(phoneNum);
		
		System.out.println(p1.getFirstName());
		System.out.println(p1.getLastName());
		System.out.println(p1.getAge());
		System.out.println(p1.getPhoneNum());
		
		PersonService personService = new PersonService();
		personService.addPerson(p1);
		
		//System.out.println(people);
		
	}
	
}

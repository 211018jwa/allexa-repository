package com.revature.service;

import com.revature.model.Person;

import java.util.ArrayList;

import com.revature.dal.PersonDAO;

public class PersonService {
	
	private PersonDAO personDao;
	
	public PersonService() {
		this.personDao = new PersonDAO();
	}
	
	public void addPerson(Person person) {
		if(person.getAge() < 0) {
			System.out.println("Error: we cannot add this person object to the database "
					+ "because the age is negative.");
			return;
		}
		
		if(person.getPhoneNum().matches("\\d{3}-\\d{3}-\\d{4}")) {
			System.out.println("Error: we cannot add this person to the database because the "
					+ "phonenumber does not match xxx-xxx-xxxx");
			return;
		}
		
		this.personDao.add(person);
		
	}
	
	public ArrayList<Person> getAll() {
		return this.personDao.getAll();
	}
}

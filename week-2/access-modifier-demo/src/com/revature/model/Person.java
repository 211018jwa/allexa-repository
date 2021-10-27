package com.revature.model;

public class Person {
	
	//VAriable Scopes
	/*
	 * 1. Class Scope
	 * 2. Instance Scope
	 * 3. Block Scope
	 * 4. Method Scope
	 */
	
	public String firstName; // Instance scope
	protected String lastName;// Instance scope
	double age; // Instance scope
	private String phoneNumber;
	
	//static fields
	public static int numOfInstances;
	
	public Person(String firstName, String lastName, double age, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.phoneNumber = phoneNumber;
		
		numOfInstances++;
	}
	
	public String getPhonenumber() {
		return this.phoneNumber;
	}
	
}

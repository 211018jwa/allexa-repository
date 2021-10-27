package com.revature.model;

import java.util.Objects;

public class Person {
	private String  firstName;
	private String lastName;
	private int age;
	private String phoneNum;
	
	public Person() {
		super();
	}
	
	public Person(String firstName, String lastName, int age, String phoneNum) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.phoneNum = phoneNum;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getPhoneNum() {
		return this.phoneNum;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	//Override methods

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", phoneNum=" + phoneNum
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, firstName, lastName, phoneNum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(phoneNum, other.phoneNum);
	}
	
}

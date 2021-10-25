package com.revature.model;

public class Dog extends Animal {
	
	public Dog(String name) {
		super (name);
	}
	
	public void makeNoise() {
		System.out.println("Bark!");
	}
}

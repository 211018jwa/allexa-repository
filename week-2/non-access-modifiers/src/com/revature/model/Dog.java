package com.revature.model;

public class Dog extends Animal {
	public Dog() {
		super();
	}
	
	public Dog(String name) {
		super(name);
	}
	
	//can't override makeNoise() cause it's final
}

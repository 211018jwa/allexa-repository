package com.revature.model;

public class Animal {
	private String name;
	
	public Animal() {
		super();
	}
	
	public Animal(String name) {
		this.name = name;
	}
	
	public void makeNoise() {
		System.out.println("Noise");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

package com.revature.model;

public class Animal {

	public String name;
	public double energylvl;
	
	public Animal(String name) {
		this.name = name;
		this.energylvl = 100;
	}
	
	public void makeNoise() {
		System.out.println("Generic Animal Noises");
	}
	
	public void eat(Food food) {
		this.energylvl += food.nourishmentValue;
		System.out.println(this.name + " ate " + food.foodName 
				+ "and gained " + food.nourishmentValue + " energy " 
				+ "for a total of " + this.energylvl + " energy.");
		
	}
}

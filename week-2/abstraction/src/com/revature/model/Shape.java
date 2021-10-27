package com.revature.model;

/*
 * Abstraction: the idea of representing abstract ideas as types in java
 * 1. abstract classes
 * 2. interface
 */

public abstract class Shape {
	/*
	 * can contain regular methods
	 * can contain abstract methods
	 * cannot be instantiated
	 * can have constructors
	 */
	
	protected String description;
	
	public Shape (String description) {
		this.description = description;
	}
	
	/* public double getArea() {
		//can't use concrete methods
		return 0.0;
	} */
	
	public abstract double getArea();
	
}

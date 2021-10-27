package com.revature.model;

public class Rectangle extends Shape {
	private double length;
	private double width;
	
	public Rectangle(String description, double length, double width) {
		super(description);
		
		this.length = length;
		this.width = width;
	}

	@Override
	public double getArea() {
		return this.length * this.width;
	}
	
}

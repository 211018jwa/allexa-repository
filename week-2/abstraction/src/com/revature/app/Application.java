package com.revature.app;

import com.revature.model.Circle;
import com.revature.model.Rectangle;
import com.revature.model.Shape;
import com.revature.model.Triangle;

public class Application {
	public static void main(String[] args) {
		Shape a;
		a = new Rectangle("This rectangle is modeling the top of a desk", 20, 50);
		System.out.println(a.getArea());
		
		a = new Circle("This circle is modeling the average coaster", 2.5);
		System.out.println(a.getArea());
		
		a = new Triangle("This is modeling my pizza slice", 8, 20);
		System.out.println(a.getArea());
		
		//This is abstraction and polymorphism
	}
}

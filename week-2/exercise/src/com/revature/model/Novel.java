package com.revature.model;

public class Novel extends Book {
	public Novel(String title, String author) {
		super(title, author);
		System.out.println("Novel");
	}
	
	public void Quirk( ) {
		System.out.println("Contains 80,000-120,000 words");
	}
}

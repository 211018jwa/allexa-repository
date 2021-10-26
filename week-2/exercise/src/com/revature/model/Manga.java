package com.revature.model;

public class Manga extends Book {
	public Manga(String title, String author) {
		super(title, author);
		System.out.println("Manga");
	}
	
	public void Quirk( ) {
		System.out.println("Japanese graphic novels read from "
				+ "right to left");
	}
}

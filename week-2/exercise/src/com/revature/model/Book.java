package com.revature.model;

public class Book {
	public String title;
	public String author;
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		System.out.println(title + " by " + author);
	}
	
	public void Quirk( ) {
		System.out.println("Read the pages.");
	}
	
	public void Compare() {
		
	}
	
	
}

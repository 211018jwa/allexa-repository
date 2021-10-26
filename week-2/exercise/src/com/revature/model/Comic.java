package com.revature.model;

public class Comic extends Book {
	public Comic(String title, String author) {
		super(title, author);
		System.out.println("Comic");
	}
	
	public void Quirk( ) {
		System.out.println("A colllection of comic strips, "
				+ "sequential art, that tells a story.");
	}
}

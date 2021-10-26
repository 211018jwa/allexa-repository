package com.revature.model;

public class LightNovel extends Novel {
	public LightNovel(String title, String author) {
		super(title, author);
		System.out.println("Lightnovel");
	}
	
	public void Quirk( ) {
		System.out.println("Shorter than novels and may "
				+ "contain illustrations.");
	}
}

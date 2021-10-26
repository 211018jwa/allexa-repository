package com.revature.app;

import com.revature.model.Book;
import com.revature.model.Novel;
import com.revature.model.LightNovel;
import com.revature.model.Manga;
import com.revature.model.Comic;

public class Application {
	
	public static void main(String[] args) {
		Book book1 = new Manga("Fullmetal Alchemist", "Hiromu Arakawa");
		book1.Quirk();
		
		Book book2 = new Comic("The Avengers", "Stan Lee");
		book2.Quirk();
		
		book1.Compare();
	}
	
}

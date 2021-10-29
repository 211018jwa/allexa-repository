package com.revature.demos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
	public static void demo() {
		List<String> listOfStrings0 = new ArrayList<String>();
		
		List<String> listOfStrings = new ArrayList<>();
		
		listOfStrings.add("Mango");
		listOfStrings.add("Peach");
		listOfStrings.add("Banana");
		listOfStrings.add("Banana");
		listOfStrings.add("Plum");
		listOfStrings.add("Mangosteen");
		listOfStrings.add("Longan");
		
		System.out.println("listOfStrings" + listOfStrings);
		
		System.out.println("Number of elements in listOfStrings: " + listOfStrings.size());
		
		listOfStrings.remove(new String("Peach"));
		
		System.out.println(listOfStrings);
		
		for(int i = 0; i < listOfStrings.size(); i++) {
			System.out.println("index: " + i + ": " + listOfStrings.get(i));
		}
		
		Iterator<String> iter = listOfStrings.iterator();
		
		while(iter.hasNext()) {
			String nextElement = iter.next();
			if(nextElement.equals("Banana")) {
				iter.remove();
			}
		}
		
		System.out.println("All Bananas are gone: " + listOfStrings);
		
		for(String s : listOfStrings) {
			System.out.println(s);
		}
		
		Iterator<String> myIter = listOfStrings.iterator();
		while(myIter.hasNext()) {
			System.out.println(myIter.next());
		}
		
		Collections.reverse(listOfStrings); // static method: belonging to the class itself
		
		System.out.println("reversed list: " + listOfStrings);
		
		Collections.sort(listOfStrings);
		
		System.out.println(listOfStrings);
		
		Collections.shuffle(listOfStrings);
		
		System.out.println("Shuffled list: " + listOfStrings);
		
	}
}

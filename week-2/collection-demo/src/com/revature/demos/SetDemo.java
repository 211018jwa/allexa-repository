package com.revature.demos;

//import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
	public static void demo() {
		//no order in HashSet
		//Set<String> mySet = new HashSet<>();
		
		//TreeSet is in order
		Set<String> mySet = new TreeSet<>();
		
		mySet.add("Peach");
		mySet.add("Avacado");
		mySet.add("Mangosteen");
		mySet.add("Banana");
		mySet.add("Banana");
		
		System.out.println("mySet: " + mySet);
		
		for(String c : mySet) {
			System.out.println(c);
		}
	}
}

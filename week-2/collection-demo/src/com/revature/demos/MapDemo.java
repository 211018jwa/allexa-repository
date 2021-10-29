package com.revature.demos;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo {

	public static void demo() {
		String myString = "afaehfahdbadhsbcasdcbahwdbaknchjsabdkjcnasjfcbhsdhcjndskcjb";
		
		Map<Character, Integer> characterFrequency = new HashMap<>();
		
		for(int i = 0; i <= myString.length() - 1; i++) {
			char c = myString.charAt(i);
			
			if(characterFrequency.get(c) == null) {
				characterFrequency.put(c, 1);
			}
			else {
				characterFrequency.put(c, characterFrequency.get(c) + 1);
			}
		}
		
		Set<Character> uniqueCharacters = characterFrequency.keySet();
		
		for(Character c : uniqueCharacters) {
			System.out.println(c);
		}
		
		Set<Entry<Character, Integer>> keyValuePairs = characterFrequency.entrySet();
				
		for(Entry<Character, Integer> keyValuePair : keyValuePairs) {
			System.out.println(keyValuePair.getKey() + " : value = " + keyValuePair.getValue());
		}
		
		System.out.println("number of o's: " + characterFrequency.get('o'));
		
	}

}

package com.revature.app;

public class Application {
	public static void main(String[] args) {
		long beginTime;
		long endTime;
		
		beginTime = System.nanoTime();
		System.out.println(reverseString("Hello World!"));
		endTime = System.nanoTime();
		
		System.out.println("reverseString() took " + (endTime - beginTime) + " ns.");
		
		beginTime = System.nanoTime();
		System.out.println(reverseStringBuilder("Hello World!"));
		endTime = System.nanoTime();
		
		System.out.println("reverseStringBuilder() took " + (endTime - beginTime) + " ns.");
		
		beginTime = System.nanoTime();
		System.out.println(reverseStringBuffer("Hello World!"));
		endTime = System.nanoTime();
		
		System.out.println("reverseStringBuffer() took " + (endTime - beginTime) + " ns.");
	}
	
	//String concatenation
	public static String reverseString(String s) {
		String result = "";
		
		for(int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			
			result = result + c;
		}
		
		return result;
	}
	
	//String Builder
	public static String reverseStringBuilder(String s) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			
			sb.append(c);
		} 
		
		String result = sb.toString();
		
		System.out.println(sb);
		
		return result;
	}
	
	//String Buffer
	public static String reverseStringBuffer(String s) {
		StringBuffer sb = new StringBuffer();
		
		for(int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			
			sb.append(c);
		} 
		
		String result = sb.toString();
		
		System.out.println(sb);
		
		return result;
	}
}

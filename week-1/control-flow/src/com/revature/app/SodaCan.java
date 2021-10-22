package com.revature.app;

public class SodaCan {
	
	/*
	 * Control flow is the core of any programming language or not, 
	 * typically the best way to go about evaluating if it is or not
	 * it has if statement, loops, anything to do with control flow
	 * 
	 * control flow controlling what gets executed under certain conditions
	 * 
	 * if 
	 * if-else 
	 * while
	 * do-while
	 * for
	 * switch
	 * 
	 */
	
	public static void main(String[] args) {
		
		int num = 100;
		if (num < 200) {
			System.out.println("The number variable is less than 200. It is " + num);
		}
		
		num = 300;
		if(num < 200) {
			System.out.println("The number variable is less than 200. It is " + num);
		}
		else {
			System.out.println("The number variable is larger than 200. It is " + num);
		}
		
		int age = 45;
		if(age < 18) {
			System.out.println("Minor");
		}
		else if(age < 40) {
			System.out.println("Young Adult");
		}
		else if(age < 40) {
			System.out.println("Middle Aged Adult");
		}
		else {
			System.out.println("Senior");
		}
		
		num = 10;
		if(num < 101) {
			System.out.println("The variable num is less than 101");
			if(num % 2 == 0) {
				System.out.println("The variable num is even");
			}
			else {
				System.out.println("The variable num is odd");
			}
		}
		else {
			System.out.println("The variable num is greater than or equal to 101");
		}
		
		
		int month = 1;
		switch (month) {
			case 1:
				System.out.println("It is January");
				break;
			case 2:
				System.out.println("It is Febuary");
				break;
			case 3:
				System.out.println("It is March");
				break;
			case 4:
				System.out.println("It is April");
				break;
			case 5:
				System.out.println("It is May");
				break;
			case 6:
				System.out.println("It is June");
				break;
			default:
				System.out.println("It is the secoond half of the year");
		}
		
	}
	
}

package com.revature.app;

public class Main {
	public static void main(String[] args) {
		/*
		 * array: collection of elements that are ordered and accessible by the index
		 * 
		 * Define a  refrence variable
		 * an array is an object
		 * 
		 */
		
		int[] myIntArray = new int[10];
		//arrays have default values
		//cannot change the size of the array once it's created
		//these blocks of memory are adjacent to each other in the heap
		
		//an array has indices ranging from 0 to (the size of the array -1)
		
		myIntArray[0] = 10;
		myIntArray[5] = 100;
		myIntArray[7] = 10000;
		myIntArray[4] = 153;
		
		
		System.out.println("Iterate over the loop");
		for(int i = 0; i < myIntArray.length; i++) {
			System.out.println(myIntArray[i]);
		}
		
		int[] myOtherIntArray = {14, 13, 5, 78};
		
		int[] intArr = myOtherIntArray;
		intArr[0] = 1000000;
		
		System.out.println(myOtherIntArray[0]);
		System.out.println(intArr == myOtherIntArray);
		
		for (int element : intArr) {
			System.out.println(element);
		}
		
		for(int i = intArr.length - 1; i >= 0; i--) {
			System.out.println(intArr[i]);
		}
		
		//String[] myStrings = {"January", "Febuary", "March"};
		
		int[][] my2DArray = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		
		for(int i = 0; i < my2DArray[i].length; i++) {
			for(int j = 0; j < my2DArray[i].length; j++) {
				System.out.println("i: " + i + ", j: " + j);
			}
		}
		
		for(int[] myArray : my2DArray) {
			for(int element : myArray) {
				System.out.println(element);
			}
		}
		
	}
}

package com.revanture.model;

public class GasStation {
	public String company;
	public double price;
	public boolean store;
	public int gasGrade;
	
	public GasStation(String company, double price, boolean store, int gasGrade){
		this.company = company;
		this.price = price;
		this.store = store;
		this.gasGrade = gasGrade;
	}
	
	public void priceRaise() {
		this.price = price + .25;
		System.out.println("The price was raised to $" + this.price);
	}
}

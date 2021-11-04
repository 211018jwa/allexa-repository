package com.revanture.app;

import com.revanture.model.GasStation;

public class Main {
	public static void main(String[] args) {
		GasStation gas1 = new GasStation("Chevron", 3.33, true, 95);
		
		System.out.println(gas1.company);
		System.out.println(gas1.price);
		System.out.println(gas1.store);
		System.out.println(gas1.gasGrade);
		
		gas1.priceRaise();
	}
}

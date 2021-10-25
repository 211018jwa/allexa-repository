package com.revature.app;

import com.revature.model.Animal;
import com.revature.model.Dog;
import com.revature.model.Cat;
import com.revature.model.Lion;
import com.revature.model.Food;

public class Application {
	
	public static void main(String[] args) {
		Food steak = new Food("Fillet Mignon", 50);
		
		Animal dog1 = new Dog("Fido");
		
		dog1.eat(steak);
		dog1.makeNoise();
		
		Food fish = new Food("Tilapia", 25);
		
		Animal cat1 = new Cat("Whiskers");
		
		cat1.eat(fish);
		cat1.makeNoise();
		
		Animal lion1 = new Lion("Simba");
		
		lion1.eat(fish);
		lion1.makeNoise();
		
		Animal animal1 = new Dog("Sparky");
		
		animal1.eat(steak);
		if(animal1 instanceof Dog) {
			((Dog)animal1).makeNoise();
			
		}
		
	}
	
}

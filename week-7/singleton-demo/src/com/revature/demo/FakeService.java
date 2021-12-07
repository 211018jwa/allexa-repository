package com.revature.demo;

public class FakeService {
	public void doSomething() {
		System.out.println("FakeService: ");
		Singleton s = Singleton.getInstance();
		System.out.println(s);
	}
}

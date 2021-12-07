package com.revature.demo;

public class Application {

	public static void main(String[] args) {
		
		NotASingleton obj1 = new NotASingleton("abc", "def");
		NotASingleton obj2 = new NotASingleton("ghi", "jkl");
		NotASingleton obj3 = new NotASingleton("mno", "pqr");
		
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);
		
		Singleton s1 = Singleton.getInstance();
		s1.setA("abc");
		s1.setB("def");
		s1.setC("ghi");
		s1.setD("jkl");
		
		System.out.println(s1);
		
		Singleton s2 = Singleton.getInstance();
		System.out.println(s2);
		
		Singleton s3 = Singleton.getInstance();
		System.out.println(s2 == s3);
		
		System.out.println(s1 == s3);
		
		FakeService fakeService = new FakeService();
		fakeService.doSomething();
		
	}
}

package com.revature.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DemoTest {
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("Runs before all of our tests");
	}
	
	@BeforeEach
	public void setUp(){
		System.out.println("Runs before each and every test");
	}
	
	@AfterEach
	public void cleanUp() {
		System.out.println("Runs after each and every test");
	}
	
	@AfterAll
	public void afterAll() {
		System.out.println("Runs after all of our tests");
	}
	
	//Tests
	
	@Test
	public void test1() {
		System.out.println("test1 is running");
	}
}

package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyBeforeAfterTest {

	// Order of tests isn't guaranteed, use the relevant annotations to order them
	@BeforeAll //This annotation is a class level annotation and requires the method to be static
	static void testBeforeAll(){
		System.out.println("Before all");
	}
	
	@BeforeEach // Will run before each test
	void test1() {
		System.out.println("BeforeEach");
	} 
	
	@Test
	void test2() {
		System.out.println("test2");
	}
	
	@Test
	void test3() {
		System.out.println("test3");
	}
	
	@AfterEach // Will run after each test
	void test4() {
		System.out.println("AfterEach");
	}
	
	@AfterAll
	static void testAfterAll(){
		System.out.println("After all");
	}
}

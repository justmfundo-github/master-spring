package com.in28minutes.junit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {
	
	List<String> todos = Arrays.asList("AWS", "Azure", "DevOps", "Spring Boot"); //"GCP"

	@Test
	void test() {
		boolean test = todos.contains("AWS");//Result
		boolean test2 = todos.contains("GCP");//Result
		//assertEquals(true, test);
		assertTrue("Something went wrong with boolean test", test);
		assertFalse("GCP should not exist in the array", test2);
		assertEquals(4, todos.size(), "Error Message regarding array size test");
		//assertNull, assertNotNull
		assertArrayEquals(new int[] {1,2,3}, new int[] {1,2,3,4}); // This test gives you a little bit more detailed messages regarding the differences in the arrays
	}

}

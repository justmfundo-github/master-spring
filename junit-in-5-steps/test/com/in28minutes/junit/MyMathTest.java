package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {

	// Absence of failure is success
	// Write several test/assert conditions
	
	private MyMath math = new MyMath();
	
	@Test
	void calculateSum_ThreeMemberArray() { // When entire test is completed inline
		assertEquals(6, math.calculateSum(new int[] {1,2,3}));
	}
	
	@Test
	void calculateSum_ZeroLengthArray() { // Messier version of test where variables are created and used
		
		int result = math.calculateSum(new int[] {});
		//System.out.println(result);
		
		int expectedResult = 0;
		assertEquals(expectedResult, result);
	}

}

package com.in28minutes.mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)// Required when using @Mock annotations
class SomeBusinessImplMockTest {
	
	@Mock
	private DataService dataServiceMock;
	
	@InjectMocks
	private SomeBusinessImpl someBusinessImpl;

	@Test
	void findTheGreatestFromAllData_basicScenario() {
		
		//DataService dataServiceMock = mock(DataService.class); // Now we're using annotations to in declare DataService as mock
		//dataServiceMock.retrieveAllData() => new int[] {25, 15, 5};
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25, 15, 5});
		
		//SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceMock); //Using @InjectMocks to connect the businessImpl and the mock
		int result = someBusinessImpl.findTheGreatestFromAllData();
		assertEquals(25, result);
	}
	
	@Test
	void findTheGreatestFromAllData_oneValue() {
		
		//DataService dataServiceMock = mock(DataService.class);
		//dataServiceMock.retrieveAllData() => new int[] {25, 15, 5};
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {35});
		
		//SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceMock);
		int result = someBusinessImpl.findTheGreatestFromAllData();
		assertEquals(35, result);
	}
	
	@Test
	void findTheGreatestFromAllData_emptyArray() {
		
		//DataService dataServiceMock = mock(DataService.class);
		//dataServiceMock.retrieveAllData() => new int[] {25, 15, 5};
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		
		//SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceMock);
		int result = someBusinessImpl.findTheGreatestFromAllData();
		assertEquals(Integer.MIN_VALUE, result);
	}
}
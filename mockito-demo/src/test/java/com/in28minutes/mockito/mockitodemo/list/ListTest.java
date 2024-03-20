package com.in28minutes.mockito.mockitodemo.list;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ListTest {

	@Test
	void simpleTest() {
		List listMock = mock(List.class);
		//listMock.size() => 3
		when(listMock.size()).thenReturn(3);
		assertEquals(3, listMock.size());
		assertEquals(3, listMock.size());
	}
	
	@Test
	void multipleReturns() {
		List listMock = mock(List.class);
		//listMock.size() => 3
		when(listMock.size()).thenReturn(1).thenReturn(2);
		assertEquals(1, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
	}
	
	@Test
	void specificParemeters() {
		List listMock = mock(List.class);
		//listMock.size() => 3
		when(listMock.get(0)).thenReturn("someString");
		assertEquals("someString", listMock.get(0));
		assertEquals(null, listMock.get(1));
	}
	
	@Test
	void genericParemeters() {
		List listMock = mock(List.class);
		//listMock.size() => 3
		when(listMock.get(Mockito.anyInt())).thenReturn("someOtherString");
		assertEquals("someOtherString", listMock.get(0));
		assertEquals("someOtherString", listMock.get(1));
	}
}

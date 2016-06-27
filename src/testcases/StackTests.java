package testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import basicDS.MyStackInterface;
import basicDS.MyStackWithArray;
import basicDS.MyStackWithLinkedList;

public class StackTests {

	@Test
	public void testStackWithList() {
		MyStackInterface<Integer> s = new MyStackWithLinkedList<Integer>();
		assertTrue(s.isEmpty());
		s.push(1);
		s.push(2);
		assertEquals(s.size(),2);
		assertEquals(s.peek().intValue(), 2);
		assertFalse(s.isEmpty());
		assertEquals(s.pop().intValue(),2);
		assertEquals(s.pop().intValue(),1);
		assertEquals(s.size(),0);
		assertTrue(s.isEmpty());
		
	}
	
	@Test
	public void testStackWithArray() {
		MyStackInterface<Integer> s = new MyStackWithArray<Integer>();
		assertTrue(s.isEmpty());
		s.push(1);
		s.push(2);
		assertEquals(s.size(),2);
		assertEquals(s.peek().intValue(), 2);
		assertFalse(s.isEmpty());
		assertEquals(s.pop().intValue(),2);
		assertEquals(s.pop().intValue(),1);
		assertEquals(s.size(),0);
		assertTrue(s.isEmpty());
		
	}
	
	@Test
	public void testStackWithArrayResize() {
		MyStackInterface<Integer> s = new MyStackWithArray<Integer>();
		for (int i=1;i<=15;i++) {
			s.push(i);
		}
		assertEquals(s.size(),15);
		assertEquals(s.peek().intValue(), 15);
		
	}


}

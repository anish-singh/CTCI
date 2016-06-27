package testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import basicDS.MyLinkedList;

public class MyLinkedListTests {

	@Test
	public void testSizeAndGet() {
		MyLinkedList<Integer> l = new MyLinkedList<Integer>();
		for (int i=1;i<=5;i++)
			l.add(i);
		
		assertFalse(l.isEmpty());
		assertEquals(l.size(),5);
		assertEquals(l.get(3).intValue(),3);
	}
	
	@Test
	public void testPop(){
		MyLinkedList<Integer> l = new MyLinkedList<Integer>();
		for (int i=1;i<=5;i++)
			l.add(i);
		
		assertEquals(l.pop().intValue(),5);
	}
	
	@Test
	public void testPopAtIndex(){
		MyLinkedList<Integer> l = new MyLinkedList<Integer>();
		for (int i=1;i<=5;i++)
			l.add(i);
		assertEquals(l.pop(3).intValue(),3);
	}
	
	@Test
	public void testAddAtIndex(){
		MyLinkedList<Integer> l = new MyLinkedList<Integer>();
		for (int i=1;i<=5;i++)
			l.add(i);
		
		l.add(18,3);
		assertEquals(l.get(3).intValue(),18);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testAddAtOutOfBoundsIndex(){
		MyLinkedList<Integer> l = new MyLinkedList<Integer>();
		for (int i=1;i<=5;i++)
			l.add(i);
		l.add(18,6);
		assertEquals(l.get(6).intValue(),18);
		l.add(18,9);
	}
	
	@Test
	public void removeAddAtIndex(){
		
		MyLinkedList<Integer> l = new MyLinkedList<Integer>();
		for (int i=1;i<=5;i++)
			l.add(i);
		
		l.remove(3);
		assertEquals(l.size(),4);
		assertEquals(l.get(3).intValue(),2);
	}
	
	@Test
	public void append(){
		
		MyLinkedList<Integer> l = new MyLinkedList<Integer>();
		for (int i=1;i<=5;i++)
			l.add(i);
		
		l.append(8);
		assertEquals(l.size(),6);
		assertEquals(l.get(6).intValue(),8);
	}
	
	@Test
	public void removeAddOutOfBoundsIndex(){
		
		MyLinkedList<Integer> l = new MyLinkedList<Integer>();
		for (int i=1;i<=5;i++)
			l.add(i);
		
		l.remove(6);
		assertEquals(l.size(),5);
		assertEquals(l.get(3).intValue(),3);
	}
	

}

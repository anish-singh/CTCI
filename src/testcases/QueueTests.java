package testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import basicDS.MyQueueInterface;
import basicDS.MyQueueWithList;

public class QueueTests {

	@Test
	public void testEnqueueDeQueue() {
		MyQueueInterface<Integer> q = new MyQueueWithList<Integer>();
		
		assertTrue(q.isEmpty());
		assertEquals(0, q.size());
		q.enqueue(1);
		assertEquals(1, q.size());
		assertFalse(q.isEmpty());
		q.enqueue(2);
		q.enqueue(3);
		assertEquals(q.dequeue().intValue(),1);
		assertEquals(q.dequeue().intValue(),2);
		assertEquals(1, q.size());
		assertFalse(q.isEmpty());	
	}

}

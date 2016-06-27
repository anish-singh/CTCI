package testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import basicDS.MyMapInterface;
import basicDS.MyMapWithChaining;
import basicDS.MyMapWithRehashing;

public class MapTests {

	@Test
	public void testMyArrayMap() {
		MyMapInterface<Integer, String> m = new MyMapWithRehashing<Integer, String>();
		m.put(1, "One");
		m.put(2, "Two");
		assertEquals(m.get(1), "One");
		assertEquals(m.size(), 2);
		m.put(19, "Nineteen");
		m.put(35, "ThirtyFive");
		assertEquals(m.get(19), "Nineteen");
		assertEquals(m.get(1), "One");
		assertEquals(m.get(35), "ThirtyFive");
		assertEquals(m.size(), 4);
		
		assertNull(m.get(40));
		m.del(19);
		assertNull(m.get(19));
		assertEquals(m.size(), 3);
	}
	
	@Test
	public void testMyChainingMap() {
		MyMapInterface<Integer, String> m = new MyMapWithChaining<Integer, String>();
		m.put(1, "One");
		m.put(2, "Two");
		assertEquals(m.get(1), "One");
		assertEquals(m.size(), 2);
		m.put(19, "Nineteen");
		m.put(35, "ThirtyFive");
		assertEquals(m.get(19), "Nineteen");
		assertEquals(m.get(1), "One");
		assertEquals(m.get(35), "ThirtyFive");
		assertEquals(m.size(), 4);
		
		assertNull(m.get(40));
		m.del(19);
		assertNull(m.get(19));
		assertEquals(m.size(), 3);
	}

}

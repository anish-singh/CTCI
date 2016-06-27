package basicDS;

import java.util.Arrays;
import java.util.List;

public class MyMapWithRehashing<K,V> implements MyMapInterface<K,V> {
	
	private int MAX_SIZE = 17;
	private K [] keys = null;
	private V [] values = null;
	private int size = 0;



	@SuppressWarnings({ "unchecked", "unchecked" })
	public MyMapWithRehashing() {
		keys = (K[])new Object[MAX_SIZE];
		values = (V[]) new Object[MAX_SIZE];
	}

	public int size() {
		return size;
	}

	public void put(K k, V v) {
		//TODO implement resize function.
		if (size == MAX_SIZE)
			throw new RuntimeException("Max Size Exceeded.");

		int hash = hash(k);
		if (keys[hash] == null || keys[hash].equals(k)){
			keys[hash] = k;
			values[hash] = v;
			
		}
		else {
			//collision. need to rehash or chain.
			boolean done = false;
			while (!done) {
				hash = rehash(hash);
				if (keys[hash] == null || keys[hash].equals(k)){
					keys[hash] = k;
					values[hash] = v;
					done = true;
				}
			}
		}
		size++;
	}

	public V get(K k) {
		int hash = hash(k);
		if (keys[hash] == null) return null;
		if (keys[hash].equals(k)) return values[hash];
		int numIterations = 1;
		while (numIterations < (MAX_SIZE * 2)) {
			hash = rehash(hash);
			if (keys[hash] == null) return null;
			if (keys[hash].equals(k)) return values[hash];
		}
		return null;

	}
	
	public List<K> keys() {
		return Arrays.asList(keys);
	}
	
	public List<V> values() {
		return Arrays.asList(values);
	}
	
	public void del(K k) {
		int hash = hash(k);
		if (keys[hash] == null) return;
		if (keys[hash].equals(k)) {
			keys[hash] = null;
			values[hash] = null;
			size--;
		}
		int numIterations = 1;
		while (numIterations < (MAX_SIZE * 2)) {
			hash = rehash(hash);
			if (keys[hash] == null) return;
			if (keys[hash].equals(k)) {
				keys[hash] = null;
				values[hash] = null;
				size--;
			}
		}
	}

	private int hash(K k) {

		return (Integer) k % MAX_SIZE;
	}

	private int rehash(int hash) {
		return hash + 3;
	}

	

}
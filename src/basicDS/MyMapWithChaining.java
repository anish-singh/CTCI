package basicDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyMapWithChaining<K,V> implements MyMapInterface<K,V> {
	
	private int MAX_SIZE = 17;
	private K [] keys = null;
	private ArrayList<V> [] values = null;
	private int size = 0;



	@SuppressWarnings({ "unchecked", "unchecked" })
	public MyMapWithChaining() {
		keys = (K[])new Object[MAX_SIZE];
		values = (ArrayList<V>[]) new Object[MAX_SIZE];
	}

	public int size() {
		return size;
	}

	public void put(K k, V v) {
		//TODO implement resize function.
		if (size == MAX_SIZE)
			throw new RuntimeException("Max Size Exceeded.");

		int hash = hash(k);
		if (keys[hash] == null) {
			keys[hash] = k;
			ArrayList<V> a = new ArrayList<V>();
			a.add(v);
			values[hash] = a;	
		}
		else {
			//see if the key already exists in values array list.
			ArrayList<V> a = values[hash];
			for (V i:a) {
				
			}
			// if not add new element
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
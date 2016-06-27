package basicDS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyMapWithChaining<K,V> implements MyMapInterface<K,V> {
	
	private int MAX_SIZE = 17;
	private ArrayList<KVPair<K,V>> [] keyValues = null;
	private int size = 0;
	
	class KVPair<K,V>{
		private K key;
		private V value;
		public KVPair(K k, V v){
			this.key = k;
			this.value = v;
		}
		public K getKey() {
			return key;
		}
		public V getValue() {
			return value;
		}
		
		public void setValue(V v) {
			 this.value = v;
		}
		
		
	}



	@SuppressWarnings("unchecked")
	public MyMapWithChaining() {
		keyValues = (ArrayList<KVPair<K,V>>[]) new ArrayList[MAX_SIZE];
	}

	public int size() {
		return size;
	}

	public void put(K k, V v) {
		//TODO implement resize function.
		if (size == MAX_SIZE)
			throw new RuntimeException("Max Size Exceeded.");

		int hash = hash(k);
		if (keyValues[hash] == null) {		
			ArrayList<KVPair<K,V>> a = new ArrayList<KVPair<K,V>>();
			a.add(new KVPair<K,V>(k, v));
			keyValues[hash] = a;
			size++;
		}
		else {
			//see if the key already exists in values array list.
			ArrayList<KVPair<K,V>> a = keyValues[hash] ;
			boolean keyExists = false;
			for (KVPair<K,V> p:a) {
				if (p.getKey().equals(k)){
					p.setValue(v);
					keyExists = true;
					break;
				}
			}
			if (!keyExists){
				a.add(new KVPair<K,V>(k,v));
				size++;
			}
		}
		
	}

	public V get(K k) {
		int hash = hash(k);
		if (keyValues[hash] == null) return null;
		ArrayList<KVPair<K,V>> a = keyValues[hash];
		for (KVPair<K,V> p:a) {
			if (p.getKey().equals(k)){
				return p.getValue();
			}
		}
		return null;

	}
	
	public List<K> keys() {
		return null;
	}
	
	public List<V> values() {
		return null;
	}
	
	public void del(K k) {
		int hash = hash(k);
		if (keyValues[hash] == null) return;
		ArrayList<KVPair<K,V>> a = keyValues[hash];
		
		Iterator<KVPair<K,V>> iter = a.iterator();
		while (iter.hasNext()) {
		    if (iter.next().getKey().equals(k)) {
		        iter.remove();
		        size--;
		    }
		}
	}

	private int hash(K k) {

		return (Integer) k % MAX_SIZE;
	}


	

}
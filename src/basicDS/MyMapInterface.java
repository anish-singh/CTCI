package basicDS;

import java.util.List;

public interface MyMapInterface<K, V> {
	public int size();
	public void put(K k, V v);
	public V get(K k);
	public void del(K k);
	public List<K> keys();
	public List<V> values();
}

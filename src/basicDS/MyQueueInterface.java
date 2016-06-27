package basicDS;

public interface MyQueueInterface<T> {
	
	public int size();
	public void enqueue(T item);
	public T dequeue();
	public boolean isEmpty();
}
package basicDS;

public class MyQueueWithList<T> implements MyQueueInterface<T> {
	
	private MyLinkedListInterface<T> l = null;

	public MyQueueWithList() {

		l = new MyLinkedList<T>();
	}

	public void enqueue(T item) {

		l.append(item);	
	}

	public T dequeue() {
		return l.pop();
	}

	public boolean isEmpty() {
		return l.isEmpty();
	}
	
	public int size() {
		return l.size();
	}

}
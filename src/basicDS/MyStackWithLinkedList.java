package basicDS;

public class MyStackWithLinkedList<T> implements MyStackInterface<T> {
	
	MyLinkedListInterface<T> l = null;

	public MyStackWithLinkedList() {

		l = new MyLinkedList<T>();
	}


	public int size() {
		return l.size();
	}

	public void push(T item) {
		l.add(item);
	}

	public T pop() {
		return l.pop();
	}

	public boolean isEmpty() {
		return l.isEmpty();
	}
	
	public T peek(){
		return l.get(1);
	}

}
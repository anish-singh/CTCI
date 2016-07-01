package basicDS;

public interface MyLinkedListInterface<T> {

	// add to head (front) of list
	public void add(T item);
	
	// add to tail of list.
	public void append(T item);
	public void add(T item, int index);
	
	
	public T get(int index);
	
	// pop from head (front) of List
	public T pop();
	public T pop(int index);
	public void remove(T item);
	public Node<T> getHead();
	
	public boolean isEmpty();
	public int size();
	
}

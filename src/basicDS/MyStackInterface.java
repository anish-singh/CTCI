package basicDS;

public interface MyStackInterface<T>  {
	
	public int size();
	public void push(T item);
	public T pop();
	public boolean isEmpty();
	public T peek();
}
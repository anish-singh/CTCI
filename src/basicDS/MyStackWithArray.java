package basicDS;

public class MyStackWithArray<T> implements MyStackInterface<T> {
	
	T [] items = null;
	int MAX_SIZE = 10;
	int top = -1;

	@SuppressWarnings("unchecked")
	public MyStackWithArray () {

		items = (T[]) new Object[MAX_SIZE];
	}


	public int size() {
		return this.top + 1;
	}

	public void push(T item) {
		if(top == (this.MAX_SIZE - 1))
			resize();
		items[++top]=item;
	}

	public T pop() {
		return items[top--];
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public T peek() {
		return items[top];
	}

	private void resize() {
		MAX_SIZE *=2;
		@SuppressWarnings("unchecked")
		T [] newArray = (T[]) new Object[MAX_SIZE];
		System.arraycopy(items, 0, newArray, 0, MAX_SIZE/2);
		items = newArray;
	}

}

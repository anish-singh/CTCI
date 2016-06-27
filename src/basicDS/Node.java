package basicDS;

public class Node<T> {

	private T data = null;
	private Node<T> next = null;

	public Node(){
		this.data = null;
		this.next = null;
	}

	public Node(T item){
		this.data = item;
		this.next = null;
	}

	public T getData(){
		return this.data;
	}

	public void setData(T item) {
		this.data = item;
	}

	public Node<T> getNext(){
		return this.next;
	}

	public void setNext(Node<T> n){
		this.next = n;
	}

}

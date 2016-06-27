package basicDS;

import java.util.Iterator;

public class MyLinkedList<T> implements MyLinkedListInterface<T>, Iterable<T> {
	
	private Node<T> head = null;
	private Node<T> tail = null;
	private int size = 0;

	public Iterator<T> iterator() {
		return new MyListIterator<T> (head);
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public T get(int index) {
		int i = 1;
		Node<T> n = head;
		while ( n != null && i != index) {
			n = n.getNext();
			i++;
		}
		return (n== null) ? null : n.getData();
	}

	public void add(T item) {
		Node<T> n = new Node<T>(item);
		n.setNext(head);
		this.head = n;
		if (head.getNext() == null)  tail = head;
		size++;
	}

	
	public void add(T item, int index) {
		
		Node<T> newNode = new Node<T>(item);

		if (index == 1) {
			// adding to head of list
			newNode.setNext(head);
			head = newNode;
		}
		else if (index > (size+1)) {
			// adding beyond the end of list
			throw new IndexOutOfBoundsException();			
		}
		else if (index == (size+1)) {
			// adding to end of list.
			tail.setNext(newNode);
			tail = newNode;
		}
		else {
			Node<T>  prev = null;
			Node<T> n = head;
			int i=1;
			while (i < index && n != null) {
				prev = n;
				n = n.getNext();
				i++;
			}	
			newNode.setNext(n);
			prev.setNext(newNode);
		}
		size++;
	}



	public void remove(T item) {

		Node<T> n = head;
		Node<T> p = null;

		if(head == null)  return;

		boolean found = false;
		while (n != null) {
			found = n.getData().equals(item);
			if (!found) {
				p = n;
				n = n.getNext();
			}
			else
				break;
		}
		if (found) {
			if (n == tail) tail = p;
			p.setNext(n.getNext());
			size --;
		}
	}
	
	public T pop() {
		if (head == null)
			return null;
	
		T item = head.getData();
		head = head.getNext();
		size--;
		return item;
		
	}
	
	public T pop(int index) {
		if (head == null)
			return null;
		if(index == 1){
			T item = head.getData();
			head = head.getNext();
			size--;
			return item;
		}
		Node<T> p = null;
		Node<T> n = head;
		int i = 1;
		while (i < index && n != null) {
			p = n;
			n = n.getNext();
			i++;
		}
		if (n == null)
			throw new IndexOutOfBoundsException("Out of Bounds");
		T item = n.getData();
		p.setNext(n.getNext());
		
		if (n.getNext() == null) 
			tail = p;
		
		size--;
		return item;
		
	}
	
	public int size() {
		return size;
	}
	
	
	public void printList(){
		
		Node <T> n = head;
		while (n != null){
			System.out.println(n.getData());
			n = n.getNext();
		}
			
		
	}
	
	public void append(T item){
		if (head == null) add(item);
		else {
			Node<T> n = new Node<T>(item);
			tail.setNext(n);
			tail = n;
			size++;
		}
	}
	
	
	private class MyListIterator<T> implements Iterator<T>{

		Node<T> currNode = null;
		
		public MyListIterator(Node<T> n){
			this.currNode = n;
		}
		
		public boolean hasNext() {
			return currNode.getNext() != null;

		}

		public T next() {

			currNode = currNode.getNext();
			return currNode.getData();

		}

		public void remove() {

		}
	}


}

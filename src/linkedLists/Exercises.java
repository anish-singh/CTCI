package linkedLists;

import basicDS.MyLinkedList;
import basicDS.MyLinkedListInterface;
import basicDS.Node;

public class Exercises {


	
	public static Node removeDuplicates(Node h) {
		if (h==null) return null;
		Node currNode = h;
		while (currNode != null){
			Node runner = currNode.getNext();
			Node previous = currNode;
			while (runner !=null) {
				if(runner.getData().equals(currNode.getData())) {
					//delete runner node.
					previous.setNext(runner.getNext());
					runner = previous.getNext();
				}
				else {
					previous = runner;
					runner = runner.getNext();
				}
			}
			currNode = currNode.getNext();
		}
		return h;
	}
	
	public static void printList(Node h){
		Node n =h;
		while (n != null) {
			System.out.print(n.getData() + ",");
			n=n.getNext();
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		MyLinkedListInterface<Integer> l = new MyLinkedList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(0);
		l.add(4);
		l.add(5);
		l.add(6);
		Exercises.printList(l.getHead());		
	}
}

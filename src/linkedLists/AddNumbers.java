package linkedLists;

public class AddNumbers {

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public class LinkedList {
		Node head = null;
		Node tail = null;

		public void addToFront(int d) {
			if (head == null) {
				head = tail = new Node(d);
			} else {
				Node n = new Node(d);
				n.next = head;
				head = n;
			}
		}

		public void addToEnd(int d) {
			if (tail == null) {
				head = tail = new Node(d);
			} else {
				Node n = new Node(d);
				tail.next = n;
				tail = n;
			}
		}
	}

	public Node addReverse(Node n1, Node n2) {

		if (n1 == null && n2 == null)
			return null;
		if (n1 == null)
			return n2;
		if (n2 == null)
			return n1;
		
		int carry = 0;
		LinkedList result = new LinkedList();
		while(n1!=null && n2!=null) {
			int s = (n1.data + n2.data) %10;
			result.addToEnd(s+carry);
			carry = (n1.data + n2.data)/10;
			n1=n1.next;
			n2=n2.next;
		}
		//one of them has more digits.
		while(n1!=null) {
			result.addToEnd(n1.data+carry);
			carry = 0;
			n1 = n1.next;
		}
		while(n2!=null) {
			result.addToEnd(n2.data+carry);
			carry = 0;
			n2 = n2.next;
		}
		
		return result.head;
	}
	
	public class Result {
		Node n;
		int carry = 0;
		public Result(Node n, int c) {
			this.n = n;
			this.carry = c;
		}
	}
	
	public Result addF(Node n1, Node n2) {


		if (n1 == null && n2 == null)
			return null;
		if (n1 == null)
			return new Result(n2,0);
		if (n2 == null)
			return new Result(n1,0);
		
		Result r = addF(n1.next, n2.next);
		int sum = (n1.data + n2.data) %10;
		if(r!=null)
			sum += r.carry;
		
		int carry = (n1.data + n2.data) /10;
		if(r!=null && sum > 9) {
			carry = (sum + r.carry) /10;
			sum = (sum + r.carry) %10;
		}

		Node n = new Node(sum);
		n.next = (r==null) ? null : r.n;

		return new Result(n,carry);

	}
	
	public Node addForward(Node n1, Node n2) {
		
		Node n11 = n1;
		Node n22 = n2;
		
		//make the two list same length
		while(n11 !=null && n22!=null) {
			n11 = n11.next;
			n22 = n22.next;
		}
		if(n11 == null) {
			while(n22!=null) {
				//insert 0s to the front of n1
				Node n = new Node(0);
				n.next = n1;
				n1 = n;
				n22 = n22.next;	
			}
		}
		if(n22 == null) {
			while(n11!=null) {
				//insert 0s to the front of n2
				Node n = new Node(0);
				n.next = n2;
				n2 = n;
				n11 = n11.next;	
			}
		}
//		printList(n1);
//		printList(n2);
		
		Result r = addF(n1,n2);
//		printList(r.n);
		if(r !=null && r.carry != 0) {
			Node n = new Node(r.carry);
			n.next = r.n;
			r.n = n;
		}
		return r.n;
			
	}
	
	public void printList(Node n) {
		while(n!= null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		AddNumbers a = new AddNumbers();
		AddNumbers.LinkedList l1 = a.new LinkedList();
		l1.addToEnd(9);
		l1.addToEnd(9);
		l1.addToEnd(9);
		AddNumbers.LinkedList l2 = a.new LinkedList();
		l2.addToEnd(9);
		l2.addToEnd(9);
		l2.addToEnd(9);
		
		Node n = a.addReverse(l1.head, l2.head);
		a.printList(n);
		
		AddNumbers.LinkedList l3 = a.new LinkedList();
		l3.addToFront(1);
		l3.addToFront(9);
		l3.addToFront(9);
		AddNumbers.LinkedList l4 = a.new LinkedList();
		l4.addToFront(9);
		l4.addToFront(9);
		l4.addToFront(3);
		
		Node n2 = a.addForward(l3.head, l4.head);
		
		a.printList(n2);

		
		
		
	}

}

package linkedLists;

import basicDS.MyLinkedList;
import basicDS.MyLinkedListInterface;
import basicDS.Node;

public class RecursionInsteadOfStack {
	
	public static void reverse(Node n) {

		if (n == null)
			return;
		if (n.getNext() == null) {
			System.out.println(n.getData());
			return;
		}
		reverse(n.getNext());
		System.out.println(n.getData());
	}
	
	
	private class Result {
		Node node;
		int position;
		public Result(Node n, int pos)
		{
			this.node = n;
			this.position = pos;
		}
	}
	
	private Result findKthToLastRecursively(Node n, int k)
	{
		if (n == null)
			return new Result(null, 0);
		
		Result r = findKthToLastRecursively(n.getNext(), k);
		
		if (r.position == k)
			return r;
		
		return new Result(n, r.position +1);

	}
	
	public void findKthToLast(Node n, int k)
	{
		Result r = findKthToLastRecursively(n,k);
		System.out.println("Position of " + k + "th to last node = " + r.position + " value =" + r.node.getData());
	}
	
	
	class RP
	{
		Node node;
		boolean flag;
		RP(Node n, boolean f)
		{
			this.node = n;
			this.flag = f;
		}
	}

	RP isPalindromeRecursive(Node n, int length)
	{
		if (n==null)
			return new RP(null, true);

		if(length == 1)
			return new RP(n.getNext(), true);

		if(length == 2)
			return new RP(n.getNext().getNext(), n.getData() == n.getNext().getData());
		
		RP r = isPalindromeRecursive(n.getNext(), length -2);
		
		if(!r.flag)
			return r;
		
		return new RP(r.node.getNext(), n.getData() == r.node.getData());
	}

	
	public static void main(String[] args) {
		RecursionInsteadOfStack kl = new RecursionInsteadOfStack();
		MyLinkedListInterface<Integer> l = new MyLinkedList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);
		l.add(7);
		Exercises.printList(l.getHead());
		kl.findKthToLast(l.getHead(),7);
		
		l = null;
		l = new MyLinkedList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(3);
		l.add(2);
		l.add(1);

		Exercises.printList(l.getHead());
		RP r = kl.isPalindromeRecursive(l.getHead(),l.size());
		System.out.println("isPalindrome = " + r.flag);
	}
	

}

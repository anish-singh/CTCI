package trees;

import java.util.ArrayList;
import java.util.List;

public class FindPathsWithSum {
	//find all paths in a tree that add to a sum

	class Node {
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	ArrayList<String> output = new ArrayList<String>();

	public void findPaths(Node n, int sum, int currSum, StringBuffer currList) {
		
		if(n == null)  return;


		int newSum = n.data + currSum;
		StringBuffer newList = new StringBuffer(currList.toString() + n.data + " ");
		if(newSum == sum && !(currList.length()==0)) {
			output.add(new String(newList));
		}

		findPaths(n.left, sum, n.data + currSum, newList);
		findPaths(n.right, sum, n.data + currSum, newList);
		findPaths(n.left, sum, 0, new StringBuffer());
		findPaths(n.right, sum, 0, new StringBuffer());

	}

	public static void main(String args[])
	{
		FindPathsWithSum f = new FindPathsWithSum();
		
		Node n1 = f.new Node(1);
		Node n2 = f.new Node(2);
		Node n3 = f.new Node(3);
		Node n4 = f.new Node(4);
		Node n5 = f.new Node(5);
		Node n6 = f.new Node(6);
		Node n7 = f.new Node(7);
		Node n8 = f.new Node(8);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n5.right = n7;
		n3.right = n6;
		n6.right = n8;

		

		f.findPaths(n1, 14, 0, new StringBuffer());
		List<String> l = f.output;
		for(String s:l)
			System.out.println(s);


	}
}

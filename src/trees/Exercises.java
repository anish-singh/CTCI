package trees;

import java.util.ArrayList;

public class Exercises {

	// create BST from sorted array
	TreeNode createBST(int[] sa, int start, int end) {
		if (sa == null || start < 0 || start > end || start >= sa.length
				|| end < 0 || end >= sa.length)
			return null;

		int mid = (end + start) / 2;

		TreeNode n = new TreeNode(sa[mid], sa[mid]);

		n.left = createBST(sa, start, mid - 1);
		n.right = createBST(sa, mid + 1, end);

		return n;
	}

	// find all paths that add up to a Sum
	ArrayList<ArrayList<TreeNode>> allPaths = new ArrayList<ArrayList<TreeNode>>();

	public void getAllPaths(TreeNode n, int sum) {

		getPaths(n, sum, 0, new ArrayList<TreeNode>());
		printAllPaths(allPaths);
	}

	private void getPaths(TreeNode n, int total, int currSum,
			ArrayList<TreeNode> currPath) {

		if (n== null) return;
		currSum += n.key;
		currPath.add(n);
		
		if(currSum == total)
		{
			allPaths.add(currPath);
			//return;
		}
		//if(currSum > total) return;
		
		getPaths(n.left, total, currSum, new ArrayList<TreeNode>(currPath));
		getPaths(n.right, total, currSum, new ArrayList<TreeNode>(currPath));
		getPaths(n.left, total, 0, new ArrayList<TreeNode>());
		getPaths(n.right, total, 0, new ArrayList<TreeNode>());
	}
	
	private void printAllPaths(ArrayList<ArrayList<TreeNode>> paths) {
		for(ArrayList<TreeNode> path: paths){
			for(TreeNode n:path)
				System.out.print(n.key + ",");
			System.out.println();
		}
			
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(4,4);
		TreeNode t2 = new TreeNode(4,4);
		TreeNode t3 = new TreeNode(3,3);
		TreeNode t4 = new TreeNode(1,1);
		TreeNode t5 = new TreeNode(7,7);
		TreeNode t6 = new TreeNode(1,1);
		TreeNode t7 = new TreeNode(6,6);
		TreeNode t8 = new TreeNode(2,2);
		t1.left = t2; t1.right = t5;
		t2.left = t3;
		t3.right = t4;
		t5.left = t6; t5.right = t7;
		t7.left = t8;
		
		Exercises e = new Exercises();
		e.getAllPaths(t1, 8);
		
	}

}

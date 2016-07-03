package trees;

public class Traversals<V> {
	
	public void preOrder(TreeNode<V> n)
	{
		if (n == null) return;
		visit(n);
		preOrder(n.left);
		preOrder(n.right);
	}
	
	public void inOrder(TreeNode<V> n)
	{
		if (n == null) return;
		inOrder(n.left);
		visit(n);
		inOrder(n.right);
	}
	
	public void postOrder(TreeNode<V> n)
	{
		if (n == null) return;
		postOrder(n.left);
		postOrder(n.right);
		visit(n);
	}
	
	private void visit(TreeNode<V> n)
	{
		System.out.println("Visiting Node key=" + n.key + ", value=" + n.value);
	}
	
	public static void main(String[] args) {
		BST<Integer> t = new BST<Integer>();
		t.add(10, 10);
		t.add(7, 7);
		t.add(20, 20);
		t.add(30, 30);
		t.add(9, 9);
		t.add(25, 25);
		Traversals<Integer> tr = new Traversals<Integer>();
		tr.postOrder(t.getRoot());
	}

}

package trees;

public class BST<V> {

	private TreeNode<V> root = null;
	private int size = 0;
	
	public void add(int key, V value)
	{
		
		root = add(key, value, root);
		
	}
	
	public V get(int key)
	{
		return get(root, key);
	}
	
	private V get(TreeNode<V> n, int key) {
		if (n==null) return null;
		if (n.key == key)  return n.value;
		if (n.key < key)	return get(n.right, key);
		else
			return get(n.left, key);
	}
	
	private TreeNode<V> add(int k, V v, TreeNode<V> n)
	{
		if(n==null)  
		{
			size++;
			return new TreeNode<V>(k,v);
		}
		if(k < n.key)
			n.left = add(k,v,n.left);
		else if (k==n.key)
			n.value = v;
		else
			n.right = add(k,v,n.right);
		return n;
	}
	
	
	
	public TreeNode<V> getRoot()
	{
		return this.root;
	}
	
	
	
	public static void main(String[] args) {
		BST<Integer> t = new BST<Integer>();
		t.add(10, 10);
		t.add(7, 7);
		t.add(20, 20);
		t.add(30, 30);
		t.add(9, 9);
		t.add(25, 25);
		
		System.out.println(t.get(10));
		System.out.println(t.get(5));
		System.out.println(t.get(20));

	}

}

package trees;

public class TreeNode<V> {
	public TreeNode<V> left = null;
	public TreeNode<V> right = null;
	public TreeNode<V> parent = null;
	public int key;
	public V value;
	
	public TreeNode(int k, V v)
	{
		this.key = k;
		this.value = v;
	}
}

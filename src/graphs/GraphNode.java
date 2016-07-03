package graphs;

import java.util.Collection;
import java.util.HashMap;

public class GraphNode<K> {
	
	public enum STATUSES {NOT_VISITED, VISITING, VISITED};
	
	public int depth;
	public GraphNode<K> parent;
	public GraphNode.STATUSES status = STATUSES.NOT_VISITED;
	public int discover =0;
	public int completion = 0;

	
	
	K key;
	HashMap<GraphNode<K>, Integer> neighbors;
	
	public GraphNode(K key) {
		this.key = key;
	}
	
	public void addEdge(GraphNode<K> n, int weight) {
		if (neighbors == null)
			neighbors = new HashMap<GraphNode<K>, Integer>();
		if(neighbors.get(n) == null)
			neighbors.put(n, weight);
		else {
			neighbors.remove(n);
			neighbors.put(n, weight);
		}
	}
	
	public Collection<GraphNode<K>> getNeighbors(){
		if(neighbors == null)
			return null;
		else 
			return neighbors.keySet();
	}
	
	
	public void printData() {
		
		System.out.println("Node Key=" + key);
		System.out.println("Node Depth=" + this.depth);
		System.out.println("Node Parent Key=" + (this.parent == null ? null : this.parent.key));
		System.out.println("Node discover=" + this.discover);
		System.out.println("Node completion=" + this.completion);
		System.out.println("-----");
		
	}
	

}

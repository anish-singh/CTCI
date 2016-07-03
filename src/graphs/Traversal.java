package graphs;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

public class Traversal {

	public void bfs(GraphNode<Integer> node) {

		if (node == null)
			return;

		Queue<GraphNode<Integer>> q = new ArrayDeque<GraphNode<Integer>>();

		node.depth = 0;
		node.parent = null;
		q.add(node);

		while (!q.isEmpty()) {
			GraphNode<Integer> n = q.remove();
			if(n.status == GraphNode.STATUSES.NOT_VISITED) {
				n.status = GraphNode.STATUSES.VISITING;
				Collection<GraphNode<Integer>> neighbors = n.getNeighbors();
				if(neighbors != null) {
					for (GraphNode<Integer> e : neighbors) {
						e.parent = n;
						e.depth = n.depth + 1;
						q.add(e);
					}
				}
				n.status = GraphNode.STATUSES.VISITED;
				n.printData();
			}
		}
	}

	public void dfs(Graph<Integer> g) {

		Collection<GraphNode<Integer>> nodes = g.getVertices();

		for (GraphNode<Integer> node : nodes) {

			GraphNode.STATUSES s = ((GraphNode<Integer>) node).status;
			if (s == GraphNode.STATUSES.NOT_VISITED) {
				((GraphNode<Integer>) node).discover = 0;
				((GraphNode<Integer>) node).parent = null;
				((GraphNode<Integer>) node).depth = 0;
				dfs_recursive((GraphNode<Integer>) node, 0);
			}

		}

	}

	private void dfs_recursive(GraphNode<Integer> node, int time) {
		
		node.status = GraphNode.STATUSES.VISITING;
		Collection<GraphNode<Integer>> nodes = node.getNeighbors();
		if(nodes != null)
		{
			for(GraphNode<Integer> n: nodes){
				if(n.status == GraphNode.STATUSES.NOT_VISITED) {
					n.discover = ++time;
					n.parent = node;
					n.depth = node.depth +1;
					dfs_recursive(n,time);
				}
			}
		}
		node.completion = ++time;
		node.status = GraphNode.STATUSES.VISITED;
		node.printData();
	}
	
	
	public static void main(String[] args) {
		Graph<Integer> g = new Graph<Integer>();
		g.addVertex(1);
		g.addEdge(1, 2, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(2, 5, 1);
		g.addEdge(5, 6, 1);
		g.addEdge(3, 5, 1);
		g.addEdge(3, 4, 1);
		g.addEdge(4, 7, 1);
		
		Traversal t= new Traversal();
//		t.bfs(g.getVertex(1));
		t.dfs(g);
	}

}

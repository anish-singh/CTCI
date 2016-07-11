package graphs;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
			if (n.status == GraphNode.STATUSES.NOT_VISITED) {
				n.status = GraphNode.STATUSES.VISITING;
				Collection<GraphNode<Integer>> neighbors = n.getNeighbors();
				if (neighbors != null) {
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

	int time = 0;

	public void dfs(Graph<Integer> g) {

		Collection<GraphNode<Integer>> nodes = g.getVertices();

		for (GraphNode<Integer> node : nodes) {

			GraphNode.STATUSES s = node.status;
			if (s == GraphNode.STATUSES.NOT_VISITED) {
				node.discover = 0;
				node.parent = null;
				node.depth = 0;
				dfs_recursive(node);
			}

		}

	}

	private void dfs_recursive(GraphNode<Integer> node) {

		node.status = GraphNode.STATUSES.VISITING;
		Collection<GraphNode<Integer>> nodes = node.getNeighbors();
		if (nodes != null) {
			for (GraphNode<Integer> n : nodes) {
				if (n.status == GraphNode.STATUSES.NOT_VISITED) {
					n.discover = ++time;
					n.parent = node;
					n.depth = node.depth + 1;
					dfs_recursive(n);
				}
			}
		}
		node.completion = ++time;
		node.status = GraphNode.STATUSES.VISITED;
		node.printData();
	}

	public boolean hasCycles(Graph<Integer> g) {

		HashMap<GraphNode<Integer>, Boolean> visited = new HashMap<GraphNode<Integer>, Boolean>();
		HashMap<GraphNode<Integer>, Boolean> vList = new HashMap<GraphNode<Integer>, Boolean>();
		Collection<GraphNode<Integer>> vertices = g.getVertices();
		for(GraphNode<Integer> v:vertices) {
			if(visited.get(v) == null && hasCycles(v, visited,vList ))  return true;
		}
		return false;
	}

	public boolean hasCycles(GraphNode<Integer> n,
			HashMap<GraphNode<Integer>, Boolean> visited,
			HashMap<GraphNode<Integer>, Boolean> vList) {

		if (vList.get(n) != null)
			return true;
		
		if (visited.get(n) == null) {	
			visited.put(n, true);
			vList.put(n, true);

			Collection<GraphNode<Integer>> edges = n.getNeighbors();
			if(edges != null)
				for (GraphNode e : edges) {
					return hasCycles(e, visited, vList);
				}

		}
		return false;
	}

	public static void main(String[] args) {
		Graph<Integer> g = new Graph<Integer>();
		g.addVertex(1);
		g.addEdge(1, 2, 1);
		g.addEdge(2, 3, 1);
//		g.addEdge(3, 1, 1);
		g.addEdge(2, 5, 1);
		g.addEdge(5, 6, 1);
		g.addEdge(3, 5, 1);
		g.addEdge(3, 4, 1);
		g.addEdge(4, 7, 1);
		g.addEdge(6, 2, 1);

		Traversal t = new Traversal();
		// t.bfs(g.getVertex(1));
//		t.dfs(g);
		System.out.println(t.hasCycles(g));
	}

}

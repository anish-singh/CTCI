package hard;

import graphs.Graph;
import graphs.GraphNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class WordLadder {
	Graph<String> g;

	public WordLadder() {
		g = new Graph<String>();
	}

	private void buildGraph(String[] words) {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		for (String w : words) {
			g.addVertex(w);
			for (int i = 0; i < w.length(); i++) {
				String pre = "";
				if (i > 0)
					pre = w.substring(0, i);
				String post = "";
				if (i < (w.length() - 1))
					post = w.substring(i + 1, w.length());
				String key = pre + "_" + post;

				if (map.containsKey(key)) {
					ArrayList<String> a = map.get(key);
					a.add(w);
					System.out.println("adding " + w + " to key=" + key);
				} else {
					ArrayList<String> a = new ArrayList<String>();
					a.add(w);
					System.out.println("adding " + w + " to key=" + key);
					map.put(key, a);
				}

			}
		}

		Collection<String> buckets = map.keySet();
		for (String b : buckets) {
			ArrayList<String> l = map.get(b);
			for (String w : l) {
				for (String w2 : l) {
					if (!w.equals(w2)) {
						g.addEdge(g.getVertex(w), g.getVertex(w2), 1);
						// System.out.println("Adding Edge from " + w + " to " +
						// w2);
					}
				}
			}
		}
	}
	
	public void findPath(String w1, String w2) {
		
		GraphNode<String> start = g.getVertex(w1);
		LinkedList<GraphNode<String>> q = new LinkedList<GraphNode<String>>();
		
		start.parent = null;
		q.add(start);
		boolean found = false;
		
		while(!q.isEmpty() && !found) {
			GraphNode<String> n = q.remove();
			n.status = GraphNode.STATUSES.VISITED;
			if (n.key.equals(w2)){
				found = true;
			}
				
			Collection<GraphNode<String>> neighbors = n.getNeighbors();
			if(neighbors != null) {
				for(GraphNode<String> c: neighbors) {
					if(c.status != GraphNode.STATUSES.VISITED) {
						c.status = GraphNode.STATUSES.VISITING;
						c.parent = n;
						q.add(c);
					}
				}
			}
		}
		
		if(found) {
			GraphNode<String> n = g.getVertex(w2);
			while(n!=null) {
				System.out.println(n.key + "->");
				n = n.parent;
			}
			
		}
		
	}

	public static void main(String[] args) {
		WordLadder w = new WordLadder();
		String[] words = new String[] { "hot", "hit", "dot", "dog", "cog",
				"lot", "log" };

		w.buildGraph(words);
		w.findPath("hot", "cog");
	}

}

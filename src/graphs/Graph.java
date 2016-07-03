package graphs;

import java.util.Collection;
import java.util.HashMap;

public class Graph<K> {
	
	int size = 0;
	HashMap<K, GraphNode<K>>  vertices;
	
	public Graph(){
		vertices = new HashMap<K, GraphNode<K>>();
	}
	
	public void addVertex(K key){
		GraphNode<K> v = new GraphNode<K>(key);
		vertices.put(key, v);
		size++;
	}
	
	public Collection<GraphNode<K>> getVertices()
	{
		return vertices.values();
	}
	
	public GraphNode<K> getVertex(K key){
		return vertices.get(key);
	}
	
	public void addEdge(GraphNode<K> from, GraphNode<K> to, int weight){
		from.addEdge(to, weight);
	}
	
	public void addEdge(K from,K to, int weight){
		
		if(getVertex(from) == null)  addVertex(from);
		if(getVertex(to) == null)  addVertex(to);
		getVertex(from).addEdge(getVertex(to), weight);
	}
	

}

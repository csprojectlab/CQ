package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphBFSDFS extends Graph {
	public GraphBFSDFS() {
		super();
	}
	
	// Unlike trees, graphs contains cycles.
	public void BFS(String startNode) {
		Vertex vertex = this.vertices.get(startNode);
		if(vertex == null)
			return;
		Queue<Vertex> queue = new LinkedList<Vertex>();
		Set<String> isVisited = new HashSet<String>();
		queue.add(vertex);
		isVisited.add(vertex.name);
		while(!queue.isEmpty()) {
			Vertex v = queue.remove();
			isVisited.add(v.name);
			System.out.print(v.name + " ");
			Set<Vertex> neighbors = v.neighbors.keySet();
			for(Vertex neighbor : neighbors)
				if(!isVisited.contains(neighbor.name)) {
					isVisited.add(neighbor.name);
					queue.add(neighbor);
				}
		}		
	}
	
	public void DFS(String vertexName) {
		Set<String> isVisited = new HashSet<String>();
		this.DFS(vertexName, isVisited);
	}
	
	public void DFS(String vertexName, Set<String> isVisited) {
		if(!this.vertices.containsKey(vertexName))
			return;
		Vertex vertex = this.vertices.get(vertexName);
		isVisited.add(vertexName);
		System.out.print(vertex.name + " ");
		Set<Vertex> neighbors = vertex.neighbors.keySet();
		for(Vertex neighbor : neighbors)
			if(!isVisited.contains(neighbor.name))
			  this.DFS(neighbor.name, isVisited);
	}
	
	public static void main(String[] args) {
		GraphBFSDFS g = new GraphBFSDFS();
		g.addVertex("1");
    	g.addVertex("2");
    	g.addVertex("3");
    	g.addVertex("4");	
    	g.addVertex("5");
    	g.addVertex("7");
    	g.addEdge("1", "5", 10);
    	g.addEdge("1", "3", 40);
    	g.addEdge("3", "5", 10);
    	g.addEdge("5", "4", 10);
    	g.addEdge("5", "2", 2);
    	g.addEdge("2", "7", 12);
    	System.out.print("Breadth First Search: ");
    	g.BFS("1");
    	System.out.println();
    	System.out.print("Depth First Search:   ");
    	g.DFS("1");
	}

}

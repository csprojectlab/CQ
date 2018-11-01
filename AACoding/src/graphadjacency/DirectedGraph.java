package graphadjacency;

import java.util.LinkedList;

public class DirectedGraph extends Graph {

	public DirectedGraph() {
		super();
	}

	public DirectedGraph(LinkedList<String> vertices) {
		super(vertices);
	}

	public DirectedGraph(int[][] edges, LinkedList<String> vertices) {
		super(edges, vertices);
	}

	// Overriding the method to add edge only on one side.
	public void addEdge(Object v1, Object v2) {
		int index1 = this.vertices.indexOf(v1);
		int index2 = this.vertices.indexOf(v2);
		if(index1 == -1 || index2 == -1)
			return;
		if(this.neighbors.get(index1).contains(index2))
			return;
		this.neighbors.get(index1).add(index2);  
	}
	
	public static void main(String[] args) {
		DirectedGraph g = new DirectedGraph();
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		g.addVertex("f");
		
		g.addEdge("a","f");
		g.addEdge("a","b");
		g.addEdge("b","c");
//		g.addEdge("b","e");   // This edge causes cycle
		g.addEdge("c","d");
		g.addEdge("e","d");
		g.display();

	}

}

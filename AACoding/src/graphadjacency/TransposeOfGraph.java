package graphadjacency;

import java.util.LinkedList;
import java.util.List;

public class TransposeOfGraph extends Graph {

	public TransposeOfGraph() {
		super();
	}

	public void transpose() {
		LinkedList<String> oldVertices = this.vertices;
		List<List<Integer>> oldNeighbors = this.neighbors;
		this.vertices = new LinkedList<>();
		this.initializeNeighbors();
		for(String v : oldVertices)
			this.addVertex(v);
		for(int i = 0; i < oldVertices.size(); i++) {
			List<Integer> iNeighbors = oldNeighbors.get(i);
			for(int n = 0; n != i && n < oldVertices.size(); n++) 
				if(!iNeighbors.contains(n))
					this.addEdge(this.vertices.get(i), this.vertices.get(n));
		}
	}
	
	public static void main(String[] args) {
		TransposeOfGraph g = new TransposeOfGraph();
		g.addVertex("1");
		g.addVertex("2");
		g.addVertex("3");
		g.addVertex("4");
		g.addVertex("5");
		g.addVertex("7");
		g.addEdge("1", "5");
		g.addEdge("1", "3");
		g.addEdge("3", "5");
		g.addEdge("5", "4");
		g.addEdge("5", "2");
		g.addEdge("2", "7");
		g.display();
		g.transpose();
		g.display();
	}

}

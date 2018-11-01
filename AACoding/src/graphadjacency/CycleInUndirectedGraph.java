package graphadjacency;


public class CycleInUndirectedGraph extends Graph {
		
	public CycleInUndirectedGraph() {
		super();
	}
	
	public boolean detectCycle() {
		// Parent of 0'th vertex is null.
		return this.detectCycle(0, -1, new boolean[this.vertices.size()]);		
	}

	public boolean detectCycle(int v, int parent, boolean[] isVisited) {
		isVisited[v] = true;
		for(Integer n : this.neighbors.get(v)) {
			if(!isVisited[n]) {  // Find the cycle from this vertex.
				if(this.detectCycle(n, v, isVisited))
					return true;
			} else if(n != parent)  // neighbor is already visited, compare with parent.
				return true;			
		}
		return false;
	}
	

	public static void main(String[] args) {
		CycleInUndirectedGraph g = new CycleInUndirectedGraph();
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
		System.out.println("Cycle exist: " + g.detectCycle());
		
	}

}

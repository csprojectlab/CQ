package graphadjacency;

public class CyclesInUndirectedGraphUsingColors extends Graph {
	public final int WHITE = 0, GREY = 1, BLACK = 2;

	public CyclesInUndirectedGraphUsingColors() {
		// TODO Auto-generated constructor stub
	}

	public boolean findCycle() {
		int[] color = new int[this.vertices.size()];
		return this.findCycleDFS(0, color, -1);
	}

	public boolean findCycleDFS(int v, int[] color, int parent) {
		color[v] = GREY; // set vertex as being visited.
		for (Integer n : this.neighbors.get(v)) { // for its neighbors.
			if (color[n] == WHITE) { // neighbor is not visited.
				if (this.findCycleDFS(n, color, v))
					return true;
			} else if (n != parent) { // neighbor is visited.
				return true;
			}
		}
		color[v] = BLACK; // Visited all descendents.
		return false;
	}

	public static void main(String[] args) {
		CyclesInUndirectedGraphUsingColors g = new CyclesInUndirectedGraphUsingColors();
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		g.addVertex("f");
		
		g.addEdge("a","f");
		g.addEdge("a","b");
		g.addEdge("b","c");
		g.addEdge("b","e");   // This edge causes cycle
		g.addEdge("c","d");
		g.addEdge("e","d");
		
		g.display();
		System.out.println("Cycle: " + g.findCycle());
	}

}

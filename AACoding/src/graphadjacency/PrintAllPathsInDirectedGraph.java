package graphadjacency;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This work is related to Ajad
 * Not required now, but is still there for reference point of view.
 */
public class PrintAllPathsInDirectedGraph extends DirectedGraph {
	
	private Map<Integer, List<Integer>> pNeighbors = new HashMap<Integer, List<Integer>>();
	
	public void printAllPaths (int v, String output) {
		output += this.vertices.get(v);
		if (this.neighbors.get(v).size() == 0) {
			System.out.println(output);
			return;
		}
		for (Integer n : this.neighbors.get(v)) {
			if (!this.pNeighbors.get(v).contains(n)) {
				this.pNeighbors.get(v).add(n);
				this.printAllPaths(n, output + " ");
				this.pNeighbors.get(v).remove(n);
			}
		}
	}	
	
	public void printAllPaths2 (int v, String output) {
		output += this.vertices.get(v);
		if (this.neighbors.get(v).size() == 0) {
			System.out.println(output);
			return;
		}
		for (Integer n : this.neighbors.get(v)) {
			if (!this.pNeighbors.get(v).contains(n)) {
				if (this.neighbors.get(n).contains(v))
					this.pNeighbors.get(v).add(n);
				this.printAllPaths(n, output + " ");
				this.pNeighbors.get(v).remove(n);
			}
		}
	}	
	
	public static void main (String[] args) {
		PrintAllPathsInDirectedGraph g = new PrintAllPathsInDirectedGraph();
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		g.addVertex("f");
		g.addVertex("g");
		g.addVertex("h");
		g.addVertex("i");
		g.addVertex("k");
		
		g.addEdge("a", "b");
		g.addEdge("a", "c");
		g.addEdge("b", "g");
		g.addEdge("c", "d");
		g.addEdge("c", "e");
		g.addEdge("c", "i");
		g.addEdge("d", "f");
		g.addEdge("e", "c");
		g.addEdge("e", "g");
		g.addEdge("e", "h");
		g.addEdge("f", "c");
		g.addEdge("f", "k");
		
		
		g.display();
		// Init the map.
		for (int i = 0; i < g.vertices.size(); i++)
			g.pNeighbors.put(i, new LinkedList<Integer>());
		g.printAllPaths2(0, "");
		
	}
}

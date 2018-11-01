package graphadjacency;

import java.util.HashSet;
import java.util.Set;

class Pair {
	String u;
	String v;
	public Pair(String u, String v) {
		this.u = u;
		this.v = v;
	}
	public String toString() {
		return "{" + this.u + "--" + this.v + "}";
	}
}
public class ArticulationEdgesOrBridgesInGraph extends Graph {
	public int timer = 0;
	public ArticulationEdgesOrBridgesInGraph() {
		// TODO Auto-generated constructor stub
	}

	public Set<Pair> bridgeEdges() {
		int[] disc = new int[this.vertices.size()];
		int[] low = new int[this.vertices.size()];
		Set<Pair> result = new HashSet<>();
		boolean[] visited = new boolean[this.vertices.size()];
		this.bridgeEdges(0, disc, low, result, -1, visited);
		for(int i = 0; i < disc.length; i++)
			System.out.println(this.vertices.get(i) + ": " + disc[i] + " : " + low[i]);
		System.out.println(result);
		return null;
	}
	
	public void bridgeEdges(int v, int[] disc, int[] low, Set<Pair> result, int parent, boolean[] visited) {
		System.out.println("Visiting: " + this.vertices.get(v));
		visited[v] = true;
		disc[v] = low[v] = timer;
		timer++;
		for(Integer n : this.neighbors.get(v)) {
			if(!visited[n]) {
				this.bridgeEdges(n, disc, low, result, v, visited);
				if(low[n] > disc[v]) 
					result.add(new Pair(this.vertices.get(v), this.vertices.get(n)));
				else
					low[v] = low[n];
			} else if(n != parent && low[n] < low[v]) {
				low[v] = low[n];
			}
		}
	}
	
	public static void main(String[] args) {
		ArticulationEdgesOrBridgesInGraph g = new ArticulationEdgesOrBridgesInGraph();
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		g.addVertex("f");
		g.addVertex("g");
		g.addVertex("h");
		
		g.addEdge("a", "b");
		g.addEdge("a", "c");
		g.addEdge("b", "c");
		g.addEdge("c", "d");
		g.addEdge("d", "e");
		g.addEdge("e", "f");
		g.addEdge("e", "g");
		g.addEdge("f", "g");
		g.addEdge("f", "h");

		g.display();
		g.bridgeEdges();
	}

}

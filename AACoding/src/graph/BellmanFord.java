package graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BellmanFord extends DirectedGraph {
	Map<String, String> parent;
	Map<String, Integer> distance;
	public static final int infinity = 1000;
	public BellmanFord() {
		super();
	}

	public void check(Vertex u, Vertex v) {
		if(this.parent.get(u.name) == null)
			this.parent.put(u.name, null);
		if(this.parent.get(v.name) == null)
			this.parent.put(v.name, null);
		if(this.distance.get(u.name) == null)
			this.distance.put(u.name, infinity);
		if(this.distance.get(v.name) == null)
			this.distance.put(v.name, infinity);
	}
	
	public void relaxEdge(Vertex u, Vertex v) {
	}
	
	public void singleSourceShortestPath(String source) {
		Vertex s = this.vertices.get(source);
		if(s == null)
			return;
		this.parent = new HashMap<>();
		this.distance = new HashMap<>();
		this.parent.put(s.name, null);
		this.distance.put(s.name, 0);
		Collection<Vertex> vList = this.vertices.values();
		for(int N = 0; N < this.vertices.size() - 1; N++) {   // relax n - 1 times.
			for(Vertex U : vList) {
				for(Vertex V : U.neighbors.keySet()) {  // for each edge (u,v)
					this.relaxEdge(U, V);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

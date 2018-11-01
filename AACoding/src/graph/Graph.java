package graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Vertex {
	String name;
	Map<Vertex, Integer> neighbors;

	public Vertex(String name) { // Constructor.
		this.name = name;
		this.neighbors = new HashMap<>();
	}

	public boolean equals(Object other) { // Equality.
		Vertex v = (Vertex) other;
		return this.name.endsWith(v.name);
	}

	public int hashCode() {
		return this.name.hashCode();
	}

	public void display() {
		String r = "";
		r += this.name + " => ";
		Set<Vertex> neighbors = this.neighbors.keySet();
		for (Vertex neighbor : neighbors) {
			r += neighbor.name + "(" + this.neighbors.get(neighbor) + "),";
		}
		r += " END";
		System.out.println(r);
	}
} // End of class.

public class Graph {
	Map<String, Vertex> vertices;

	public Graph() {
		this.vertices = new HashMap<>();
	}

	public int getNumberOfVertices() {
		return this.vertices.size();
	}

	public void addVertex(String name) {
		if (this.vertices.containsKey(name)) {
			//System.out.println(name + ": DUPLICATE KEY.");
			return;
		}
		Vertex newVertex = new Vertex(name);
		this.vertices.put(name, newVertex);
	}
	
	public void removeVertex(String name) {
		Vertex v = this.vertices.get(name);
		if(v == null) {
			System.out.println(name + ": NO SUCH VERTEX EXIST.");
			return;
		}
		Set<Vertex> neighbors = v.neighbors.keySet();
		for(Vertex neighbor : neighbors) {
			neighbor.neighbors.remove(v);
		}
		this.vertices.remove(name);
	}

	public void addEdge(String vname1, String vname2, int cost) {		
		Vertex v1 = this.vertices.get(vname1);
		Vertex v2 = this.vertices.get(vname2);
		if(v1 == null || v2 == null || v1.neighbors.containsKey(v2)) {
			System.out.println("(" + vname1 + "," + vname2 + ")" + ": DUPLICATE EDGE.");
			return;
		}
		v1.neighbors.put(v2, cost);
		v2.neighbors.put(v1, cost);
	}
	
	public void removeEdge(String vname1, String vname2) {
		Vertex v1 = this.vertices.get(vname1);
		Vertex v2 = this.vertices.get(vname2);
		if(v1 == null || v2 == null || !v1.neighbors.containsKey(v2)) {
			System.out.println("(" + vname1 + "," + vname2 + ")" + ": NO SUCH EDGE FOUND.");
			return;
		}
		v1.neighbors.remove(v2);
		v2.neighbors.remove(v1);
	}
	
	public void display() {
		Collection<Vertex> vertices = this.vertices.values();
		for(Vertex v : vertices)
			v.display();
		System.out.println("--------------------------------------------------------------------------------");
	}
	
	public int getNumberOfEdges() {
		Collection<Vertex> vertices = this.vertices.values();
		int count = 0;
		for(Vertex v : vertices) {
			count +=v.neighbors.size();
		}
		return count/2;
	}
	
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addVertex("ASR");
		g.addVertex("JAL");
		g.addVertex("KRT");
		g.addVertex("KRT"); // Duplicate
		g.addEdge("KRT", "JAL", 5);
		g.addEdge("ASR", "JAL", 80);
		g.addEdge("ASR", "JAL", 80); // Duplicate
		g.display();
		System.out.println("Number of Edges: " + g.getNumberOfEdges());
		g.removeEdge("ASR", "KRT");  // No such edge exist.
		System.out.println("After some deletion:===============================");
		g.display();
		g.removeVertex("JAL");
		g.display();
		System.out.println("Number of Edges: " + g.getNumberOfEdges());
		g.addVertex("a");
    	g.addVertex("b");
    	g.addVertex("c");
    	g.addVertex("d");
    	g.addVertex("e");
    	g.addVertex("f");
    	g.addVertex("g");
    	
    	g.addEdge("a", "b", 10);
    	g.addEdge("a", "d", 40);
    	g.addEdge("b", "c", 10);
    	g.addEdge("c", "d", 10);
    	g.addEdge("d", "e", 2);
    	g.addEdge("e", "f", 8);
    	g.addEdge("e", "g", 3);
    	g.addEdge("f", "g", 3);
    	
    	g.display();
    	System.out.println("Number of Edges: " + g.getNumberOfEdges());
    	System.out.println("Number of Vertices: " + g.getNumberOfVertices());
	}
}

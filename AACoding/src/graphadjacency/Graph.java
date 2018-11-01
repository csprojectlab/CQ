package graphadjacency;

import java.util.LinkedList;
import java.util.List;


public class Graph {
	LinkedList<String> vertices;
	List<List<Integer>> neighbors;
	public Graph() {
		this(new LinkedList<>());
	}
	public Graph(LinkedList<String> vertices) {
		this.vertices = vertices;
		this.initializeNeighbors();
	}
	public Graph(int[][] edges, LinkedList<String> vertices) {
		this.vertices = vertices;  
		this.initializeNeighbors();
		this.adjacencyList(edges);  // Build the neighbors.
	}
	
	public void initializeNeighbors() {
		this.neighbors = new LinkedList<>();
		for(int i = 0; i < this.vertices.size(); i++)
			this.neighbors.add(new LinkedList<>());
	}
	
	private void adjacencyList(int[][] edges) {
		for(int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			this.neighbors.get(u).add(v);
		}
	}
	
	public void addVertex(String vertex) {
		this.vertices.add(vertex);
		this.neighbors.add(new LinkedList<>());
	}
	
	public void addEdge(Object v1, Object v2) {
		int index1 = this.vertices.indexOf(v1);
		int index2 = this.vertices.indexOf(v2);
		if(index1 == -1 || index2 == -1)
			return;
		if(this.neighbors.get(index1).contains(index2))
			return;
		this.neighbors.get(index1).add(index2);
		this.neighbors.get(index2).add(index1);
	}
	
	public void display() {
		for(int vertex = 0; vertex < this.vertices.size(); vertex++) {
			System.out.print(this.vertices.get(vertex) + ": [ ");
			List<Integer> nlist = this.neighbors.get(vertex);
			for(Integer n : nlist) {
				System.out.print(this.vertices.get(n) + " ");
			}
			System.out.println("]");
		}
		System.out.println("=========================================================================================");
	}
	
	public static void main(String[] args) {
		int[][] edges = {{0,1},{0,2},{0,3},
                {1,0},{1,2},{1,4},
                {2,0},{2,1},{2,3},
                {3,0},{3,2},
                {4,1}
		         };
//		LinkedList<String> vertices = new LinkedList<>();
//		vertices.add("Aridaman");
//		vertices.add("Rishu");
//		vertices.add("Harshit");
//		vertices.add("Adhish");
//		vertices.add("Japjeet");
//		
		Graph g = new Graph();
		g.addVertex("Vikas");
		g.addVertex("Aridaman");
		g.addEdge("Vikas", "Aridaman");
//		g.addEdge("Vikas", "Aridaman");  // duplicate.
		g.display();
	}
}

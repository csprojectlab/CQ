package graphadjacency;

import java.util.LinkedList;
import java.util.List;


public class GraphWeighted {
	public LinkedList<String> vertices;
	public List<List<Edge>> neighbors;
	public GraphWeighted() {
		this.vertices = new LinkedList<>();
		this.neighbors = new LinkedList<>();
		for(int i = 0; i < this.vertices.size(); i++)
			this.neighbors.add(new LinkedList<>());
	}
	
	public void addVertex(String vertex) {
		this.vertices.add(vertex);
		this.neighbors.add(new LinkedList<>());
	}
	
	public void addEdge(Object v1, Object v2, int cost) {
		int index1 = this.vertices.indexOf(v1);
		int index2 = this.vertices.indexOf(v2);
		if(index1 == -1 || index2 == -1)
			return;
		if(this.neighbors.get(index1).contains(index2))
			return;
		this.neighbors.get(index1).add(new Edge(index1, index2, cost));
		this.neighbors.get(index2).add(new Edge(index2, index1, cost));
	}
	
	public void display() {
		for(int vertex = 0; vertex < this.vertices.size(); vertex++) {
			System.out.print(this.vertices.get(vertex) + ": [ ");
			List<Edge> nlist = this.neighbors.get(vertex);
			for(Edge e : nlist) {
				System.out.print(e + " ");
			}
			System.out.println("]");
		}
		System.out.println("=========================================================================================");
	}
	
	public List<Edge> getAllEdges() {
		List<Edge> edgeList = new LinkedList<>();
		for(List<Edge> el : this.neighbors) {
			edgeList.addAll(el);
		}
		return edgeList;
	}
	
	class Edge implements Comparable<Edge>{
		int u;
		int v;
		int cost;
		public Edge() {}
		public Edge(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}
		public int compareTo(Edge o) {
			Edge other = (Edge)o;
			if(this.cost > other.cost)
				return 1;
			if(this.cost < other.cost)
				return -1;			
			return 0;
		}
		public boolean equals(Object o) {
			Edge other = (Edge)o;
			if(this.u == other.u && this.v == other.v)
				return true;
			return false;
		}
		public String toString() {
			return "({" + vertices.get(this.u) + "," + vertices.get(this.v) + "}: " + this.cost + ")";
		}
	}

}

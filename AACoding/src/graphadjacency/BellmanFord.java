package graphadjacency;

public class BellmanFord extends GraphWeightedDirected {
	int[] parent;
	int[] distance;
	public static final int infinity = 1000;
	public BellmanFord() {
		super();
	}

	public void relaxEdge(int u, int v, int cost) {
		if(this.distance[v] > this.distance[u] + cost) {
			this.distance[v] = this.distance[u] + cost;
			this.parent[v] = u;
		}
	}
	
	public void singleSouceShortestPath(String source) {
		int si = this.vertices.indexOf(source);
		if(si == -1)
			return;
		this.parent = new int[this.vertices.size()];
		this.distance = new int[this.vertices.size()];
		for(int i = 0; i < this.distance.length; i++)
			this.distance[i] = infinity;
		this.parent[si] = -1;
		this.distance[si] = 0;
		for(int N = 0; N < this.vertices.size() - 1; N++) {
			for(int U = 0; U < this.vertices.size(); U++) 
				for(Edge edge : this.neighbors.get(U)) 
					this.relaxEdge(U, edge.v, edge.cost);
		}
	}
	
	public boolean negativeEdgeCycle(String source) {
		this.singleSouceShortestPath(source);
		// Doing extra iteration.
		for(int U = 0; U < this.vertices.size(); U++) {
			for(Edge edge : this.neighbors.get(U)) {
				int V = edge.v;
				if(this.distance[V] > this.distance[U] + edge.cost) {
					return true;
				}
			}
		}		
		return false;
	}
	
	public static void main(String[] args) {
		BellmanFord g = new BellmanFord();
		g.addVertex("0");
		g.addVertex("1");
		g.addVertex("2");
		g.addVertex("3");
		g.addVertex("4");
		
		g.addEdge("0", "3", 8);
		g.addEdge("0", "2", 5);
		g.addEdge("0", "1", 4);
		g.addEdge("1", "2", -3);
		g.addEdge("2", "4", 4);
		g.addEdge("3", "4", 2);
		g.addEdge("4", "3", 1);
		// This has no negative edge cycle
		g.display();
		
		g.singleSouceShortestPath("0");
		System.out.println("Parent array: ");
		for(int i = 0; i < g.parent.length; i++) {
			System.out.println(g.vertices.get(i) + ": " + g.parent[i]);
		}
		System.out.println("Distance array: ");
		for(int i = 0; i < g.distance.length; i++)
			System.out.println(g.vertices.get(i) + ": " + g.distance[i]);
		System.out.println("Checking for negative edge cycle: " + g.negativeEdgeCycle("0"));
		
		g = new BellmanFord();
		g.addVertex("0");
		g.addVertex("1");
		g.addVertex("2");
		g.addVertex("3");
		
		g.addEdge("0", "1", 1);
		g.addEdge("1", "2", 3);
		g.addEdge("2", "3", 2);
		g.addEdge("3", "1", -6);
		
		g.display();
		System.out.println("Checking for negative edge cycle: " + g.negativeEdgeCycle("0"));
		System.out.println("Edgelist: " + g.getAllEdges());
	}

}

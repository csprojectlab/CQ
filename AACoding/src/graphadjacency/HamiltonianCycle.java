package graphadjacency;


public class HamiltonianCycle extends Graph {

	public HamiltonianCycle() {
		// TODO Auto-generated constructor stub
	}

	public boolean hamiltonianCycle() {
		int path[] = new int[this.vertices.size()];  // To store the hamiltonian path.
		// Hamiltonian path can start from any vertex. So we have to try all possibilities.
		for(int v = 0; v < this.vertices.size(); v++) {  // For each vertex.
			boolean[] visited = new boolean[this.vertices.size()];
			path[0] = v;
			if(this.hamiltonianCycleDFS(v, visited, path, 1)) {
				System.out.print("Hamiltonian Cycle exist from vertex: " + this.vertices.get(v) + " ->  ");
				for(int i = 0; i < path.length; i++) 
					System.out.print(this.vertices.get(path[i]) + " ");
				System.out.println(this.vertices.get(v));
			} else {
				System.out.println(this.vertices.get(v) + ": false");
			}
		}
		return true;
	}
	
	public boolean hamiltonianCycleDFS(int v, boolean[] visited, int[] path, int k) {
		visited[v] = true;
		for(Integer n : this.neighbors.get(v)) {   // Go to each neighbor.
			if(!visited[n]) {
				path[k] = n;
				// checking if there exist an edge between last one and the first one.
				if(k == path.length - 1 && this.neighbors.get(path[k]).contains(path[0]))
					return true;
				if(this.hamiltonianCycleDFS(n, visited, path, k+1))
					return true;
				// In this scenario there is no need to override the value of path.
			}
		}
		visited[v] = false;
		return false;
	}
	
	public static void main(String[] args) {
		HamiltonianCycle g = new HamiltonianCycle();
		g.addVertex("0");
		g.addVertex("1");
		g.addVertex("2");
		g.addVertex("3");
		g.addVertex("4");
		
		g.addEdge("0", "1");
		g.addEdge("0", "3");
		g.addEdge("1", "2");
		g.addEdge("1", "3");
		g.addEdge("1", "4");
		g.addEdge("2", "4");
		g.addEdge("3", "4");   // If we remove this edge there will be no hamiltonian cycle.

		g.display();
		g.hamiltonianCycle();
	}

}

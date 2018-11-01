package graphadjacency;

// The graph is bipartite if it doesn't contain cycles of odd length
// If there exist a cycle of odd length then the graph is not bipartite.
public class CyclesOfOddLength extends Graph {
	public int count = 0;
	public CyclesOfOddLength() {
		// TODO Auto-generated constructor stub
	}

	public void cyclesOfOddLength() {
		// Minimum odd length cycle is of length 3. This is an important point to note and know.
		int rounds = this.vertices.size() - (3 - 1);
		boolean[] visited = new boolean[this.vertices.size()];
		for(int i = 0; i < rounds; i++) {
			System.out.println(this.vertices.get(i));
			this.cyclesOfOddLength(i, i, 0, visited);
			visited[i] = true;
		}
		System.out.println("Unique Odd length cycles: " + this.count/2);
	}
	
	public void cyclesOfOddLength(int v, int start, int N, boolean[] visited) {
		visited[v] = true;
		if(N + 1 > 2 && (N+1) % 2 == 1) {  // Something of odd length found.
			if(this.neighbors.get(v).contains(start))
				this.count++;
		}
		for(Integer n : this.neighbors.get(v)) 
			if(!visited[n]) 
				this.cyclesOfOddLength(n, start, N+1, visited);
		visited[v] = false;
	}
	
	public static void main(String[] args) {
		CyclesOfOddLength g = new CyclesOfOddLength();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		
		g.addEdge("A", "B");
		g.addEdge("A", "D");
		g.addEdge("B", "C");
		g.addEdge("B", "D");
		g.addEdge("B", "E");
		g.addEdge("C", "D");
		g.addEdge("C", "E");
		
		g.display();
		
		g.cyclesOfOddLength();
	}
}

package graphadjacency;


public class LongestPathBetweenAnyPairOfVertices extends GraphWeighted {
	public int maxSum;
	public LongestPathBetweenAnyPairOfVertices() {
		this.maxSum = Integer.MIN_VALUE;
	}

	// The path can start from any vertex.
	public int getLongestPath() {
		// Only half of the vertices need to be visited.
		for(int v = 0; v < this.vertices.size() / 2; v++) 
			this.getLongestPathDFS(v, new boolean[this.vertices.size()], 0);	
		System.out.println(this.maxSum);
		return maxSum;
	}
	
	public void getLongestPathDFS(int v, boolean[] visited, int sum) {
		visited[v] = true;
		if(sum > this.maxSum)
			this.maxSum = sum;
		for(Edge e : this.neighbors.get(v)) {
			if(!visited[e.v]) {
				this.getLongestPathDFS(e.v, visited, sum + e.cost);
			}
		}
	}
	
	public static void main(String[] args) {
		LongestPathBetweenAnyPairOfVertices g = new LongestPathBetweenAnyPairOfVertices();
		g.addVertex("1");
		g.addVertex("2");
		g.addVertex("3");
		g.addVertex("4");
		g.addVertex("5");
		g.addVertex("6");
		
		g.addEdge("1", "2", 3);
		g.addEdge("2", "3", 4);
		g.addEdge("2", "6", 2);
		g.addEdge("4", "6", 6);
		g.addEdge("5", "6", 5);

		g.display();
		g.getLongestPath();
	}

}

package graphadjacency;


public class BipartiteGraph extends Graph {
	public static final int RED = 1;
	public static final int BLUE = 2;
	public boolean colorable = true;

	public BipartiteGraph() {
		// TODO Auto-generated constructor stub
	}

		
	public boolean isBipartite() {
		this.isBipartiteDFS(0, new int[this.vertices.size()], RED);
		return this.colorable;
	}
	
	// Now the color matrix will also work as visited matrix.
	public void isBipartiteDFS(int v, int[] color, int currentColor) {
		if(color[v] == 0) {  // If vertex is not visited.
			color[v] = currentColor;  // assign the color.
			int otherColor = (currentColor == RED) ? BLUE : RED;   // Get the other color for its neighbors.
			for(Integer n : this.neighbors.get(v)) {
				if(color[n] == 0) {  // if neighbor is not visited.
					this.isBipartiteDFS(n, color, otherColor);   // dfs.
				} else if(color[n] == currentColor) {  // if neighbor is visited and color is same as v.
					this.colorable = false;
					return;  // no need to go further.
				}
			}			
		}
	}
	
	public static void main(String[] args) {
		BipartiteGraph g = new BipartiteGraph();
		g.addVertex("1");
		g.addVertex("2");
		g.addVertex("3");
		g.addVertex("4");
		g.addVertex("5");
		g.addVertex("6");
		
		g.addEdge("1", "2");
		g.addEdge("2", "3");
		g.addEdge("3", "4");
		g.addEdge("4", "5");
		g.addEdge("5", "6");
		g.addEdge("6", "1");
		
		g.display();
		System.out.println("Is Bipartite: " + g.isBipartite());
		
	}

}

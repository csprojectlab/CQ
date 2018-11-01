package graphadjacency;

public class CountNumberOfTreesInForest extends Graph {
	
	public CountNumberOfTreesInForest() {
		super();
	}

	public void applyDFS(int v, boolean[] isVisited) {
		isVisited[v] = true;
		for(Integer n : this.neighbors.get(v))
			if(!isVisited[n]) {
				isVisited[n] = true;
				this.applyDFS(n, isVisited);
			}
	}
	
	public int countNumberOfTreesDFS() {
		int numberOfTrees = 0;
		boolean isVisited[] = new boolean[this.vertices.size()];
		for(int v = 0; v < this.vertices.size(); v++) {
			if(!isVisited[v]) {
				numberOfTrees++;
				this.applyDFS(v, isVisited);
			}				
		}
		return numberOfTrees;
	}

	public static void main(String[] args) {
		CountNumberOfTreesInForest g = new CountNumberOfTreesInForest();
		g.addVertex("aridaman");
		g.addVertex("vikas");
		g.addVertex("uttkarsh");
		g.addVertex("shraddha");
		g.addEdge("vikas", "shraddha");
		System.out.println(g.countNumberOfTreesDFS());
	}

}

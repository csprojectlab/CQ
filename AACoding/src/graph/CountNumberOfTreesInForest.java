package graph;

import java.util.HashSet;
import java.util.Set;

public class CountNumberOfTreesInForest extends Graph {
	int numberOfTrees;
	Set<String> isVisited;
	public CountNumberOfTreesInForest() {
		super();
		this.numberOfTrees = 0;
		this.isVisited = new HashSet<String>();
	}
	
	public void applyDFS(Vertex source) {
		this.isVisited.add(source.name);
		for(Vertex neighbor : source.neighbors.keySet()) {
			if(!this.isVisited.contains(neighbor.name))
				this.applyDFS(neighbor);
		}
	}
	
	
	public int countTreesInForest() {
		for(Vertex v : this.vertices.values()) {
			if(!this.isVisited.contains(v.name)) {
				this.numberOfTrees++;
				this.applyDFS(v);
			}
		}
		return this.numberOfTrees;		
	}

	public static void main(String[] args) {
		CountNumberOfTreesInForest g = new CountNumberOfTreesInForest();
		g.addVertex("0");
		g.addVertex("1");
		g.addVertex("2");
		g.addVertex("3");
		g.addVertex("4");
		g.addVertex("5");
		g.addEdge("0", "1", 0);
		g.addEdge("0", "2", 0);
		g.addEdge("3", "4", 0);
		g.display();
		System.out.println("Number of trees in forest: " + g.countTreesInForest());  // 3
	}

}

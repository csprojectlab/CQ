package graphadjacency;

import java.util.LinkedList;
import java.util.Queue;

public class BFSAndDFS extends Graph {

	public BFSAndDFS() {
		super();
	}

	public void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		boolean isVisited[] = new boolean[this.vertices.size()];
		queue.add(0);  // add the first vertex.
		isVisited[0] = true;
		while(!queue.isEmpty()) {
			int v = queue.remove();
			System.out.print(this.vertices.get(v) + " ");
			for(Integer n : this.neighbors.get(v)) {
				if(!isVisited[n]) {
					isVisited[n] = true;
					queue.add(n);
				}
			}
		}
		System.out.println();
	}
	
	public void DFS(int v, boolean[] isVisited) {
		isVisited[v] = true;
		System.out.print(this.vertices.get(v) + " ");
		for(Integer n : this.neighbors.get(v))
			if(!isVisited[n]) 
				this.DFS(n, isVisited);
	}
	
	public static void main(String[] args) {
		BFSAndDFS g = new BFSAndDFS();
		g.addVertex("1");
		g.addVertex("2");
		g.addVertex("3");
		g.addVertex("4");
		g.addVertex("5");
		g.addVertex("7");
		g.addEdge("1", "5");
		g.addEdge("1", "3");
		g.addEdge("3", "5");
		g.addEdge("5", "4");
		g.addEdge("5", "2");
		g.addEdge("2", "7");
		g.display();
		System.out.print("BFS: ");
		g.BFS();
		System.out.print("DFS: ");
		g.DFS(0, new boolean[g.vertices.size()]);
	}

}

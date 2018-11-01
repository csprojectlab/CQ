package graphadjacency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ShortestPathUsingBFS extends Graph {
	int[] path;
	int[] distance;
	public ShortestPathUsingBFS() {
		super();
	}
	
	public void findShortestPathBFS(String v) {
		int index = this.vertices.indexOf(v);
		this.path = new int[this.vertices.size()];
		this.distance = new int[this.vertices.size()];
		
		this.findShortestPathBFS(index);
		
		Stack<Integer> stack = new Stack<Integer>();
		int currentIndex = index;
		while(currentIndex != -1) {
			stack.push(currentIndex);
			currentIndex = this.path[currentIndex];
		}
		while(!stack.isEmpty())
			System.out.print(this.vertices.get(stack.pop()) + " ");
		System.out.println();
	}
	
	private void findShortestPathBFS(int dest) {
		Queue<Integer> queue = new LinkedList<>();
		boolean isVisited[] = new boolean[this.vertices.size()];
		queue.add(0);  // first vertex.
		isVisited[0] = true;
		this.path[0] = -1;
		this.distance[0] = 0;
		while(!queue.isEmpty()) {
			int v = queue.remove();
			for(Integer n : this.neighbors.get(v)) {
				if(!isVisited[n]) {
					isVisited[n] = true;
					queue.add(n);
					this.path[n] = v;
					this.distance[n] = 1 + this.distance[v];
					if(n == dest)
						return;
				}
			}
		}
				
	}

	public static void main(String[] args) {
		ShortestPathUsingBFS g = new ShortestPathUsingBFS();
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
		g.findShortestPathBFS("7");
	}

}

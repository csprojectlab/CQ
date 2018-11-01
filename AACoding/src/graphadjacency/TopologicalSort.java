package graphadjacency;

import java.util.Stack;

public class TopologicalSort extends DirectedGraph {

	public TopologicalSort() {
		super();
	}

	public void topologicalSort() {
		Stack<Integer> stack = new Stack<Integer>();
		boolean isVisited[] = new boolean[this.vertices.size()];
		for(int v = 0; v < this.vertices.size(); v++)
			if(!isVisited[v])
				this.sortDFS(v, isVisited, stack);
		while(!stack.isEmpty()) 
			System.out.print(this.vertices.get(stack.pop()) + " ");
	}
	
	public void sortDFS(int v, boolean[] isVisited, Stack<Integer> stack) {
		isVisited[v] = true;
		for(Integer n : this.neighbors.get(v)) {
			if(!isVisited[n]) {
				this.sortDFS(n, isVisited, stack);
			}
		}
		stack.push(v);
	}
	
	public static void main(String[] args) {
		// The graph should be directed and acyclic.
		TopologicalSort g = new TopologicalSort();
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		g.addVertex("f");
		g.addVertex("g");
		g.addVertex("h");
		
		g.addEdge("a", "c");
		g.addEdge("b","c");
		g.addEdge("b","d");
		g.addEdge("c","e");
		g.addEdge("d","f");
		g.addEdge("e","h");
		g.addEdge("e","f");
		g.addEdge("f","g");
		
		g.display();
		System.out.print("Topological Sort: ");
		g.topologicalSort();
	}
}

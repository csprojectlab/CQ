package graphadjacency;

import java.util.LinkedList;
import java.util.Queue;


public class MinimumNumberOfEdges extends Graph {
	int minNumberOfEdges;
	public MinimumNumberOfEdges() {
		super();
		this.minNumberOfEdges = 0;
	}

	public int findMinEdges(String v1, String v2) {
		int index1 = this.vertices.indexOf(v1);
		int index2 = this.vertices.indexOf(v2);
		if(index1 == -1 || index2 == -1)
			return -1;
		return this.findMinEdgesBFS(index1, index2);		
	}
	
	public int findMinEdgesBFS(int s, int d) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		boolean isVisited[] = new boolean[this.vertices.size()];
		isVisited[s] = true;
		while(!queue.isEmpty()) {	
			this.minNumberOfEdges++;
			int size = queue.size();
			while(size-- > 0) {
				int v = queue.remove();
				for(Integer n : this.neighbors.get(v)) {
					if(!isVisited[n]) {
						isVisited[n] = true;
						queue.add(n);
						if(n == d)
							return this.minNumberOfEdges;
					}
				}
			}
		}
		return this.minNumberOfEdges;
	}
	

	public static void main(String[] args) {
		MinimumNumberOfEdges g = new MinimumNumberOfEdges();
		g.addVertex("ashish");
    	g.addVertex("shraddha");
    	g.addVertex("vanisha");
    	g.addVertex("aridaman");	
    	g.addVertex("uttkarsh");
    	g.addVertex("vikas");
    	g.addEdge("ashish", "uttkarsh");
    	g.addEdge("ashish", "vanisha");
    	g.addEdge("vanisha", "uttkarsh");
    	g.addEdge("uttkarsh", "aridaman");
    	g.addEdge("uttkarsh", "shraddha");
    	g.addEdge("shraddha", "vikas");
    	g.display();
    	System.out.println(g.findMinEdges("vikas", "vanisha"));
    	

	}

}

package graphadjacency;

import java.util.LinkedList;
import java.util.List;

public class TopologicalSortAll extends DirectedGraph {
	public int count = 0;
	public TopologicalSortAll() {
		// TODO Auto-generated constructor stub
	}

	public int[] getIndegree() {
		int[] result = new int[this.vertices.size()];
		for(int i = 0; i < this.vertices.size(); i++) {
			for(Integer n : this.neighbors.get(i)) {
				result[n]++;
			}
		}		
		return result;
	}
	
	public void allTopologicalSort() {
		int[] indegree = this.getIndegree();
		this.allTopologicalSort(new boolean[this.vertices.size()], indegree, new LinkedList<>());
	}
	
	public void allTopologicalSort(boolean[] visited, int[] indegree, List<String> result) {
		boolean flag = false;
		for(int i = 0; i < this.vertices.size(); i++) {  // For every vertex at this point.
			if(indegree[i] == 0 && !visited[i]) {   // Indegree is zero and is not visited.
				visited[i] = true; 
				for(Integer n : this.neighbors.get(i)) // For each neighbor.
					indegree[n]--;
				result.add(this.vertices.get(i));  // add it to the space tree.
				this.allTopologicalSort(visited, indegree, result);  // find more sorts from this branch.
				
				for(Integer n : this.neighbors.get(i)) // For each neighbor.
					indegree[n]++;  // reset.
				visited[i] = false;
				result.remove(result.size()-1);  // remove the vertex from the branch.
				flag = true;  // To state that this is not the end point.
			}
		}
		if(!flag) {
			this.count++;
			System.out.println(result);
		}
	}
	
	public static void main(String[] args) {
		TopologicalSortAll g = new TopologicalSortAll();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
//		g.addVertex("F");
		
		g.addEdge("A", "B");
		g.addEdge("B", "C");
		g.addEdge("D", "E");
		g.addEdge("E", "C");
//		g.addEdge("E", "F");
		
		g.display();
		g.allTopologicalSort();
		System.out.println("Total number of topological sorts: " + g.count);
		
	}

}

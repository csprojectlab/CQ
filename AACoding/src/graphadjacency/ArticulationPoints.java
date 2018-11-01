package graphadjacency;

import java.util.HashSet;
import java.util.Set;


// Still to do some work on starting vertex conditions.
public class ArticulationPoints extends Graph {
	public int timer = 0;
	public ArticulationPoints() {
		// TODO Auto-generated constructor stub
	}

	public Set<String> getArticulationPoints() {
		int[] disc = new int[this.vertices.size()];
		int[] low = new int[this.vertices.size()];
		Set<String> result = new HashSet<>();
		boolean[] visited = new boolean[this.vertices.size()];
		this.getArticulationPoints(3, disc, low, result, visited, -1);
		for(int i = 0; i < disc.length; i++)
			System.out.println(this.vertices.get(i) + ": " + disc[i] + " : " + low[i]);
		System.out.println(result);
		return null;
	}
	
	public void getArticulationPoints(int v, int[] disc, int[] low, Set<String> result, boolean[] visited, int parent) {
		System.out.println("Visiting: " + this.vertices.get(v));
		visited[v] = true;
		disc[v] = timer;   // reaching time.
		low[v] = timer;   // to designate the lowest reachable vertex.
		timer++;
		for(Integer n : this.neighbors.get(v)) {
			if(!visited[n]) {  // if it is not visited.
				this.getArticulationPoints(n, disc, low, result, visited, v);  // calculate ap's from this vertex.
				if(low[n] >= disc[v])  // if neighbor n can't reach lower vertex than v then v becomes ap for it.
					result.add(this.vertices.get(v));  // add it to the result.
				else       // neighbor n can reach lower than vertex v. Therefore update vertex v's lower as well.
					low[v] = low[n];
			} else if(n != parent && low[n] < low[v]) {  // n is already visited and can reach lower vertex than v. Update.
				low[v] = low[n];
			}
		}
	}
	
	public static void main(String[] args) {
		ArticulationPoints g= new ArticulationPoints();
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		g.addVertex("f");
		g.addVertex("g");
		g.addVertex("h");
		
		g.addEdge("a", "b");
		g.addEdge("a", "c");
		g.addEdge("b", "c");
		g.addEdge("c", "d");
		g.addEdge("d", "e");
		g.addEdge("e", "f");
		g.addEdge("e", "g");
		g.addEdge("f", "g");
		g.addEdge("f", "h");

		g.display();
		g.getArticulationPoints();
	}
}

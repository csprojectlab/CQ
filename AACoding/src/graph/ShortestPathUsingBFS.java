package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class ShortestPathUsingBFS extends Graph {
	public Map<String, String> path; // path matrix
	public Map<String, Integer> distance;  // distance matrix.
	public ShortestPathUsingBFS() {
		super();		
	}
	public void reset() {
		this.path = new HashMap<String, String>();
		this.distance = new HashMap<String, Integer>();
	}
	
	public int countNumberOfPaths(String source, String destination) {
		this.searchPaths(source, destination);
		Integer dist = this.distance.get(destination);
		if(dist == null)
			return -1;
		return dist;
	}
	
	public String printPath(String source, String destination) {		
		this.searchPaths(source, destination);
		if(this.path.get(destination) == null)
		  return null;
		StringBuffer result = new StringBuffer("");
		Stack<String> stack = new Stack<String>();
		String currentVertex = this.path.get(destination);
		stack.push(destination);
		while(currentVertex != null) {
			stack.push(currentVertex);
			currentVertex = this.path.get(currentVertex);
		}
		while(!stack.isEmpty())
		  result.append(stack.pop() + " ");
		return result.toString();
	}
	
	public void searchPaths(String s, String d) {  // Using bfs.
		this.reset();
		Vertex v = this.vertices.get(s);
		Queue<Vertex> queue = new LinkedList<Vertex>();
		Set<String> isVisited = new HashSet<String>();
		isVisited.add(s);
		queue.add(v);
		this.path.put(s, null);   // Symbolizing null value.
		this.distance.put(s, 0);   // Distance from source to source.
		while(!queue.isEmpty()) {
			Vertex vertex = queue.remove();
			Set<Vertex> neighbors = vertex.neighbors.keySet();
			for(Vertex neighbor : neighbors) {
				if(!isVisited.contains(neighbor.name)) {
					isVisited.add(neighbor.name);
					queue.add(neighbor);
					this.path.put(neighbor.name, vertex.name);   // neighbor can be reached by this vertex.
					this.distance.put(neighbor.name, this.distance.get(vertex.name) + 1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		
	}
	
}

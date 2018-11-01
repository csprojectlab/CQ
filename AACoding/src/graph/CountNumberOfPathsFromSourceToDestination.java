package graph;

import java.util.HashSet;
import java.util.Set;

class Data {
	int count = 0;
}

public class CountNumberOfPathsFromSourceToDestination extends Graph {

	public CountNumberOfPathsFromSourceToDestination() {
		super();
	}
	
	public int countPaths(String s, String d) {
		Data data = new Data();
		Set<String> set = new HashSet<String>();
		this.countPaths(s, d, data, set);
		return data.count;
	}
	
	public void countPaths(String source, String destination, Data count, Set<String> isVisited) {
		Vertex v = this.vertices.get(source);
		Set<Vertex> neighbors = v.neighbors.keySet();
		if(neighbors == null)
			return;
		isVisited.add(source);
		for(Vertex neighbor : neighbors) {
			if(!isVisited.contains(neighbor.name)) {
				if(neighbor.name.equals(destination))
					count.count++;
			    else
				    this.countPaths(neighbor.name, destination, count, isVisited);
			}
		}
		isVisited.remove(source);
	}
	
	public void showPaths(String s, String d) {
		this.showPaths(s, d, new HashSet<String>(), new String(s));
	}
	
	public void showPaths(String source, String destination, Set<String> isVisited, String output) {
		Vertex v = this.vertices.get(source);
		Set<Vertex> neighbors = v.neighbors.keySet();
		if(neighbors == null)
			return;
		isVisited.add(source);
		for(Vertex neighbor : neighbors) {
			if(!isVisited.contains(neighbor.name)) {
				if(neighbor.name.equals(destination)) 
					System.out.println(output + " => " + destination);
				else
					this.showPaths(neighbor.name, destination, isVisited, output + " => " + neighbor.name);				
			}
		}		
		isVisited.remove(source);
	}
	
	public static void main(String[] args) {
		CountNumberOfPathsFromSourceToDestination g = new CountNumberOfPathsFromSourceToDestination();
		g.addVertex("1");
    	g.addVertex("2");
    	g.addVertex("3");
    	g.addVertex("4");	
    	g.addVertex("5");
    	g.addVertex("7");
    	g.addEdge("1", "5", 10);
    	g.addEdge("1", "3", 40);
    	g.addEdge("3", "5", 10);
    	g.addEdge("5", "4", 10);
    	g.addEdge("5", "2", 2);
    	g.addEdge("2", "7", 12);
    	System.out.println("Paths from 3 to 4: " + g.countPaths("3", "4"));
    	System.out.println("Paths: ");
    	g.showPaths("3", "4");
	}
}

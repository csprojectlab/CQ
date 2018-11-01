package graphadjacency;

import java.util.LinkedList;
import java.util.List;

public class GraphWeightedUndirected extends GraphWeighted {

	public GraphWeightedUndirected() {
		super();
	}
	
	public List<Edge> getAllEdges() {
		List<Edge> edgeList = new LinkedList<>();
		for(List<Edge> el : this.neighbors) {
			for(Edge e : el) {
				if(!edgeList.contains(new Edge(e.v, e.u, 0))) {  
					edgeList.add(e);
				}					
			}
		}
		return edgeList;
	}
	
	public static void main(String[] args) {
		GraphWeightedUndirected g = new GraphWeightedUndirected();
		g.addVertex("0");
		g.addVertex("1");
		g.addVertex("2");
		g.addVertex("3");
		
		g.addEdge("0", "1", 1);
		g.addEdge("1", "2", 3);
		g.addEdge("2", "3", 2);
		g.addEdge("3", "1", -6);
		g.display();
		System.out.println("Edge List: " + g.getAllEdges());
	}


}

package graphadjacency;

public class GraphWeightedDirected extends GraphWeighted {

	public GraphWeightedDirected() {
		super();
	}
	
	public void addEdge(Object v1, Object v2, int cost) {
		int index1 = this.vertices.indexOf(v1);
		int index2 = this.vertices.indexOf(v2);
		if(index1 == -1 || index2 == -1)
			return;
		if(this.neighbors.get(index1).contains(index2))
			return;
		this.neighbors.get(index1).add(new Edge(index1, index2, cost));
	}

}

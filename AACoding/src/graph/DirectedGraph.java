package graph;

public class DirectedGraph extends Graph {

	public DirectedGraph() {
		super();
	}

	public void addEdge(String vname1, String vname2, int cost) {		
		Vertex v1 = this.vertices.get(vname1);
		Vertex v2 = this.vertices.get(vname2);
		if(v1 == null || v2 == null || v1.neighbors.containsKey(v2)) {
			System.out.println("(" + vname1 + "," + vname2 + ")" + ": DUPLICATE EDGE.");
			return;
		}
		v1.neighbors.put(v2, cost);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

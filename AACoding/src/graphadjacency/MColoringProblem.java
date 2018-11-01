package graphadjacency;

//  We didn't use dfs or bfs here because then we have to keep the check of visited vertices as well.
// So we approach vertex by vertex.
public class MColoringProblem extends Graph {
	public String colorList[] = {"RED", "GREEN", "BLUE", "WHITE"};
	public MColoringProblem() {
		// TODO Auto-generated constructor stub
	}

	public boolean isSafe(int v, int m, int[] color) {
		for(Integer n : this.neighbors.get(v)) {
			if(color[n] == m)   // Color of vertex v and neighbor is same.
				return false;
		}
		return true;
	}
	
	public boolean colorGraph(int v, int[] vertexColors, int numberOfColors) {
		if(v == this.vertices.size())  // All the vertices have been colored.
			return true;
		for(int m = 0; m < numberOfColors; m++) {  // Try each color.
			vertexColors[v] = m;   // Color the vertex.
			if(this.isSafe(v, m, vertexColors) && this.colorGraph(v+1, vertexColors, numberOfColors))
				return true;
			vertexColors[v] = -1;   // reset.  Go back in space tree.
		}		
		return false;  // After trying all the colors still not colored.
	}
	
	public boolean colorGraph(int colors) {
		int[] color = new int[this.vertices.size()];
		for(int i = 0; i < color.length; i++)
			color[i] = -1;
		// Here a loop should come.
		System.out.println(this.colorGraph(0, color, colors));  // Graph is colored or not.
		for(int i = 0; i < color.length; i++) {
			System.out.println(this.vertices.get(i) + ": " + this.colorList[color[i]]);
		}
		return true;  // Just a dummy.
		
	}
	
	public static void main(String[] args) {
		MColoringProblem g = new MColoringProblem();
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		g.addVertex("f");
		g.addVertex("g");
		g.addVertex("h");
		g.addVertex("i");
		g.addVertex("j");
		
		g.addEdge("a", "b");
		g.addEdge("a", "f");
		g.addEdge("a", "e");
		g.addEdge("b", "c");
		g.addEdge("b", "g");
		g.addEdge("c", "d");
		g.addEdge("c", "h");
		g.addEdge("d", "i");
		g.addEdge("d", "e");
		g.addEdge("e", "j");
		g.addEdge("f", "h");
		g.addEdge("f", "i");
		g.addEdge("g", "i");
		g.addEdge("g", "j");
		g.addEdge("h", "j");
		g.display();
		System.out.println("Graph is colorable: " + g.colorGraph(3));
	}

}

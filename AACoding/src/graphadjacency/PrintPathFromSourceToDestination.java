package graphadjacency;


public class PrintPathFromSourceToDestination extends Graph {
	int numberOfPaths;
	public PrintPathFromSourceToDestination() {
		super();
		this.numberOfPaths = 0;
	}

	public void printPaths(String s, String d) {
		int si = this.vertices.indexOf(s);
		int di = this.vertices.indexOf(d);
		this.printPathsDFS(si, di, new boolean[this.vertices.size()], this.vertices.get(si));
	}
	
	public void printPathsDFS(int s, int d, boolean[] isVisited, String out) {
		isVisited[s] = true;
		for(Integer n : this.neighbors.get(s)) {   // For all the neighbors.
			if(!isVisited[n]) {
				if(n == d) {
					this.numberOfPaths++;
					System.out.println(out + " => " + this.vertices.get(d));
				}
				else
					this.printPathsDFS(n, d, isVisited, out + " => " + this.vertices.get(n));				
			}
		}
		isVisited[s] = false;
	}

	public static void main(String[] args) {
		PrintPathFromSourceToDestination g = new PrintPathFromSourceToDestination();
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
    	
    	g.printPaths("vikas", "vanisha");
    	System.out.println("Number of ways: " + g.numberOfPaths);
    	g.display();
	}

}

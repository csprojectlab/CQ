package graphadjacency;


public class CyclesOfLenghN extends Graph {
	public int count = 0;
	public CyclesOfLenghN() {
		// TODO Auto-generated constructor stub
	}
	
	public void printCyclesOfLenghtN(int n) {
		boolean[] visited = new boolean[this.vertices.size()];
		int rounds = this.vertices.size() - (n - 1);
		for(int i = 0; i < rounds; i++) {
			this.printCyclesOfLenghtNDFS(i, i, n-1, visited, "");
			visited[i] = true;  // Don't consider this vertex in next rounds.
		}
		System.out.println("Number of unique cycles of length " + n + ": " + this.count/2);   // Because every cycle is counted twice.
	}
	
	public void printCyclesOfLenghtNDFS(int v, int start, int N, boolean[] visited, String out) {
		visited[v] = true;
		if(N == 0) {  // I have moved to length N
			visited[v] = false;
			if(this.neighbors.get(v).contains(start)) {
				this.count++;
				System.out.println(out + this.vertices.get(v) + "-" + this.vertices.get(start));
			}
			return;
		}
			
		for(Integer n : this.neighbors.get(v)) 
			if(!visited[n]) 
				this.printCyclesOfLenghtNDFS(n, start, N-1, visited, out + this.vertices.get(v) + "-");
		visited[v] = false;
	}
	
	public static void main(String[] args) {
		CyclesOfLenghN g = new CyclesOfLenghN();
		g.addVertex("0");
		g.addVertex("1");
		g.addVertex("2");
		g.addVertex("3");
		g.addVertex("4");
		
		g.addEdge("0", "1");
		g.addEdge("0", "3");
		g.addEdge("1", "2");
		g.addEdge("1", "4");
		g.addEdge("2", "3");
		g.addEdge("3", "4");
//		g.addEdge("0", "4");  This edge will increase the number of cycles of length 5.
		g.display();
		g.printCyclesOfLenghtN(4);
	}

}

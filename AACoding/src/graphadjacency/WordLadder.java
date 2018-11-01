package graphadjacency;

import java.util.LinkedList;
import java.util.Queue;

public class WordLadder extends Graph{
	int[] parent;
	int[] distance;
	public WordLadder() {
		
	}
	
	public void findPathBFS(String s, String d) {
		this.parent = new int[this.vertices.size()];
		this.distance = new int[this.vertices.size()];
		boolean[] visited = new boolean[this.vertices.size()];
		Queue<Integer> queue = new LinkedList<>();
		int si = this.vertices.indexOf(s);
		int di = this.vertices.indexOf(d);		
		queue.add(si);
		this.parent[si] = -1;
		this.distance[si] = 0;
		visited[si] = true;
		while(!queue.isEmpty()) {
			int v = queue.remove();
			for(Integer n : this.neighbors.get(v)) {
				if(!visited[n]) {
					visited[n] = true;
					this.parent[n] = v;
					this.distance[n] = 1 + this.distance[v];
					queue.add(n);
				}
			}
		}
		System.out.println("Distance to reach: " + (this.distance[di]+1));
		int count = this.distance[di];
		int current = di;
		// Implement the stack for result. I have not implemented.
		while(count-- > 0) {
			System.out.print(this.vertices.get(current) + " -> ");
			current = this.parent[current];
		}
		System.out.println(this.vertices.get(si));
		
	}
	
	private boolean differByOne(String first, String second) {
		int count = 0;
		for(int i = 0; i < first.length(); i++)
			if(first.charAt(i) != second.charAt(i))
				count++;
		return count == 1;
	}
	
	public static void main(String[] args) {
		String[] dictionary = {"POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN", "TOON"};
		String start = "TOON";
		String end = "PLEA";
		
		WordLadder g = new WordLadder();
		for(String s : dictionary)
			g.addVertex(s);
		for(int i = 0; i < dictionary.length; i++) 
			for(int j = i+1; j < dictionary.length; j++)
				if(g.differByOne(dictionary[i], dictionary[j])) 
					g.addEdge(dictionary[i], dictionary[j]);
		g.findPathBFS(start, end);
	}

}

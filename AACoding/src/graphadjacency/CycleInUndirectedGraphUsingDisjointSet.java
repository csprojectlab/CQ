package graphadjacency;

import disjointsets.DisjointSet;
import disjointsets.Node;

public class CycleInUndirectedGraphUsingDisjointSet<K> extends DisjointSet<K> {
    boolean found;
	public CycleInUndirectedGraphUsingDisjointSet() {
    	super();
    	this.found = false;
    }
    
    // returns true if new edge adds a cycle in the graph.
    public K joinSet(K v1, K v2) {
		int index1 = this.forest.indexOf(new Node<K>(v1, 0));
		int index2 = this.forest.indexOf(new Node<K>(v2, 0));
		if(index1 == -1 || index2 == -1)
			return null;
		Node<K> set1 = this.forest.get(index1);
		Node<K> set2 = this.forest.get(index2);
		Node<K> rootSet1 = this.findSet(set1);
		Node<K> rootSet2 = this.findSet(set2);
		if(rootSet1.equals(rootSet2)) 
			this.found = true;
		if(set1.rank >= set2.rank) {  // Use set1 as root
			set1.rank++;
			set2.rank = 0;			
			rootSet2.parent = rootSet1;
			set2.parent = rootSet1;   // applying compression.
			return rootSet1.data;
		} else {  // Use set2 as root.
			set2.rank++;
			set1.rank = 0;
			rootSet1.parent = rootSet2;
			set1.parent = rootSet1;  // compression.
			return rootSet2.data;
		}
	}

	// The graph a b c d e f contains a cycle.
	public static void main(String[] args) {
		
		CycleInUndirectedGraphUsingDisjointSet<Integer> g = new CycleInUndirectedGraphUsingDisjointSet<>();
		// Duplicate edges should not be provided.
		int[][] edges = {{0,1},{0,2},{0,3},
                {1,2},{1,4},
                {2,3}                
		         };
		for(int i = 0; i < edges.length; i++)
			g.makeSet(i);
		for(int row = 0; row < edges.length; row++) {
			g.joinSet(edges[row][0], edges[row][1]);
			if(g.found) {
				System.out.println("Cycle exist in the graph.");
				break;
			}
		}
	}
}

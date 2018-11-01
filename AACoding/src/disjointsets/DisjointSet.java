package disjointsets;

import java.util.LinkedList;

// Each set is represented using a node.
// Every value of linked list is treated as a set.

public class DisjointSet<K> {
	public LinkedList<Node<K>> forest;
	public DisjointSet() {
		this.forest = new LinkedList<Node<K>>();
	}
		
	public void makeSet(K setValue) {
		Node<K> set = new Node<>(setValue, 0);  // by default parent is the node itself.
		this.forest.add(set);
	}
	
	public K findSet(K setValue) {
		return this.findSet(this.forest.get(this.forest.indexOf(new Node<K>(setValue,0)))).data;
	}
	
	public Node<K> findSet(Node<K> set) {
		Node<K> root = set;
		while(!root.parent.equals(root)) 
			root = root.parent;
		set.parent = root;  // applying compression.
		return root;
	}

	public K joinSet(K v1, K v2) {
		int index1 = this.forest.indexOf(new Node<K>(v1, 0));
		int index2 = this.forest.indexOf(new Node<K>(v2, 0));
		if(index1 == -1 || index2 == -1)
			return null;
		Node<K> set1 = this.forest.get(index1);
		Node<K> set2 = this.forest.get(index2);
		Node<K> rootSet1 = this.findSet(set1);
		Node<K> rootSet2 = this.findSet(set2);
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
	
	public static void main(String[] args) {
		DisjointSet<Integer> ds = new DisjointSet<>();
		ds.makeSet(1);
		ds.makeSet(2);
		ds.makeSet(3);
		ds.makeSet(4);
		ds.makeSet(5);
		ds.makeSet(6);
		ds.makeSet(7);
		
		ds.joinSet(1, 2);
		ds.joinSet(2,3);
		ds.joinSet(4, 5);
		ds.joinSet(5, 6);
		ds.joinSet(6, 7);
		ds.joinSet(3,7);
		System.out.println(ds.forest);
		
		// Compression testing.
		System.out.println("After compression testing: ");
		ds.findSet(5);  // this is the index of set5. After this parent will change to 1.
		System.out.println(ds.forest);  // Compression test passed.
	}

}

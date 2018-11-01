package disjointsets;

// This is a specific node for the disjoint sets.

public class Node<K> {
	public K data;
	public int rank;
	public Node<K> parent;
	public Node() {}
	public Node(K data, int rank) {
		this.data = data;
		this.rank = rank;
		this.parent = this;
	}
	
	public boolean equals(Object o) {
		@SuppressWarnings("unchecked")
		Node<K> other = (Node<K>)o;
		return this.data.equals(other.data);
	}
	
	public String toString() {
		return "{Node: " + this.data.toString() + " Parent: " + this.parent.data.toString() + "}";
	}

}

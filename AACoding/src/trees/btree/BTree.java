package trees.btree;

import java.util.LinkedList;
import java.util.Queue;
// Comment added from another side.
class Node {
	int[] keys;
	int n;   // Current number of keys
	int order;   
	boolean leaf;
	Node[] children;
	public Node() {}
	public Node(int order, boolean leaf) {
		this.order = order;
		this.leaf = leaf;
		// Allocate memory.
		this.keys = new int[order - 1];
		this.children = new Node[order];
		// Initialize the number of keys
		this.n = 0;
	}
	
	public void insertInNonFullNode(int key) {
		int i = n - 1;   // Index of right-most element.
		if(this.leaf) {
			// Find the location of new key to be inserted.
			while(i >= 0 && key < this.keys[i]) {
				this.keys[i+1] = this.keys[i];
				i--;
			}
			this.keys[i+1] = key;
			this.n++;
		} else {  // Non leaf node need to be split.
			// Find the child which is going to have new key
			while(i >= 0 && key < this.keys[i])
				i--;
			// See if the found child is full.
			if(this.children[i+1].n == this.children[i+1].order - 1) {
				// If child is full then split it.
				this.splitChild(i+1, this.children[i+1]);
				if(key > this.keys[i+1])
					i++;
			} 
			this.children[i+1].insertInNonFullNode(key);
		}
	}
	/*
	 * Node is full when this function is called.
	 */
	public void splitChild(int i, Node node) {
		// Calculate the mid.
		int t = (node.order - 1) >> 1;
		Node z = new Node(node.order, node.leaf);
		z.n = node.n - t - 1;
		// Copy the keys next to mid.
		for(int j = 0; j < t; j++)
			z.keys[j] = node.keys[j + t + 1];
		// Copy the children
		if(!node.leaf) {
			for(int j = 0; j < t + 1; j++)
				z.children[j] = node.children[j + t + 1];
		}
		// Reduce the number of keys in node.
		node.n = t;
		// Create space for the new child.
		for(int j = this.n; j >= i+1; j--)
			this.children[j+1] = this.children[j];
		// Link the new node.
		this.children[i+1] = z;
		// Move the keys 
		for(int j = n - 1; j >= i; j++)
			this.keys[j+1] = this.keys[j];
		// Copy the middle key
		this.keys[i] = node.keys[t];
		this.n++;		
	}
	
	public void display() {
		System.out.print("[ ");
		for(int i = 0; i < this.n; i++)
			System.out.print(this.keys[i] + " ");
		System.out.print("]");
	}
	
	public String toString() {
		return "Order: " + this.order + ", KeyCount: " + this.n + ", Leaf: " + this.leaf;
	}
}

public class BTree {
	Node root;
	int order;
	public BTree() {		
		this(6);   // Default order		
	}
	public BTree(int order) {
		this.root = null;
		this.order = order;
	}
	
	public void insert(int key) {
		if(this.root == null) {  // If tree is empty
			this.root = new Node(this.order, true);
			this.root.keys[0] = key;
			this.root.n = 1;
		} else {   // If tree is not empty.
			// If root is full tree grow in height.
			if(this.root.n == this.root.order - 1) {
				// Allocate memory for new root.
				Node newRoot = new Node(this.order, false);
				// Make old root as child of new root.
				newRoot.children[0] = this.root;
				newRoot.splitChild(0, this.root);     // Split the root.
				// new root has two children. Decide which one will have the key.
				int i = 0;
				if(key > newRoot.keys[0])
					i++;
				newRoot.children[i].insertInNonFullNode(key);
				this.root = newRoot;
			} else {  // Root is not full. Insert in the root.
				this.root.insertInNonFullNode(key);
			}
			
		}
	}
	
	public void displayBFS() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(this.root);
		while(!queue.isEmpty()) {
			Node node = queue.remove();
			node.display();
			if(!node.leaf) {
				for(int i = 0; i <= node.n; i++)
					if(node.children[i] != null)
						queue.add(node.children[i]);
			}
		}
	}
	
	public void displayLevelByLevel() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(this.root);
		int level = 1;
		while(!queue.isEmpty()) {
			System.out.print("LEVEL " + (level++) + ": ");
			int size = queue.size();
			while(size-- > 0) {
				Node node = queue.remove();
				node.display();
				if(!node.leaf) {
					for(int i = 0; i <= node.n; i++)
						if(node.children[i] != null)
							queue.add(node.children[i]);
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		BTree t = new BTree(4);
		for(int i = 100; i <= 800; i += 100)
			t.insert(i);
		t.displayLevelByLevel();
	}
}

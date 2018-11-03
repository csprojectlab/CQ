package tree.avl;

class Node {
	int data;
	int height;
	Node left;
	Node right;
	public Node(int data) {
		this.data = data;
		this.height = 1;
	}
	public String toString() {
		return this.data + "";
	}
}

public class AVL {
	Node root = null;
	
	public int height(Node node) {
		if(node == null)
			return 0;
		return node.height;
	}
	
	// Get the balance factor of node n.
	public int getBalance(Node node) {
		if(node == null)
			return 0;
		return this.height(node.left) - this.height(node.right);
	}
	
	public Node rotateRight(Node node) {
		Node leftTree = node.left;
		Node T = leftTree.right;
		// Performing the rotation.
		leftTree.right = node;
		node.left = T;
		// Update the heights
		leftTree.height = Math.max(this.height(leftTree.left), this.height(leftTree.right)) + 1;
		node.height = Math.max(this.height(node.left), this.height(node.right)) + 1;

		// Return the new root.
		return leftTree;		
	}
	
	public Node rotateLeft(Node node) {
		Node rightTree = node.right;
		Node T = rightTree.left;
		// Perform the rotation.
		rightTree.left = node;
		node.right = T;
		// Update the heights
		rightTree.height = Math.max(this.height(rightTree.left), this.height(rightTree.right)) + 1;
		node.height = Math.max(this.height(node.left), this.height(node.right)) + 1;
		// Return the new root.
		return rightTree;
	}
	
	public Node insert(Node node, int data) {
		/*
		 * 1). Follow the standard BST procedure to insert.
		 */
		if(node == null)
			return new Node(data);
		else if(data < node.data)
			node.left = this.insert(node.left, data);
		else if(data > node.data)
			node.right = this.insert(node.right, data);
		else   // Duplicate keys not allowed.
			return node;
		/*
		 * 2). Update the height of this ancestor node.[height of the subtree]
		 */
		node.height = 1 + Math.max(this.height(node.left), this.height(node.right));
		/*
		 * 3). Get the balance factor of this node by checking whether this node became 
		 * unbalanced.
		 */
		int balance = this.getBalance(node);
		/*
		 * If this node becomes unbalanced then there are 4 cases.
		 */
		// Left Left Case.
		if(balance > 1 && data < node.left.data) 
			return this.rotateRight(node);    // Return the rotated tree.
		// Right Right case
		if(balance < -1 && data > node.right.data)
			return this.rotateLeft(node); 
		// Left Right case
		if(balance > 1 && data > node.left.data) {
			node.left = this.rotateLeft(node.left);
			return this.rotateRight(node);
		}
		// Right Left case.8
		if(balance < -1 && data < node.right.data) {
			node.right = this.rotateRight(node.right);
			return this.rotateLeft(node);
		}
		// Return the unchanged node.
		return node;
	}
	
	public void preOrder(Node node) {
		if(node == null)
			return;
		System.out.print(node.data + " ");
		if(node.left != null) 
			this.preOrder(node.left);
		if(node.right != null)
			this.preOrder(node.right);
	}
	
	public static void main(String[] args) {
		AVL tree = new AVL();
		tree.root = tree.insert(tree.root, 13);
		tree.root = tree.insert(tree.root, 10);
//		tree.root = tree.insert(tree.root, 15);
		tree.root = tree.insert(tree.root, 5);
		tree.root = tree.insert(tree.root, 4);
		System.out.println(tree.root.data);
//		tree.root = tree.insert(tree.root, 11);
//		tree.root = tree.insert(tree.root, 15);
//		tree.root = tree.insert(tree.root, 16);
//		tree.root = tree.insert(tree.root, 4);
//		tree.root = tree.insert(tree.root, 6);
//		tree.root = tree.insert(tree.root, 7);
		tree.preOrder(tree.root);
	}
}

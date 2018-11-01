package trees;

public class BinarySearchTree {
	Node root;
	int size;
	public BinarySearchTree() {
		this.root = null;
		this.size = 0;
	}
	
	public void add(int data) {
		if(this.root == null) {
			this.root = new Node(data, null, null);
			this.size++;
		} else {
			Node temp = this.root;
			Node parent = null;
			while(temp != null) {
				parent = temp;
				if(data < temp.data)
					temp = temp.left;
				else if(data >= temp.data)
					temp = temp.right;
			}
			if(data < parent.data)
				parent.left = new Node(data, null, null);
			else if(data >= parent.data)
				parent.right = new Node(data, null, null);
			this.size++;			
		}
	}
	
	public void inOrder(Node node) {
		if(node == null)
			return;
		this.inOrder(node.left);
		System.out.print(node.data + " ");
		this.inOrder(node.right);
	}
	
	public int getHeight(Node node) {
		if(node.left == null && node.right == null)
			return 0;
		int leftAns = 0;
		int rightAns = 0;
		if(node.left != null)
			leftAns = this.getHeight(node.left);
		if(node.right != null)
			rightAns = this.getHeight(node.right);
		return 1 + Math.max(leftAns, rightAns);
			
	}
	
	public void display(Node node) {
		if(node.left != null)
			System.out.print(node.left.data + " => ");
		else
			System.out.print("END => ");
		System.out.print(node.data);
		if(node.right != null)
			System.out.print(" <= " + node.right.data);
		else
			System.out.print(" <= END");
		System.out.println();
		if(node.left != null)
			this.display(node.left);
		if(node.right != null)
			this.display(node.right);
	}
	
	public Node minNode(Node node) {
		if(node.left == null)
			return node;
		return this.minNode(node.left);
	}
	
	public Node delete(Node node, int data) {
		if(node == null)
			return null;
		if(data < node.data) {
			node.left = this.delete(node.left, data);
			return node;
		}
		else if(data > node.data) {
			node.right = this.delete(node.right, data);
			return node;
		}
		else {
			if(node.left == null && node.right == null) {  // Leaf node.
				return null;
			} else if(node.left == null) {  // Only has right child.
				return node.right;
			} else if(node.right == null) {  // Only has left child.
				return node.left;
			} else {  // Has both.
				Node minNodeFromRightTree = this.minNode(node.right);
				this.delete(node, minNodeFromRightTree.data);	
				node.data = minNodeFromRightTree.data;
				return node;
			}
		}		
	}
	
	public static void main(String[] args) {
		// 50 true 80 true 39 false false true 41 true 10 false false true 90 false false true 74 true 93 false false true 11 false false
		BinarySearchTree tree = new BinarySearchTree();
		tree.add(50);
		tree.add(80);
		tree.add(39);
		tree.add(23);
		System.out.println("Inorder traversal of the tree.");
		tree.inOrder(tree.root);
		System.out.println();
		tree.display(tree.root);
		System.out.println("Height of the tree is: " + tree.getHeight(tree.root));
		tree.root = tree.delete(tree.root, 39);
		tree.display(tree.root);
	}

}

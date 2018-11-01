package trees;

//A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes. 
//Conversely, there is no node in a full binary tree, which has one child node.

public class FullBinaryTreeOrNot extends BinaryTree {

	public FullBinaryTreeOrNot() {
		super();
	}

	public boolean isFullBinaryTree(Node node) {
		if(node.left == null && node.right == null) // zero children
			return true;
		if(node.left == null || node.right == null)  // Only one child.
			return false;
		return this.isFullBinaryTree(node.left) && this.isFullBinaryTree(node.right);
	}
	
	public static void main(String[] args) {
//		1 true 2 true 4 false false true 5 false false true 3 false false
		FullBinaryTreeOrNot t = new FullBinaryTreeOrNot();
		System.out.println("Is full binary tree: " + t.isFullBinaryTree(t.root));

	}

}

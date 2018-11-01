package trees;

public class BoundaryTraversalOfBinaryTree extends BinaryTree {
	public BoundaryTraversalOfBinaryTree() {
		super();
	}
	
	public void printLeftsideTopBottom(Node node) {
		while(node.left != null) {
			System.out.print(node.data + " ");
			node = node.left;
		}
	}
	
	public void printLeaves(Node node) {
		if(node.left == null && node.right == null) {
			System.out.print(node.data + " ");
			return;
		}
		if(node.left != null)
			this.printLeaves(node.left);
		if(node.right != null)
			this.printLeaves(node.right);
	}
	
	// This is made recursive for bottom up traversal.
	public void printRightsideBottomUp(Node node) {
		if(node.right == null)
			return;
		this.printRightsideBottomUp(node.right);
		System.out.print(node.data + " ");
	}
	
	// Anti-clockwise. Works on O(n)
	public void traversBoundary() {
		this.printLeftsideTopBottom(this.root);
		this.printLeaves(this.root);
		this.printRightsideBottomUp(this.root);
	}
	
	public static void main(String[] args) {
		// 50 true 80 true 39 false false true 41 true 10 false false true 90 false false true 74 true 93 false false true 11 false false
		BoundaryTraversalOfBinaryTree t = new BoundaryTraversalOfBinaryTree();
		System.out.println("Anti-clockwise boundary traversal of the tree: ");
		t.traversBoundary();
	}
}

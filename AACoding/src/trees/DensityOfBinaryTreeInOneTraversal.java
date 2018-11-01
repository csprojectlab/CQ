package trees;

//Density of Binary Tree = Size / Height 

public class DensityOfBinaryTreeInOneTraversal extends BinaryTree {
	int treeSize;
	public DensityOfBinaryTreeInOneTraversal() {
		super();
		this.treeSize = 0;
	}
	
	public int heightOfTree(Node node) {
		this.treeSize++;
		int leftHeight = 0;
		int rightHeight = 0;
		if(node.left != null)
			leftHeight = this.heightOfTree(node.left);
		if(node.right != null)
			rightHeight = this.heightOfTree(node.right);
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	public static void main(String[] args) {
		// 50 true 80 true 39 false false true 41 true 10 false false true 90 false false true 74 true 93 false false true 11 false false
		DensityOfBinaryTreeInOneTraversal t = new DensityOfBinaryTreeInOneTraversal();
		System.out.println("Height: " + t.heightOfTree(t.root) + " Tree Size: " + t.treeSize);
		System.out.println("Density: " + t.treeSize*1.0 / (t.heightOfTree(t.root)));
	}

}

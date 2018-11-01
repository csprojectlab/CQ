package trees;

public class LargestSumSubTree  extends BinaryTree {
	Node sumTreeRoot;
	int maxSum;
	public LargestSumSubTree() {
		super();
		this.sumTreeRoot = null;
		this.maxSum = Integer.MIN_VALUE;
	}
	
	public int findLargestSumSubTree(Node node) {
		if(node.left == null && node.right == null)
			return node.data;
		int leftSum = 0;
		int rightSum = 0;
		if(node.left != null)
			leftSum = this.findLargestSumSubTree(node.left);
		if(node.right != null)
			rightSum = this.findLargestSumSubTree(node.right);
		int treeSum = node.data + leftSum + rightSum;
		if(treeSum > this.maxSum) {
			this.maxSum = treeSum;
			this.sumTreeRoot = node;
		}
		return treeSum;
	}
	
	public static void main(String[] args) {
//		1 true -2 true 4 false false true 5 false false true 3 true -6 false false true 2 false false
		LargestSumSubTree t = new LargestSumSubTree();
		t.display(t.root);
		t.findLargestSumSubTree(t.root);
		System.out.println("Max Sum: " + t.maxSum + ". SubTree: ");
		t.display(t.sumTreeRoot);		
	}

}

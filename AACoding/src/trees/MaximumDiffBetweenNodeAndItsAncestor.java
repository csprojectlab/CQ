package trees;



public class MaximumDiffBetweenNodeAndItsAncestor extends BinaryTree {
	int maxDiff;
	public MaximumDiffBetweenNodeAndItsAncestor() {
		super();
		this.maxDiff = 0;
	}

	public int maxDiffBetweenNodeAndAnc(Node node) {
		if(node.left == null && node.right == null)
			return node.data;
		int sub = 0;
		int left = Integer.MAX_VALUE; 
		int right = Integer.MAX_VALUE;
		if(node.left != null) {
			sub = this.maxDiffBetweenNodeAndAnc(node.left);
			this.maxDiff = Math.max(this.maxDiff, node.data - sub);
			left = sub;
		}
		if(node.right != null) {
			sub = this.maxDiffBetweenNodeAndAnc(node.right);
			this.maxDiff = Math.max(this.maxDiff, node.data - sub);
			right = sub;
		}
		return Math.min(node.data, Math.min(left, right));
	}
	
	public static void main(String[] args) {
//		8 true 3 true 1 false false true 6 true 4 false false true 7 false false true 10 false true 14 true 13 false false false
		MaximumDiffBetweenNodeAndItsAncestor t = new MaximumDiffBetweenNodeAndItsAncestor();
		t.display(t.root);
		t.maxDiffBetweenNodeAndAnc(t.root);
		System.out.println("Maximum difference: " + t.maxDiff);  // 7
	}

}

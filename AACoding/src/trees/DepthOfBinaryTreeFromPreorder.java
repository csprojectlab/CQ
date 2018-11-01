package trees;

// Under Progress.

public class DepthOfBinaryTreeFromPreorder {
	public DepthOfBinaryTreeFromPreorder() {
		super();
	}
	
	// We don't need to construct the tree.
	public int depthOfTreeFromPreorder(String preorder, int index) {
		System.out.println("Processing index: " + index);
		if(index == preorder.length() || preorder.charAt(index) == 'l')
			return 0;
		// here we start processing for n in pre-order.
		index++;
		int leftAns = this.depthOfTreeFromPreorder(preorder, index);
		index++;
		int rightAns = this.depthOfTreeFromPreorder(preorder, index);
		return Math.max(leftAns, rightAns) + 1;
	}
	
	public static void main(String[] ags) {
		// 50 true 80 true 39 false false true 41 true 10 false false true 90 false false true 74 true 93 false false true 11 false false
		DepthOfBinaryTreeFromPreorder t = new DepthOfBinaryTreeFromPreorder();
		String preorder1 = "nlnll";
		String preorder2 = "nlnnlll";
		System.out.println("Depth of tree: " + t.depthOfTreeFromPreorder(preorder2, 0));
	}
}

package trees;

public class SumOfLongestPathFromRootToLeafNode extends BinaryTree {
	int sum;
	int level;
	public SumOfLongestPathFromRootToLeafNode() {
		super();
		this.sum = 0;
		this.level = -1;
	}
	
	public void sumOfLongestPath(Node node, int level, int currentSum) {
		if(node.left == null && node.right == null) {
			if(this.level <= level) {
				this.sum = Math.max(this.sum, currentSum + node.data);
				this.level = level;
			} 
			return;
		}
		if(node.left != null)
			this.sumOfLongestPath(node.left, level + 1, currentSum + node.data);
		if(node.right != null)
			this.sumOfLongestPath(node.right, level + 1, currentSum + node.data);		
	}
	
	public static void main(String[] args) {
//		50 true 80 true 39 false false true 41 true 10 false false true 90 false false true 74 true 93 false false true 11 false false
		SumOfLongestPathFromRootToLeafNode t = new SumOfLongestPathFromRootToLeafNode();
		t.sumOfLongestPath(t.root, 1, 0);
		System.out.println(t.sum);
	
	}
}

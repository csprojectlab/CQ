package trees;

public class SumOfHeightsOfAllNodes extends BinaryTree{
	int sumOfHeights;
	public SumOfHeightsOfAllNodes() {
		super();
		this.sumOfHeights = 0;
	}
	
	public int getAndAddHeight(Node node) {
		if(node.left == null && node.right == null) {
			this.sumOfHeights += 1;
			return 1;
		}
		int leftHeight = 0;
		int rightHeight = 0;
		if(node.left != null)
			leftHeight = this.getAndAddHeight(node.left);
		if(node.right != null)
			rightHeight = this.getAndAddHeight(node.right);
		int result = 1 + Math.max(leftHeight, rightHeight);
		this.sumOfHeights += result;
		return result;
	}
	
	public static void main(String[] args) {
//		1 true 2 true 4 false false true 5 false false true 3 false false
		SumOfHeightsOfAllNodes t = new SumOfHeightsOfAllNodes();
		t.display(t.root);
		t.getAndAddHeight(t.root);
		System.out.println("Sum of heights of all nodes: " + t.sumOfHeights);
	}

}

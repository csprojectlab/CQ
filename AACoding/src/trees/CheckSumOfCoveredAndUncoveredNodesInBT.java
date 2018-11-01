package trees;

//Given a binary tree, you need to check whether sum of all covered elements is equal to sum of all uncovered elements or not.
//In a binary tree, a node is called Uncovered if it appears either on left boundary or right boundary. Rest of the nodes 
//are called covered.

public class CheckSumOfCoveredAndUncoveredNodesInBT extends BinaryTree {
	public CheckSumOfCoveredAndUncoveredNodesInBT() {
		super();
	}
	
	public int uncoveredLeftSum(Node node) {
		if(node.left == null && node.right == null)
			return node.data;
		if(node.left != null)
			return this.uncoveredLeftSum(node.left) + node.data;
		return this.uncoveredLeftSum(node.right) + node.data;
	}
	
	public int uncoveredRightSum(Node node) {
		if(node.left == null && node.right == null)
			return node.data;
		if(node.right != null)
			return this.uncoveredRightSum(node.right) + node.data;
		return this.uncoveredRightSum(node.left) + node.data;
	}
	
	public int uncoveredSum() {
		int sum = 0;
		if(this.root.left != null)
			sum += this.uncoveredLeftSum(this.root.left);
		if(this.root.right != null)
			sum += this.uncoveredRightSum(this.root.right);
		return this.root.data + sum;
	}
	
	public boolean checkEqual() {
		int uncoveredSum = this.uncoveredSum();
		int coveredSum = this.getSum(this.root) - uncoveredSum;
		System.out.println("UncoveredSum: " + uncoveredSum + " CoveredSum: " + coveredSum);
		if(uncoveredSum == coveredSum)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
//		50 true 80 true 39 false false true 41 true 10 false false true 90 false false true 74 true 93 false false true 11 false false		
		CheckSumOfCoveredAndUncoveredNodesInBT t = new CheckSumOfCoveredAndUncoveredNodesInBT();
		System.out.println(t.checkEqual());
	}

}

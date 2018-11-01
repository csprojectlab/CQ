package trees;

public class SumOfAllRightLeavesInBT extends BinaryTree{
	int sumOfLeaves;
	public SumOfAllRightLeavesInBT() {
		super();
		this.sumOfLeaves = 0;
	}
	
	public void sumOfRightLeaves(Node node) {
		if(node == null)
			return;
		if(node.right != null) {
			if(node.right.left == null && node.right.right == null)
				this.sumOfLeaves += node.right.data;
		}
		this.sumOfRightLeaves(node.left);
		this.sumOfRightLeaves(node.right);
	}
	
	public static void main(String[] ags) {
//		50 true 80 true 39 false false true 41 true 10 false false true 90 false false true 74 true 93 false false true 11 false false
		SumOfAllRightLeavesInBT t = new SumOfAllRightLeavesInBT();
		System.out.println("Sum of right leaves: ");
		t.sumOfRightLeaves(t.root);
		System.out.println(t.sumOfLeaves);
	}

}

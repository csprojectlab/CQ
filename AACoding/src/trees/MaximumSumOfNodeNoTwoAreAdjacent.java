package trees;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumOfNodeNoTwoAreAdjacent extends BinaryTree {
	Map<Integer, Integer> SumTillNode;
	public MaximumSumOfNodeNoTwoAreAdjacent() {
		super();
		this.SumTillNode = new HashMap<Integer, Integer>();
	}
	
	public int getSumOfGrandChildren(Node node) {
		int sum = 0;
		if(node.left != null) 
			sum += this.getMaxSum(node.left.left);
		if(node.right != null)
			sum += this.getMaxSum(node.right);
		return sum;
	}
	
	public int getMaxSum(Node node) {
		if(node == null)
			return 0;
		if(this.SumTillNode.get(node.data) != null) {
			System.out.println("DP " + node.data);
			return this.SumTillNode.get(node.data);
		}
		// Choosing this node. Means add node.data + grand-children sum.
		int includeResult = node.data + this.getSumOfGrandChildren(node);
		// Not choosing this node. Therefore get the result from the left and right child.
		int excludeResult = this.getMaxSum(node.left) + this.getMaxSum(node.right);   // deep thought on this.
		this.SumTillNode.put(node.data, Math.max(includeResult, excludeResult));
		return this.SumTillNode.get(node.data);
	}
	
	
	public static void main(String[] args) {
//		1 true 2 true 1 false false false true 3 true 4 false false true 5 false false
		MaximumSumOfNodeNoTwoAreAdjacent t = new MaximumSumOfNodeNoTwoAreAdjacent();
		System.out.println("Maximum Sum: " + t.getMaxSum(t.root));	
		System.out.println(t.SumTillNode);
	}
	
	
}

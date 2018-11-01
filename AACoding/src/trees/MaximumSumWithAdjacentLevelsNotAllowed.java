package trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumSumWithAdjacentLevelsNotAllowed extends BinaryTree { 
	int oddLevelSum = 0;
	int evenLevelSum = 0;
	public MaximumSumWithAdjacentLevelsNotAllowed() {
		super();
	}
	
	public int getMaxSum() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(this.root);
		boolean isOddLevel = true;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-- > 0) {
				Node node = queue.remove();
				if(isOddLevel)
					this.oddLevelSum += node.data;
				else 
					this.evenLevelSum += node.data;
				if(node.left != null)
					queue.add(node.left);
				if(node.right != null)
					queue.add(node.right);
			}
			isOddLevel = !(isOddLevel);
		}		
		return Math.max(this.oddLevelSum, this.oddLevelSum);
	}	
	
	public static void main(String[] args) {
//		50 true 80 true 39 false false true 41 true 10 false false true 90 false false true 74 true 93 false false true 11 false false
		MaximumSumWithAdjacentLevelsNotAllowed t = new MaximumSumWithAdjacentLevelsNotAllowed();
		System.out.println("Maximum Sum: " + t.getMaxSum());
	}

}

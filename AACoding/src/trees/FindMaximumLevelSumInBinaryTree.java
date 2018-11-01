package trees;

import java.util.LinkedList;
import java.util.Queue;

//	Input :              
//    4
//	/   \
//	2    -5
//	/ \   / \
// -1  3 -2  6
//	Output: 6
//	Explanation :
//	Sum of all nodes of 0'th level is 4
//	Sum of all nodes of 1'th level is -3
//	Sum of all nodes of 0'th level is 6
//	Hence maximum sum is 6

// Comment: Use level order traversal.

public class FindMaximumLevelSumInBinaryTree extends BinaryTree {

	public FindMaximumLevelSumInBinaryTree() {
		// TODO Auto-generated constructor stub
	}
	
	public int levelWithMaxSum(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		int max = Integer.MIN_VALUE;
		int maxLevel = -1;
		int level = -1;
		while(!queue.isEmpty()) {
			int size = queue.size();
			level++;
			int levelSum = 0;
			while(size-- > 0) {
				Node n = queue.remove();
				levelSum += n.data;
				if(n.left != null)
					queue.add(n.left);
				if(n.right != null)
					queue.add(n.right);
			}
			if(levelSum > max) {
				maxLevel = level;
				max = levelSum;
			}
		}
		return maxLevel;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

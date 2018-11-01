package trees;

//	1
//	/   \
//	2     3
//	/  \   /  \
//	4   5   6   7
//	/     \
//	8       9
//
//Output : 11
//Leaf nodes 4 and 7 are at minimum level.
//Their sum = (4 + 7) = 11. 

// Comment: One way of doing this is by using the level order traversal using queue.
// If we find the first leaf node then we find the sum of all leaf nodes at that level.

public class SumOfLeafNodesAtMinimumLevel extends BinaryTree {
	int level;
	int sum;

	public SumOfLeafNodesAtMinimumLevel() {
		super();
		this.level = -1;
		this.sum = 0;
	}

	public void sumOfLeavesAtMinLevel(Node node, int level) {
		if(node == null)
			return;
		if(node.left == null && node.right == null) {
			if(this.level == -1) {
				this.level = level;
			}
			if(this.level == level) {
				sum += node.data;
			}
			else if(level < this.level) {
				this.level = level;
				this.sum = node.data;
			}
		}
		this.sumOfLeavesAtMinLevel(node.left, level + 1);
		this.sumOfLeavesAtMinLevel(node.right, level + 1);
	}
	
	public static void main(String[] args) {
//		50 true 80 true 39 false false true 41 true 10 false false true 90 false false true 74 true 93 false false true 11 false false
		SumOfLeafNodesAtMinimumLevel t = new SumOfLeafNodesAtMinimumLevel();
		t.sumOfLeavesAtMinLevel(t.root, 1);
		System.out.println(t.sum);  // 143 : 39 + 93 + 11
		
	}

}

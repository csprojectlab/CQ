package trees;

public class CheckLeavesAtSameLevel extends BinaryTree {
	int allLeafLevel;
	public CheckLeavesAtSameLevel() {
		super();
		this.allLeafLevel = -1;
	}
	
	public boolean checkLeavesLevelDFS(Node node, int level) {
		if(node.left == null && node.right == null) {
			if(this.allLeafLevel == -1)  // Setting it first and last time to the level of first leaf node.
				this.allLeafLevel = level;
			if(this.allLeafLevel == level)
				return true;
			else 
				return false;
		}
		return this.checkLeavesLevelDFS(node.left, level + 1) && this.checkLeavesLevelDFS(node.right, level + 1);
	}
	
	public static void main(String[] args) {
//		50 true 80 true 39 false false true 41 true 10 false false true 90 false false true 74 true 93 false false true 11 false false
		CheckLeavesAtSameLevel t = new CheckLeavesAtSameLevel();
		System.out.println(t.checkLeavesLevelDFS(t.root, 1));
	}
}

package trees;

//A Binary tree is Perfect Binary Tree in which all internal nodes have two children and all leaves are at same level.

public class PerfectTreeOrNot extends BinaryTree {

	int levelOfTree;
	public PerfectTreeOrNot() {
		super();
		this.levelOfTree = -1;  // undefined.
	}

	public boolean isPerfect(Node node, int level) {
		if(node.left == null && node.right == null) {
			if(this.levelOfTree == -1)  // Setting up first time.
				this.levelOfTree = level;
			if(this.levelOfTree == level)
				return true;
			else 
				return false;
		}
		if(node.left == null || node.right == null)  // Having only one child.
			return false;
		return this.isPerfect(node.left, level + 1) && this.isPerfect(node.right, level +1);		
	}
	
	public static void main(String[] args) {
//		10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 70 false false
		PerfectTreeOrNot t = new PerfectTreeOrNot();
		System.out.println("Is perfect tree: " + t.isPerfect(t.root, 1));  // true

	}

}

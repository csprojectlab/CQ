package trees;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBT extends BinaryTree {
	public CousinsInBT() {
		super();
	}
	
	public boolean checkCousinsBFS(int first, int second) {
		if(this.root.data == first || this.root.data == second)
			return false;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(this.root);
		boolean oneCousinFound = false;
		while(!queue.isEmpty()) {
			int levelNodes = queue.size();
			while(levelNodes-- > 0) {
				Node node = queue.remove();
				boolean firstChildFound = false;
				boolean secondChildFound = false;
				firstChildFound = (node.left != null && (node.left.data == first || node.left.data == second));
				secondChildFound = (node.right != null && (node.right.data == first || node.right.data == second));
				if(firstChildFound && secondChildFound)
					return false;  // Children of same parent.
				else if((firstChildFound || secondChildFound)) {
					if(!oneCousinFound)  // Check cousin found from another parent.
						oneCousinFound = true;
					else
						return true;
				}
				if(node.left != null)
					queue.add(node.left);
				if(node.right != null)
					queue.add(node.right);						
			}
		}
		return false;  // Both keys or either one key doesn't exist.
	}
	
	
	public static void main(String[] ags) {
//		50 true 80 true 39 false false true 41 true 10 false false true 90 false false true 74 true 93 false false true 11 false false
		CousinsInBT t = new CousinsInBT();
		System.out.println(t.checkCousinsBFS(90, 10));  // false.
	
	}

}

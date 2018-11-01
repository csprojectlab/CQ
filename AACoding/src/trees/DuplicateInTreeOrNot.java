package trees;

import java.util.HashSet;
import java.util.Set;

// Comment: To minimize the comparison time we can use either the set or hashmap.

public class DuplicateInTreeOrNot extends BinaryTree {
	Set<Integer> data;
	public DuplicateInTreeOrNot() {
		super();
		this.data = new HashSet<>();
	}

	public boolean searchDuplicate(Node node) {
		if(this.data.contains(node.data))
			return true;  // duplicate.
		this.data.add(node.data);
		if(node.left != null && this.searchDuplicate(node.left) || node.right != null && this.searchDuplicate(node.right)) 
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		

	}

}

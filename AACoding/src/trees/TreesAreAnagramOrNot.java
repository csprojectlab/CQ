package trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreesAreAnagramOrNot {

	
	public boolean areAnagram(BinaryTree t1, BinaryTree t2) {
		Queue<Node> queue1 = new LinkedList<>();
		Queue<Node> queue2 = new LinkedList<>();
		queue1.add(t1.root);
		queue2.add(t2.root);
		while(true) {
			int n1 = queue1.size();
			int n2 = queue2.size();
			if(n1 != n2)   // size of the levels don't match.
				return false;  
			if(n1 == 0)   // level order traversal is over.
				break;
			int first[] = new int[n1];   // store level nodes.
			int second[] = new int[n1];
			int index = 0;
			int last = n1 - 1;
			while(n1 > 0) {
				Node firstTreeNode = queue1.poll();
				Node secondTreeNode = queue2.poll();
				if(firstTreeNode.left != null)
					queue1.add(firstTreeNode.left);
				if(firstTreeNode.right != null)
					queue1.add(firstTreeNode.right);
				if(secondTreeNode.left != null)
					queue2.add(secondTreeNode.left);
				if(secondTreeNode.right != null)
					queue2.add(secondTreeNode.right);
				first[index] = firstTreeNode.data;
				second[last - index] = secondTreeNode.data;
				index++;
				n1--;
			}
			// Checking the equality for anagram for the level.
			for(int j = 0; j < first.length; j++)
				if(first[j] != second[j])
					return false;
		}
		return true;
	}
}

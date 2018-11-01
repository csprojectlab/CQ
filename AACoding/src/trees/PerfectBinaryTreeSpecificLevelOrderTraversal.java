package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PerfectBinaryTreeSpecificLevelOrderTraversal extends BinaryTree {
	
	public PerfectBinaryTreeSpecificLevelOrderTraversal() {
		super();
	}
	
	// This is top down traversal.
	public void specificLevelOrderTraversal() {
		// we must process two node at a time.
		Node node = this.root;
		System.out.print(node.data + " ");  // level 1
		if(node.left != null)   // No need to check for right as it is a perfect tree.
			System.out.print(node.left.data + " " + node.right.data + " ");  // level 2
        if(node.left.left == null)  // level 3 doesn't exist.
        	return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node.left);  // level 1 left child.
        queue.add(node.right);  // level 1 right child.
        while(!queue.isEmpty()) {
        	Node first = queue.remove();
        	Node second = queue.remove();
        	System.out.print(first.left.data + " " + second.right.data + " ");
        	System.out.print(first.right.data + " " + second.left.data + " ");
        	if(first.left.left !=  null) { //  Next level exist. If one node exist then entire level will. 
        		queue.add(first.left);
        		queue.add(second.right);
        		queue.add(first.right);
        		queue.add(second.left);
        	}
        }
	}
	
	public void bottomTopSpecificLevelOrderTraversal() {
		Node node = this.root;
		Stack<Integer> stack = new Stack<Integer>();
		Queue<Node> queue = new LinkedList<Node>();
		stack.push(node.data);
		if(node.left != null) {
			stack.push(node.right.data);
			stack.push(node.left.data);
		}
		if(node.left.left == null)
			return;
		queue.add(node.left);
		queue.add(node.right);
		while(!queue.isEmpty()) {
			Node first = queue.remove();
        	Node second = queue.remove();
        	stack.push(second.left.data);
        	stack.push(first.right.data);
        	stack.push(second.right.data);
        	stack.push(first.left.data);
        	if(first.left.left !=  null) { //  Next level exist. If one node exist then entire level will. 
        		queue.add(first.left);
        		queue.add(second.right);
        		queue.add(first.right);
        		queue.add(second.left);
        	}
		}
		while(!stack.isEmpty())
			System.out.print(stack.pop() + " ");
		
	}
	
	public static void main(String[] args) {
		// 1 true 2 true 4 false false true 5 false false true 3 true 6 false false true 7 false false
		PerfectBinaryTreeSpecificLevelOrderTraversal t = new PerfectBinaryTreeSpecificLevelOrderTraversal();
		t.display(t.root);
		// 1 2 3 4 7 5 6
		System.out.println("Specific level order traversal for Perfect tree: ");
		t.specificLevelOrderTraversal();	
		System.out.println();
		System.out.println("BottomTop level order traversal for perfect tree: ");
		t.bottomTopSpecificLevelOrderTraversal();
	}
}

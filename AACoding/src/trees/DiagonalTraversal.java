package trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DiagonalTraversal extends BinaryTree {
	Map<Integer, Stack<Integer>> slopeMap;
	public DiagonalTraversal() {
		super();
		this.slopeMap = new HashMap<Integer, Stack<Integer>>();
	}
	
	public void diagonalTraversal(Node node, int slope) {
		if(node.right != null) // Diagonal is left.
			this.diagonalTraversal(node.right, slope);
        
		if(this.slopeMap.get(slope) == null) { // Means stack has not been initialized yet for this slope.
        	Stack<Integer> stack = new Stack<Integer>();
        	stack.push(node.data);
        	this.slopeMap.put(slope, stack);
        } else {  // Stack for this slope already exist.
        	this.slopeMap.get(slope).push(node.data);
        }
		
		if(node.left != null)
			this.diagonalTraversal(node.left, slope + 1);		
	}
	
	public static void main(String[] args) {
		// 50 true 80 true 39 false false true 41 true 10 false false true 90 false false true 74 true 93 false false true 11 false false
		DiagonalTraversal t = new DiagonalTraversal();
		t.diagonalTraversal(t.root, 1);
	    for(Stack<Integer> stack : t.slopeMap.values()) {
	    	while(!stack.isEmpty())
	    		System.out.print(stack.pop() + " ");
	    	System.out.println();
	    }
	}
	
}

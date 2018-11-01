package stack;

import java.util.Stack;

/*
 *  If we find a smaller element after the right child of the node then it won't represent pre-order traversal.
 */
public class CheckIfArrayCanRepresentPreorderTraversalOfBST {

	public boolean representOrNot(int[] arr) {
		int root = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while(i < arr.length) {
			if(arr[i] < root)
				return false;
			while(!stack.isEmpty() && stack.peek() < arr[i]) {
				root = stack.pop();
			}
			stack.push(arr[i]);
			i++;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {40,30,35,80,100};
		CheckIfArrayCanRepresentPreorderTraversalOfBST c = new CheckIfArrayCanRepresentPreorderTraversalOfBST();
		boolean result = c.representOrNot(arr);
		System.out.println(result);
	}

}

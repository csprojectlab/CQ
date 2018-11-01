package stack;

import java.util.Stack;

public class NextGreaterElement {

	// Returns the index of the next greater element.
	public int[] nge(int[] arr) {
		int[] k = new int[arr.length];
		Stack<Integer> stack = new Stack<>(); // Store the indexes.
		stack.push(0);
		int i = 1;
		while(i < k.length) {
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				// Then we have found the answer for the element at stack.peek() position.
				k[stack.peek()] = i;
				stack.pop();
			}
			stack.push(i);
			i++;
		}
		util.Util.print(arr);
		while(!stack.isEmpty())
			k[stack.pop()] = -1;   // No next greater element exist for these indexes.
		util.Util.print(k);
		return k;
	}
	
	public static void main(String[] args) {
		NextGreaterElement nge = new NextGreaterElement();
		int[] arr = new int[] {5,2,2,5,1};
		nge.nge(arr);
	}
}

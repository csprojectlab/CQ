package stack;

import java.util.Stack;

public class DeleteMiddleElementOfStack {

	private int count = 0;   // Taking a variable in heap.
	
	// Pass currentCount as 0 in the beginning.
	public void deleteMiddle(Stack<Integer> stack, int currentCount) {
		if(!stack.isEmpty()) {
			count++;   // Count the number of elements in the stack.
			int top = stack.pop();
			this.deleteMiddle(stack, currentCount + 1);
			if(currentCount == (count >> 1)) {
				// Don't put this middle element back.
			} else
				stack.push(top);
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(-3);
		stack.push(14);
		stack.push(18);  // middle element.
		stack.push(-5);
		stack.push(30);
		stack.push(0);  // Making even.  Middle element change.
		System.out.println("Before deletion: " + stack);
		DeleteMiddleElementOfStack d = new DeleteMiddleElementOfStack();
		d.deleteMiddle(stack, 0);  // Start counting from 0.
		System.out.println("After deletion: " + stack);
	}
	
}

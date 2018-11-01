package stack;

import java.util.Stack;

public class SortStackUsingTemporaryStack {

	public Stack<Integer> sortStack(Stack<Integer> stack) {
		Stack<Integer> tempStack = new Stack<>();   // Answer will be in this stack.
		while(!stack.isEmpty()) {
			int top = stack.pop();    // Get the top element.
			if(tempStack.isEmpty() || top > tempStack.peek())
				tempStack.push(top);
			else {
				while(!tempStack.isEmpty() && top < tempStack.peek())
					stack.push(tempStack.pop());    //  Pushing back to the original stack.
				tempStack.push(top);
			}
		}
		return tempStack;
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(-3);
		stack.push(14);
		stack.push(18);
		stack.push(-5);
		stack.push(30);
		stack.push(0);
		System.out.println("Before sorting: " + stack);
		SortStackUsingTemporaryStack s = new SortStackUsingTemporaryStack();
		stack = s.sortStack(stack);
		System.out.println("After sorting: " + stack);
	}
	
}

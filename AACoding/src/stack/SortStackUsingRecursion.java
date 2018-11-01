package stack;

import java.util.Stack;

public class SortStackUsingRecursion {
	
	public void insertInSortedStack(Stack<Integer> stack, int value) {
		if(stack.isEmpty() || value > stack.peek())
			stack.push(value);
		else  {  // Means value at top is greater than value.
			int top = stack.pop();
			this.insertInSortedStack(stack, value);
			stack.push(top);
		} 
	}
	
	public void sortStack(Stack<Integer> stack) {
		if(!stack.isEmpty()) {
			int top = stack.pop();
			this.sortStack(stack);
			this.insertInSortedStack(stack, top);
		}
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
		SortStackUsingRecursion s = new SortStackUsingRecursion();
		s.sortStack(stack);
		System.out.println("After sorting: " + stack);
	}
	
}

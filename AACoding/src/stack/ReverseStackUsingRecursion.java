package stack;

import java.util.Stack;

public class ReverseStackUsingRecursion {

	public void putAtBottom(Stack<Integer> stack, int value) {
		if(stack.isEmpty())
			stack.push(value);
		else {
			int temp = stack.pop();
			this.putAtBottom(stack, value);
			stack.push(temp);
		}
	}
	
	public void reverseStack(Stack<Integer> stack) {
		if(!stack.isEmpty()) {   // Reach the last element of the stack.
			int top = stack.pop();
			this.reverseStack(stack);
			this.putAtBottom(stack, top);   // put the element at the bottom.
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);
		s.push(0);
		System.out.println("Before reversing: " + s);
		ReverseStackUsingRecursion r = new ReverseStackUsingRecursion();
		r.reverseStack(s);
		System.out.println("After reversing: " + s);
	}
	
}

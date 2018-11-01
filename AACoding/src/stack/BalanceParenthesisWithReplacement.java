package stack;

import java.util.Stack;

/*
 *  X can take any of the {, (, [, }, ), ] values.
 */
public class BalanceParenthesisWithReplacement {

	public boolean checkValid(char top, char ch) {
		if(top == 'X')
			return true;
		switch(ch) {
		case '}':
			if(top == '(' || top == '[')
				return false;
			break;
		case ']':
			if(top == '{' || top == '(')
				return false;
			break;
		case ')':
			if(top == '{' || top == '[')
				return false;
		}
		return true;
	}
	
	public boolean canBeBalanced(char[] input, Stack<Character> stack, int index) {
		if(index == input.length)
			return true;
		if(input[index] == '{' || input[index] == '(' || input[index] == '[') {
			stack.push(input[index]);
		} else if(input[index] == '}' || input[index] == ')' || input[index] == ']') {
			if(this.checkValid(stack.peek(), input[index])) {
				stack.pop();
			} else
				return false;
		} else if(input[index] == 'X') {
			// We have two choice. Either it can be an opening brace of a closing.
			// Assuming as opening first. Therefore pushing it onto the stack.
			stack.push('X');
			boolean recResult = this.canBeBalanced(input, stack, index+1);
			if(!recResult) {
				stack.pop();
				return this.canBeBalanced(input, stack, index+1);				
			} else
				return true;
		}		
		return this.canBeBalanced(input, stack, index+1);
	}
	
	public static void main(String[] args) {
		BalanceParenthesisWithReplacement b = new BalanceParenthesisWithReplacement();
		String expression = "{(X[X])}";   // true
		String two = "[{X}(X)]";   // false
		boolean x = b.canBeBalanced(two.toCharArray(), new Stack<Character>(), 0);
		System.out.println(x);
	}
}

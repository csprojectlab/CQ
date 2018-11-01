package stack;

import java.util.Stack;

/*
 * Count minimum number of brackets required to be reversed to make the expression valid.
 */
// ?????????????????????????????????????????????????Problem in finding the reversals
public class MinimumNumberOfBracketReversal {

	/*
	 * we first filter the invalid brackets and then count the opening and closing ones to get the result.
	 */
	public int minReversals(char[] expression) {
		Stack<Character> stack = new Stack<>();
		int i = 0;
		while(i < expression.length) {
			if(expression[i] == '{') {
				stack.push(expression[i]);
			} else {
				if(stack.isEmpty())
					stack.push(expression[i]);
				else if(stack.peek() == '{') 
					stack.pop();
				else
					stack.push(expression[i]);
			}
			i++;
		}
		// Stack contains invalid parenthesis.
		System.out.println("Invalid: " + stack);
		int open = 0;
		int close = 0;
		while(!stack.isEmpty()) {
			char ch = stack.pop();
			if(ch == '{')
				open++;
			else
				close++;
		}
		if(((open + close) & 1) != 0) {
			System.out.println("Can't be balanced.");
			return -1;
		}
		int reversals = (int)(open >> 1) + ((close) >> 1);
		System.out.println(reversals);
		return -1;
	}
	
	public static void main(String[] args) {
		MinimumNumberOfBracketReversal b = new MinimumNumberOfBracketReversal();
		String ex = "}{{}{{";
		b.minReversals(ex.toCharArray());
	}
}

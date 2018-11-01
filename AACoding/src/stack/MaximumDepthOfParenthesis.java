package stack;

import java.util.Stack;

public class MaximumDepthOfParenthesis {

	public int maxDepth(char[] expression) {
		Stack<Character> stack = new Stack<>();
		int currentMax = 0;
		int max = Integer.MIN_VALUE;
		int i = 0;
		while(i < expression.length) {
			if(expression[i] == '(') {
				currentMax++;
				stack.push(expression[i]);
			} else if(expression[i] == ')') {
				if(stack.isEmpty())
					break;   // Closing parenthesis are more.
				stack.pop();
			} else {   // Found a variable.
				max = Math.max(max, currentMax);
				currentMax = 0;
			}
			i++;		
		}
		// More closing brackets || more opening brackets.
		if(i < expression.length || !stack.isEmpty()) {   //  There are more closing brackets than opening. and reverse
			System.out.println("Invalid expression.");
			return -1;
		}
		System.out.println("Max depth: " + max);
		return currentMax;
	}
	
	
	public static void main(String[] args) {
		String expression = "((x)(((x))))";
		MaximumDepthOfParenthesis d = new MaximumDepthOfParenthesis();
		d.maxDepth(expression.toCharArray());
	}
}

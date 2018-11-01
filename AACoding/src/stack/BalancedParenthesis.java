package stack;

import java.util.Stack;

public class BalancedParenthesis {

	public boolean balancedParenthesis(char[] input) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < input.length; i++) {
			if(input[i] == '{' || input[i] == '(' || input[i] == '[') {
				stack.push(input[i]);
				continue;
			}
			if(stack.size() == 0)
				return false;
			switch(input[i]) {
			case ')':
				if(stack.peek() == '[' || stack.peek() == '{')
					return false;
				break;
			case '}':
				if(stack.peek() == '(' || stack.peek() == '[')
					return false;
				break;
			case ']':
				if(stack.peek() == '{' || stack.peek() == '(')
					return false;
				break;
			}
			stack.pop();    // remove the paired parenthesis.
		}
		return true;
	}
	
	public static void main(String[] args) {
		BalancedParenthesis p = new BalancedParenthesis();
		String input = "()[}]";
		System.out.println(p.balancedParenthesis(input.toCharArray()));
	}
}

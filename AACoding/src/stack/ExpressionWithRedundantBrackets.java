package stack;

import java.util.Stack;

public class ExpressionWithRedundantBrackets {

	public boolean redundant(char[] expression) {
		Stack<Character> stack = new Stack<>();
		/*
		 * we won't process the first and last bracket.
		 */
		int i = 1;
		while(i < expression.length - 1) {
			if(expression[i] == ')') {
				// I assume that the expression is redundant.
				boolean result = true;
				while(!stack.isEmpty() && stack.peek() !='(') {
					char ch = stack.pop();
					if(ch == '*' || ch == '-' || ch == '/' || ch == '+')
						result = false;
				}
				if(!stack.isEmpty())
					stack.pop();   // pop the opening brace.
				if(result) {
					System.out.print("Redundant");
					return true;
				}
				i++;
				continue;
			}
			stack.push(expression[i]);
			i++;
		}
		System.out.println("Not redundant");
		return false;
	}
	
	public static void main(String[] args) {
		ExpressionWithRedundantBrackets e = new ExpressionWithRedundantBrackets();
		String expression = "(a+(b)*(c-d))";
		e.redundant(expression.toCharArray());
	}
}

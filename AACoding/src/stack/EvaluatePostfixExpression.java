package stack;

import java.util.Stack;

public class EvaluatePostfixExpression {
	
	public int performOperation(int val1, int val2, char operation) {
		switch(operation) {
		case '+': return val1 + val2;
		case '-': return val1 - val2;
		case '*': return val1 * val2;
		case '/': return val1 / val2;
		default: return -1;
		}
	}

	public int evaluatePostfix(char[] tokens) {
		Stack<Integer> value = new Stack<>();
		for(int i = 0; i < tokens.length; i++) {
			if(Character.isDigit(tokens[i]))
				value.push(tokens[i] - '0');
			else {
				int val2 = value.pop();
				int val1 = value.pop();
				value.push(this.performOperation(val1, val2, tokens[i]));
			}
		}
		System.out.println(value.peek());
		return value.pop();
	}
	
	public static void main(String[] args) {
		EvaluatePostfixExpression p = new EvaluatePostfixExpression();
		String tokens = "231*+9-";
		p.evaluatePostfix(tokens.toCharArray());
	}
	
}

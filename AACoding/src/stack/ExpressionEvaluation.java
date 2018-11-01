package stack;

import java.util.Stack;

public class ExpressionEvaluation {

	public int precedence(char op) {
		if(op == '+' || op == '-')
			return 1;
		else if(op == '/' || op == '*')
			return 2;
		return 0;
	}
	
	public int performOperation(int val1, int val2, char operation) {
		switch(operation) {
		case '+': return val1 + val2;
		case '-': return val1 - val2;
		case '*': return val1 * val2;
		case '/': return val1 / val2;
		default: return -1;
		}
	}
	
	public int evaluateExpression(char[] expression) {
		Stack<Integer> valStack = new Stack<>();
		Stack<Character> opStack = new Stack<>();
		for(int i = 0; i < expression.length; i++) {
			if(expression[i] == ' ')
				continue;
			else if(expression[i] == '(') {
				opStack.push(expression[i]);
				continue;
			} else if(expression[i] == ')') {
				while(!opStack.isEmpty() && opStack.peek() != '(') {
					int val2 = valStack.pop();
					int val1 = valStack.pop();
					valStack.push(this.performOperation(val1, val2, opStack.pop()));
				}
				opStack.pop();
			} else if(Character.isDigit(expression[i])) {
				int value = 0;
				while(i < expression.length && Character.isDigit(expression[i])) {
					value = value*10 + (expression[i] - '0');
					i++;
				}
				i--;    // Due to for loop continuation
				valStack.push(value);
			} else {  // It is an operation.
				while(!opStack.isEmpty() && this.precedence(opStack.peek()) > this.precedence(expression[i])) {
					int val2 = valStack.pop();
					int val1 = valStack.pop();
					valStack.push(this.performOperation(val1, val2, opStack.pop()));
				}
				opStack.push(expression[i]);
			}
		}
		
		while(!opStack.isEmpty()) {
			int val2 = valStack.pop();
			int val1 = valStack.pop();
			valStack.push(this.performOperation(val1, val2, opStack.pop()));
		}
		System.out.println(valStack.peek());
		return -1;
	}
	
	public static void main(String[] args) {
		ExpressionEvaluation e = new ExpressionEvaluation();
		String tokens = "100 * 2 + 1";
		e.evaluateExpression(tokens.toCharArray());
	}
}

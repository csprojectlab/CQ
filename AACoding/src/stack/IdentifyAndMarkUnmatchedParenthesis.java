package stack;

import java.util.Stack;

/*
 * Input = ((a)
 * Output = -10a1
 */
public class IdentifyAndMarkUnmatchedParenthesis {

	// 3 means -1;
	public String markUnmatched(char[] exp) {
		char[] result = new char[exp.length];
		for (int i = 0; i < exp.length; i++)
			result[i] = exp[i];
		Stack<Integer> stack = new Stack<>(); // to store the indexes of the characters.
		int i = 0;
		while (i < exp.length) {
			if (exp[i] == '(') {
				stack.push(i);
			} else if (exp[i] == ')') {
				if (stack.isEmpty()) {
					System.out.println("Invalid expression.");
					result[i] = '3';
				} else {
					int index = stack.pop();
					result[index] = '0';
					result[i] = '1';
				}
			} else {}
			i++;
		}
		while (!stack.isEmpty())
			result[stack.pop()] = '3';
		for (i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
		return null;
	}

	public static void main(String[] args) {
		IdentifyAndMarkUnmatchedParenthesis i = new IdentifyAndMarkUnmatchedParenthesis();
		String expression = "(((abc))((d)))))";
		i.markUnmatched(expression.toCharArray());
	}
}

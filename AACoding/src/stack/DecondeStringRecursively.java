package stack;

import java.util.Stack;

/*
 * 2[a2[b]] = abbabb
 */
public class DecondeStringRecursively {
	public String result = "";   // Using a heap variable
	
	public void decodeString(char[] string, Stack<Character> stack, int index) {
		if(index == string.length)
			return;
		if(string[index] == ']') {
			while(stack.peek() != '[')
				result = stack.pop() + result;
			stack.pop();  // pop the bracket.
			int freq = stack.pop() - '1';
			String temp = result;
			while(freq-- > 0)
				result += temp;
			this.decodeString(string, stack, index+1);
			return;
		}
		stack.push(string[index]);
		this.decodeString(string, stack, index+1);
	}
	
	public static void main(String[] args) {
		DecondeStringRecursively decode = new DecondeStringRecursively();
		String string = "4[a2[b]]";
		String two = "3[1[ab]]";
		decode.decodeString(two.toCharArray(), new Stack<Character>(), 0);
		System.out.println("Decoded String: " + decode.result);
	}
}

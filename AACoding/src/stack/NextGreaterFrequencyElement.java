package stack;

import java.util.Stack;

/*
 * For an element at position i print the element with index greater than i whose frequency is greater than
 * that of element at i'th position.
 */
public class NextGreaterFrequencyElement {

	public int[] ngeFrequencyElement(int[] arr) {
		int[] frequency = new int[100];  // Store the frequency from 0 ---- 99.
		for(int i = 0; i < arr.length; i++)
			frequency[arr[i]]++;
		int k[] = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int i = 1;
		while(i < arr.length) {
			while(!stack.isEmpty() && frequency[arr[stack.peek()]] < frequency[arr[i]]) {
				k[stack.peek()] = i;
				stack.pop();
			}
			stack.push(i);
			i++;
		}
		while(!stack.isEmpty())
			k[stack.pop()] = -1;
		util.Util.print(k);
		return null;
	}
	
	public static void main(String[] args) {
		NextGreaterFrequencyElement n = new NextGreaterFrequencyElement();
		int[] arr = new int[] {1,1,2,3,4,2,1};
		n.ngeFrequencyElement(arr);
	}
}

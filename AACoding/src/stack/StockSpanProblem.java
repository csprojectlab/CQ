package stack;

import java.util.Stack;

public class StockSpanProblem {

	public int[] stockSpan(int[] arr) {
		int[] k = new int[arr.length];
		Stack<Integer> stack = new Stack<>();   // Store the indexes.
		stack.push(0);
		k[0] = 1;  // stock span of the first day is 1.
		int i = 1;
		while(i < k.length) {
			while(!stack.isEmpty() && arr[stack.peek()] <= arr[i])
				stack.pop();
			k[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());
			stack.push(i);
			i++;
		}
		util.Util.print(k);
		return k;
	}
	
	public static void main(String[] args) {
		StockSpanProblem s = new StockSpanProblem();
		int[] arr = new int[] {100, 75, 25, 35, 25, 55, 85};
		s.stockSpan(arr);
	}
	
}

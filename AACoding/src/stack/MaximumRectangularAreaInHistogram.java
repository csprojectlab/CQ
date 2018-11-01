package stack;

import java.util.Stack;

public class MaximumRectangularAreaInHistogram {

	// Visualize this array as a bar chart.
	public int maxArea(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		stack.push(0); // Push the zero'th index of the array.
		int i = 1; // Start from index 1.
		int maxArea = Integer.MIN_VALUE;
		while (!stack.isEmpty() && i < arr.length) {
			// If a small bar comes after a big bar. Then start popping till we get bar of small or less size than i.
			while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
				// Now calculate the area for the bar at the top of the stack.
				int area = -1;
				if (stack.size() == 1) { // Only one bar is left.
					area = arr[stack.pop()] * i;
				} else {
					int barStartIndex = stack.pop();
					area = arr[barStartIndex] * (i - stack.peek() - 1);
				}
				maxArea = Math.max(maxArea, area);
			}
			stack.push(i);
			i++;
		}
		while(!stack.isEmpty()) {
			int area = -1;
			if(stack.size() == 1)
				area = arr[stack.pop()] * i;
			else {
				int barStartIndex = stack.pop();
				area = arr[barStartIndex] * (i - stack.peek() - 1);    // Till the bar extends.
			}
			maxArea = Math.max(maxArea, area);
		}
		System.out.println("Maximum area : " + maxArea);
		return maxArea;
	}

	public static void main(String[] args) {
		MaximumRectangularAreaInHistogram h = new MaximumRectangularAreaInHistogram();
		//int[] histogram = new int[] { 2, 1, 2, 3, 1 };
		int[] hist = new int[] {5,4,3,2,1};
		h.maxArea(hist);
	}

}

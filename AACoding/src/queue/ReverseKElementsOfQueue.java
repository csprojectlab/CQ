package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElementsOfQueue {

	/*
	 * Reverse the first k elements of the queue.
	 */
	public void reverseKElements(Queue<Integer> queue, int k) {
		// First reversing the entire queue.
		ReverseQueue r = new ReverseQueue();
		r.reverseQueue(queue);     // Reversing.
		Stack<Integer> stack = new Stack<>();
		// Pushing the size - k elements on the stack.
		int i = 0;
		int size = queue.size();
		while(i++ < size - k)
			stack.push(queue.poll());
		while(!stack.isEmpty())
			queue.add(stack.pop());
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i < 11; i++) 
			queue.add(i);
		System.out.println("Before Reversing: " + queue);
		int k = 8;   // Reverse first k elements.
		ReverseKElementsOfQueue r = new ReverseKElementsOfQueue();
		r.reverseKElements(queue, k);
		System.out.println("After reversing first " + k + " elements: " + queue);
	}
	
}

package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleaveFirstHalfWithSecondHalf {

	public void interleaveQueue(Queue<Integer> queue) {
		// reversing the first half of the queue.
		ReverseKElementsOfQueue r = new ReverseKElementsOfQueue();
		r.reverseKElements(queue, queue.size() / 2);
		System.out.println(queue);
		Stack<Integer> stack = new Stack<>();
		int size = queue.size() / 2;
		int i = 0;
		while(i < size) {
			stack.push(queue.poll());
			i++;
		}
		while(!stack.isEmpty()) {
			int queueElement = queue.poll();
			int stackElement = stack.pop();
			queue.add(stackElement);
			queue.add(queueElement);
		}
		System.out.println("Last Elements issue: " + queue);
		i <<= 1;
		while(i++ < queue.size())
			queue.add(queue.poll());
		System.out.println(queue);
		
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= 11; i++)
			queue.add(i);
		System.out.println(queue);
		InterleaveFirstHalfWithSecondHalf i = new InterleaveFirstHalfWithSecondHalf();
		i.interleaveQueue(queue);
	}
	
}

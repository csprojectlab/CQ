package queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {

	public void reverseQueue(Queue<Integer> queue) {
		if(!queue.isEmpty()) {
			int element = queue.poll();
			this.reverseQueue(queue);
			queue.add(element);
		}
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= 11; i++)
			queue.add(i);
		System.out.println("Queue: " + queue);
		ReverseQueue r = new ReverseQueue();
		r.reverseQueue(queue);
		System.out.println("After reversing: " + queue);
	}
}

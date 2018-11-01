package queue;

import java.util.Deque;
import java.util.LinkedList;

public class DoubleQueue {

	public static void main(String[] args) {
		Deque<Integer> queue = new LinkedList<>();
		queue.addFirst(1);
		queue.addFirst(2);
		queue.addLast(4);
		
		System.out.println(queue);
	}
	
}

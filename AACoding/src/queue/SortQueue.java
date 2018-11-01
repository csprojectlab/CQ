package queue;

import java.util.LinkedList;
import java.util.Queue;

public class SortQueue {

	public void insertInSortedQueue(Queue<Integer> queue, int key) {
		if(queue.isEmpty() || queue.peek() < key) {
			queue.add(key);
		} else if(queue.peek() > key) {
			int element = queue.poll();
			this.insertInSortedQueue(queue, key);
			queue.add(element);
		}
	}
	
	public void sortQueue(Queue<Integer> queue) {
		if(!queue.isEmpty()) {
			int element = queue.poll();
			this.sortQueue(queue);
			this.insertInSortedQueue(queue, element);
		}
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i < 11; i++) 
			queue.add(11 - i);
		System.out.println("Before sorting: " + queue);
		SortQueue s = new SortQueue();
		s.sortQueue(queue);
		System.out.println("After sorting: " + queue);
	}
	
}

package queue;

import java.util.Comparator;
import java.util.PriorityQueue;

class Interval {
	int start;
	int end;
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public String toString() {
		return "{" + this.start + "," + this.end + "}";
	}
}

public class PriorityQueueDemo {
	
	public static void main(String[] args) {
		PriorityQueue<Interval> queue = new PriorityQueue<>(new Comparator<Interval>() {
			public int compare(Interval first, Interval second) {
				if(first.start < second.start)
					return -1;
				else if(first.start > second.start)
					return 1;
				return 0;
			}			
		});
		
		queue.add(new Interval(4,5));
		queue.add(new Interval(1,2));
		queue.add(new Interval(3,1));
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}
	
}

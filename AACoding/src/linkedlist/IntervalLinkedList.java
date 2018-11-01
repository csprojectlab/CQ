package linkedlist;

class Interval {
	int start;
	int end;
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public boolean equals(Object o) {
		Interval other = (Interval)o;
		return this.start == other.start && this.end == other.end;
	}
	public String toString() {
		return this.start + "," + this.end;
	}
}

public class IntervalLinkedList {

	public static void main(String[] args) {
		LinkedList<Interval> list = new LinkedList<Interval>();
		for(int i = 1; i < 5; i++)
			list.add(new Interval(i, i+1));
		list.display();
		list.addAfter(new Interval(3,4), new Interval(9,9));
		list.display();
	}
	
	
}

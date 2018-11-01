package stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
/*
 * Output should be the non overlapping intervals.
 */
public class MergeOverlappingIntervals {

	public List<Interval> mergeOverlappingIntervals(Interval[] interval) {
		// Sort the interval array according to start time.
		Arrays.sort(interval, new Comparator<Interval>() {
			@Override
			public int compare(Interval first, Interval second) {
				if(first.start < second.start)
					return -1;
				else if(first.start > second.start)
					return 1;
				return 0;
			}
			
		});
		System.out.print("Sorted Intervals According to Start time: ");
		for(int i = 0; i < interval.length; i++)
			System.out.print(interval[i] + " ");
		
		Stack<Interval> stack = new Stack<>();
		stack.push(interval[0]);
		int i = 1;
		while(i < interval.length) {
			// If end time of top of stack is greater than start time of i'th interval, then overlapping.
			if(stack.peek().end > interval[i].start) {  // overlapping.
				Interval x = stack.pop();
				x.end = (x.end > interval[i].end) ? x.end : interval[i].end;
				stack.push(x);
			} else
				stack.push(interval[i]);
			i++;
		}
		List<Interval> result = new LinkedList<>();
		while(!stack.isEmpty())
			result.add(stack.pop());
		System.out.println();
		System.out.print("Non-Overlapping Intervals: " +  result);
		return result;
	}
	
	public static void main(String[] args) {
		Interval[] intervals = new Interval[] {
			new Interval(2,4),
			new Interval(1,3),
			new Interval(5,7),
			new Interval(5,8)
		};
		
		MergeOverlappingIntervals merge = new MergeOverlappingIntervals();
		merge.mergeOverlappingIntervals(intervals);
	}
	
}

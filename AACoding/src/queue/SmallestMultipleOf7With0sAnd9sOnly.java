package queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SmallestMultipleOf7With0sAnd9sOnly {

	/*
	 * Generate this much number of strings.
	 */
	public List<String> generate09Strings(int count) {
		List<String> list = new LinkedList<>();
		Queue<String> queue = new LinkedList<>();
		queue.add("9");
		while(count-- > 0) {
			String number = queue.poll();   // get the number.
			list.add(number);
			queue.add(number + "0");
			queue.add(number + "9");
		}		
		System.out.println(list);
		return list;
	}
	
	/*
	 * Find smallest multiple of n containing only 0 and 9.
	 */
	public int smallestMultiple(int n) {
		List<String> numList = this.generate09Strings(1000);
		for(String num : numList) {
			int number = Integer.valueOf(num);
			if(number % n == 0)
				return number;
		}
		return -1;		
	}
	
	public static void main(String[] args) {
		SmallestMultipleOf7With0sAnd9sOnly s = new SmallestMultipleOf7With0sAnd9sOnly();
		int number = s.smallestMultiple(7);
		System.out.println(number);
	}
	
}

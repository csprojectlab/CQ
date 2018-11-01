package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheckIfMultipleOf3 {

	public int isMultiple(int[] arr) {
		Arrays.sort(arr);   // Increasing order.
		Queue<Integer> queue0 = new LinkedList<>();
		Queue<Integer> queue1 = new LinkedList<>();
		Queue<Integer> queue2 = new LinkedList<>();
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if(arr[i] % 3 == 0)
				queue0.add(arr[i]);
			else if(arr[i] % 3 == 1)
				queue1.add(arr[i]);
			else
				queue2.add(arr[i]);
		}
		if(sum % 3 == 1) {
			if(!queue1.isEmpty()) {
				queue1.poll();
			} else {
				if(queue2.size() < 2)
					return -1;
				queue2.poll();
				queue2.poll();
			}
		} else if(sum % 3 == 2) {
			if(!queue2.isEmpty())
				queue2.poll();
			else {
				if(queue1.size() < 2)
					return -1;
				queue1.poll();
				queue1.poll();
			}
		}
		
		int result[] = new int[queue0.size() + queue1.size() + queue2.size()];
		int index = 0;
		while(!queue0.isEmpty())
			result[index++] = queue0.poll();
		while(!queue1.isEmpty())
			result[index++] = queue1.poll();
		while(!queue2.isEmpty())
			result[index++] = queue2.poll();
		Arrays.sort(result);
		int number = 0;
		for(int j = 0; j < result.length; j++)
			number += result[j];
		System.out.println(number);
		return number;
	}
	
	public static void main(String[] args) {
		CheckIfMultipleOf3 c = new CheckIfMultipleOf3();
		int[] arr = new int[] {5,5,2,7};
		c.isMultiple(arr);
	}
	
}

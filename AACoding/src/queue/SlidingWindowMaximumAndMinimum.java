package queue;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Maximum and  minimum of all sub-arrays of size k.
 */
public class SlidingWindowMaximumAndMinimum {

	// {1,2,3,1,4,5,2,3,6}
	public int[] maxOfAllSubarrays(int[] arr, int k) {
		int[] result = new int[arr.length - k + 1];
		int index = 0;   // for result.
		Deque<Integer> dqueue = new LinkedList<>();
		int i = 0;
		while(i < k) {
			while(!dqueue.isEmpty() && arr[i] >= arr[dqueue.peekLast()])
				dqueue.pollLast();
			dqueue.addLast(i);
			i++;
		}
		while(i < arr.length) {
			result[index++] = arr[dqueue.peekFirst()];
			// Now remove the elements out of the window.
			while(!dqueue.isEmpty() && dqueue.peekFirst() <= i - k)
				dqueue.pollFirst();
			// Remove the smallest elements than the new element.
			while(!dqueue.isEmpty() && arr[i] >= arr[dqueue.peekLast()])
				dqueue.pollLast();
			dqueue.addLast(i);			
			i++;
		}
		result[index] = arr[dqueue.peekFirst()];
		System.out.print("Maximum of all subarrays of size K: ");
		util.Util.print(result);
		return result;
	}
	
	public int[] minOfAllSubarrays(int[] arr, int k) {
		int[] result = new int[arr.length - k + 1];
		int index = 0;
		Deque<Integer> dqueue = new LinkedList<>();
		int i = 0;
		while(i < k) {
			while(!dqueue.isEmpty() && arr[i] <= arr[dqueue.peekLast()])
				dqueue.pollLast();
			dqueue.addLast(i);
			i++;
		}
		while(i < arr.length) {
			result[index++] = arr[dqueue.peekFirst()];
			while(!dqueue.isEmpty() && dqueue.peekFirst() <= i - k)
				dqueue.pollFirst();
			while(!dqueue.isEmpty() && arr[i] <= arr[dqueue.peekLast()])
				dqueue.pollLast();
			dqueue.addLast(i);
			i++;
		}
		result[index] = arr[dqueue.pollFirst()];
		System.out.print("Minimum of all subarrays of size K: ");
		util.Util.print(result);
		return result;
		
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,1,4,5,2,3,6};
		int k = 3;
		SlidingWindowMaximumAndMinimum s = new SlidingWindowMaximumAndMinimum();
		s.maxOfAllSubarrays(arr, k);
		s.minOfAllSubarrays(arr, k);
	}
	
}

package queue;

import java.util.Deque;
import java.util.LinkedList;

public class FirstNegativeIntegerInEveryWindowOfSizeK {

	public int[] firstNegative(int[] arr, int k) {
		int[] result = new int[arr.length - k + 1];
		int index = 0;
		// Using deque is not neccessay.  Queue can be used here.
		Deque<Integer> dqueue = new LinkedList<>();
		int i = 0;
		while(i < k) {
			if(arr[i] < 0)
				dqueue.addLast(i);
			i++;
		}
		// By this point the queue may even be empty as there may not be any negative number found till now.
		while(i < arr.length) {
			// Getting the result for the previous window.
			if(dqueue.isEmpty())
				result[index++] = 0;
			else 
				result[index++] = arr[dqueue.peekFirst()];
			// delete the out of window numbers.
			while(!dqueue.isEmpty() && dqueue.peekFirst() <= i - k)
				dqueue.pollFirst();
			if(arr[i] < 0)
				dqueue.addLast(i);
			i++;
		}
		// getting the result for the last window.
		if(dqueue.isEmpty())
			result[index] = 0;
		else
			result[index] = arr[dqueue.pollFirst()];
		util.Util.print(result);
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {-8, 2, 3, -6, 10};
		int[] arr1 = new int[] {12, -1, -7, 8, -15, 30, 16, 28};	
		int k = 2;   // window size.
		int k1 = 3;
		FirstNegativeIntegerInEveryWindowOfSizeK f = new FirstNegativeIntegerInEveryWindowOfSizeK();
		f.firstNegative(arr, k);
		f.firstNegative(arr1, k1);
	}
}

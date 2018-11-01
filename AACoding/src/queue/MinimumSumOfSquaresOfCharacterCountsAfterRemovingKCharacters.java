package queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Remove characters of highest frequency to get minimum sum of squares.
 */
public class MinimumSumOfSquaresOfCharacterCountsAfterRemovingKCharacters {

	public int minSumOfSquares(char[] arr, int k) {
		int[] frequency = new int[26];
		for(int i = 0; i < arr.length; i++)
			frequency[arr[i] - 'a']++;   // Counting the frequencies.
		PriorityQueue<Integer> pqueue = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer first, Integer second) {
				if(second < first)
					return -1;
				else if(second > first)
					return 1;
				return 0;
			}
		});
		// Adding all frequencies to the queue.
		for(int i = 0; i < frequency.length; i++)
			if(frequency[i] != 0)
				pqueue.add(frequency[i]);
		System.out.println("Frequency count in queue: " + pqueue);
		while(k-- > 0) {
			int highest = pqueue.poll();
			highest--;
			pqueue.add(highest);
		}
		System.out.println("Afer applying operations: " + pqueue);
		int count = 0;
		while(!pqueue.isEmpty()) {
			int value = pqueue.poll();
			count += value*value;
		}
		System.out.println(count);
		return count;
	}
	
	public static void main(String[] args) {
		String string = "abccc";
		int k = 2;
		String s1 = "aaab";   
		int k1 = 2;   // after removing a and then again a. we are left with ab.
		MinimumSumOfSquaresOfCharacterCountsAfterRemovingKCharacters m = new MinimumSumOfSquaresOfCharacterCountsAfterRemovingKCharacters();
		m.minSumOfSquares(string.toCharArray(), k);
	}
}

package backtracking;

import java.util.LinkedList;
import java.util.List;

// N = 254, K = 1   Then output = 524
// N = 254, K = 2   Then output = 542

public class MaximumNumberPossibleWithKSwaps {

	public int[] toArray(int number) {
		List<Integer> list = new LinkedList<>();
		while(number > 0) {
			list.add(number % 10);
			number = number / 10;
		}
		int size = list.size();
		int[] arr = new int[size];
		for(int i = size - 1; i >= 0; i--)
			arr[i] = list.get(size - i - 1);
		return arr;		
	}
	
	public void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public int convertToNumber(int[] arr) {
		int number = 0;
		for(int i = 0; i < arr.length; i++) 
			number = number*10 + arr[i];
		return number;
	}
	
	public int findMaximumPossibleNumber(int N, int k) {
		int[] arr = this.toArray(N);
		if(k >= arr.length) {
			System.out.println(k + " swaps cannot be applied on the number " + N);
			return -1;
		}
		return this.findMax(arr, 0, k);
	}
	
	public int findMax(int[] arr, int index, int k) {
		if(k == 0) 
			return this.convertToNumber(arr);
		int max = Integer.MIN_VALUE;
		for(int i = index + 1; i < arr.length; i++) {  // Start swapping from this index.
			this.swap(index, i, arr);    // Swap index with all digits.
			int currentMax = this.findMax(arr, index + 1, k-1);
			max = Math.max(max, currentMax);
			this.swap(index, i, arr);  // backtrack.
		}
		return max;
	}
	
	public static void main(String[] args) {
		MaximumNumberPossibleWithKSwaps m = new MaximumNumberPossibleWithKSwaps();
		System.out.println(m.findMaximumPossibleNumber(7599, 1));
	}
	
}

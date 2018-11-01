package arrays;

import java.util.Arrays;

public class CheckForPairWithSumInAnArray {

	public boolean checkSumPair(int[] arr, int sum) {
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length - 1;
		while(left < right) {
			int calSum = arr[left] + arr[right];
			if(calSum == sum) 
				return true;
			if(calSum > sum)
				right--;
			else if(calSum < sum)
				left++;
		}
		return false;
	}
	
	public static void main(String[] args) {
		CheckForPairWithSumInAnArray c = new CheckForPairWithSumInAnArray();
		int[] arr = new int[] {65,34,23,11,77};   // Simple array.
		System.out.println(c.checkSumPair(arr, 88));
	}
	
}

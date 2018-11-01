package arrays;

import java.util.Arrays;

public class FindNumbersWithSumClosestToZero {

	public void findNumbers(int[] arr) {
		Arrays.sort(arr);   // sort the array.
		util.Util.print(arr);
		int left = 0;
		int right = arr.length - 1;
		int minLeft = -1;
		int minRight = -1;
		int sum = Integer.MAX_VALUE;
		int currentSum = 0;
		while(left < right) {
			currentSum = arr[left] + arr[right];
			if(Math.abs(currentSum) < Math.abs(sum)) {
				sum = currentSum;
				minLeft = left;
				minRight = right;
			}
			if(currentSum < 0)
				left++;
			else 
				right--;
		}
		System.out.println("Sum close to zero: (" + arr[minLeft] + "," + arr[minRight] + ") : " + sum);
	}
	
	public static void main(String[] args) {
		FindNumbersWithSumClosestToZero f = new FindNumbersWithSumClosestToZero();
		int[] arr = new int[] {1, 60, -10, 70, -80, 85};
		f.findNumbers(arr);
	}
}

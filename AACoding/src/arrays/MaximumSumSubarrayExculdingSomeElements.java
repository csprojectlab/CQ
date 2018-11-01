package arrays;


/// Exclude array is sorted array.
public class MaximumSumSubarrayExculdingSomeElements {

	public int binarySearch(int[] arr, int key, int start, int end) {
		if(start > end)
			return -1;
		int mid = (start + end) / 2;
		if(arr[mid] == key)
			return mid;
		if(key < arr[mid])
			return this.binarySearch(arr, key, start, mid-1);
		return this.binarySearch(arr, key, mid+1, end);
	}
	
	
	// Modification of kadane's algorithm.
	public int getMaxSumSubarray(int[] arr, int[] exclude) {
		int sum = 0;
		int currentSum = 0;
		for(int i = 0; i < arr.length; i++) {
			if(this.binarySearch(exclude, arr[i], 0, exclude.length-1) == -1)  // Check consideration. 
				currentSum += arr[i];
			if(currentSum < 0)
				currentSum = 0;
			sum = Math.max(currentSum, sum);
		}
		System.out.println("Max Sum: " + sum);
		return sum;
	}
	
	public static void main(String[] args) {
		MaximumSumSubarrayExculdingSomeElements m = new MaximumSumSubarrayExculdingSomeElements();
		int[] arr = new int[] {3,4,5,-4,6};
		int[] exc = new int[] {1,5,6,8};   // Give in sorted form.
		m.getMaxSumSubarray(arr, exc);
	}
}

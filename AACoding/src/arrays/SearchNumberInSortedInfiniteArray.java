package arrays;

public class SearchNumberInSortedInfiniteArray {

	
	// Consider the array as of infinite length.
	public int searchNumber(int[] arr, int key) {
		// Array is infinite. Therefore we can't get the upper bound to apply binary search.
		int low = 0;
		int high = 1;
		while(key > arr[high]) {
			low = high;
			high <<= 1;
		}
		// Apply binarySearch on array between low and high.
		return -1;
	}
	
}

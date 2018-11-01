package arrays;

public class FindMinimumElementInSortedAndRotatedArray {

	
	public int findPivot(int[] arr, int low, int high) {
		if(high < low)
			return -1;
		if(high == low)
			return low;
		int mid = (low + high) / 2;
		if(mid < high && arr[mid] > arr[mid+1])
			return mid;
		if(mid > low && arr[mid] < arr[mid-1])
			return mid-1;
		if(arr[low] <= arr[mid])
			return this.findPivot(arr, mid+1, high);
		return this.findPivot(arr, low, mid-1);
	}
	
	public int findMinimum(int[] arr) {
		int pivot = this.findPivot(arr, 0, arr.length-1);
		if(pivot == -1)   // If the array is sorted but not rotated.
			return arr[0];
		return arr[pivot+1];
	}
	
	public static void main(String[] args) {
		int arr[] = new int[] {5,6,7,8,9,10,2,3,4};
		FindMinimumElementInSortedAndRotatedArray m = new FindMinimumElementInSortedAndRotatedArray();
		System.out.println(m.findMinimum(arr));
	}
}

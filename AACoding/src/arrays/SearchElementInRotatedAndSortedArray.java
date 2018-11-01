package arrays;


// Do it in O(log n)
public class SearchElementInRotatedAndSortedArray {

	public int binarySearch(int[] arr, int low, int high, int key) {
		if(high < low)
			return -1;
		int mid = (low + high) / 2;
		if(key == arr[mid])
			return mid;
		if(key < arr[mid])
			return this.binarySearch(arr, low, mid-1, key);
		return this.binarySearch(arr, mid+1, high, key);
	}

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
	
	public int findIndex(int[] arr, int key) {
		int pivot = this.findPivot(arr, 0, arr.length-1);
		if(key < arr[0])
			return this.binarySearch(arr, pivot+1, arr.length-1, key);
		return this.binarySearch(arr, 0, pivot, key);
	}
	
	public static void main(String[] args) {
		SearchElementInRotatedAndSortedArray s = new SearchElementInRotatedAndSortedArray();
		int arr[] = new int[] {5,6,7,8,9,10,1,2,3,4};
		for(int i = 0; i < arr.length; i++) {
			System.out.println("Index of " + arr[i] + ": " + s.findIndex(arr, arr[i]));
		}
		
	}
	
}

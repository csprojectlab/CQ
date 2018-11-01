package arrays;

public class RotationCountInSortedRotatedArray {
	
	public int findPivot(int[] arr, int low, int high) {
		if(low >= high)
			return -1;
		int mid = (low + high) / 2;
		if(mid < high && arr[mid] > arr[mid+1])
			return mid;
		if(mid > low && arr[mid] < arr[mid-1])
			return mid-1;
		if(arr[low] <= arr[mid])
			return this.findPivot(arr, mid+1, high);
		return this.findPivot(arr, low, mid-1);
	}

	public int rotationCount(int[] arr) {
		int pivot = this.findPivot(arr, 0, arr.length-1);
		if(pivot == -1)
			return 0;
		return pivot+1;   // this is equal to the rotation count.
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {14,15,16,2,3,6,12};
		RotationCountInSortedRotatedArray r = new RotationCountInSortedRotatedArray();
		System.out.println(r.rotationCount(arr));
	}
}

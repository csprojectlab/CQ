package divideandconquer;

/*
 * Peak Element: Element which is greater than its neighbors.(both left and right)
 * The array is not sorted. But still we will use the binary search approach.
 * There can be more than one peak element in the array.
 */
public class PeakElement {
	
	public int peakElement(int[] arr, int low, int high) {
		if(low == high) 
			return arr[low];
		int mid = (low + high) / 2;
		if((mid == 0 || arr[mid-1] < arr[mid]) && (mid == arr.length - 1 || arr[mid+1] < arr[mid]))
			return arr[mid];
		else if(mid - 1 >= 0 && arr[mid-1] > arr[mid])
			return this.peakElement(arr, low, mid-1);
		return this.peakElement(arr, mid+1, high);
	}
	
	public int peakElement(int[] arr) {
		return this.peakElement(arr, 0, arr.length-1);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {10,20,15,2,23,90,67};
		PeakElement p = new PeakElement();
		System.out.println(p.peakElement(arr));
	}

}

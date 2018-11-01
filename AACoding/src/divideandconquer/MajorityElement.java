package divideandconquer;

public class MajorityElement {

	/*
	 * Returns the first occurrence of the key.
	 */
	public int enhancedBinarySearch(int[] arr, int low, int high, int key) {
		
		if(high >= low) {
			int mid = (low + high) / 2;
			if((mid == 0 || key > arr[mid-1]) && arr[mid] == key)
				return mid;
			else if(key <= arr[mid])   // Lesser than or equal condition is necessary
				return this.enhancedBinarySearch(arr, low, mid-1, key);
			return this.enhancedBinarySearch(arr, mid+1, high, key);
		}
		System.out.println(low + " " +  high);
		return -1;
	}
	
	/*
	 * Check if this element is majority element or not. Array is sorted.
	 */
	public boolean isMajorityElement(int[] arr, int key) {
		// Find the index of the element.
		int index = this.enhancedBinarySearch(arr, 0, arr.length-1, key);
		System.out.println("First occurrence of key: " + index);
		if(index == -1)
			return false;
		if(index + (arr.length/2) < arr.length && arr[index + arr.length/2] == key)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,1,2,4,4,4,4,4,6,6};
		MajorityElement m = new MajorityElement();
		boolean ans = m.isMajorityElement(arr, 4);
		System.out.println(ans);
	}
	
}

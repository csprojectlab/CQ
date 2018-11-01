package divideandconquer;

public class ClosestNumberInArray {

	public int getClosest(int first, int second, int key) {
		if(Math.abs(key - first) > Math.abs(key - second))
			return first;
		return second;
	}
	
	public int closestElement(int[] arr, int key, int low, int high) {
		if(low == high)
			return arr[low];
		int mid = (low + high) / 2;
		if(arr[mid] == key)
			return arr[mid];
		// closest can be either on the left or the right side.
		// 1 |2| 4     closest is at the right side when the key is 5.
		if(key < arr[mid]) {
			if(mid - 1 >= low && key > arr[mid-1])
				return this.getClosest(arr[mid-1], arr[mid], key);
			return this.closestElement(arr, key, low, mid+1);
		} else {   // key is greater than mid.
			if(mid + 1 <= high && key < arr[mid+1])
				return this.getClosest(arr[mid+1], arr[mid], key);
			return this.closestElement(arr, key, mid+1, high);
		}
	}
	
	
	/*
	 * Finds the closest element to the key in the array. Array is sorted already.
	 */
	public int closestElement(int[] arr, int key) {
		return this.closestElement(arr, key, 0, arr.length - 1);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,4,6,7,9,10};
		ClosestNumberInArray c = new ClosestNumberInArray();
		System.out.println(c.closestElement(arr, 11));
	}
	
}

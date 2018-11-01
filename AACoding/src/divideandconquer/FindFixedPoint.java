package divideandconquer;

import javax.swing.tree.FixedHeightLayoutCache;

/*
 * Point where value is equal to the index.
 * Array is sorted.
 */
public class FindFixedPoint {

	public int fixedPointValue(int[] arr, int low, int high) {
		if(low == high)
			return arr[low];
		int mid = (low + high) / 2;
		if(mid == arr[mid])  // value and index match.
			return arr[mid];
		if(mid > arr[mid] - 1)  // My answer is lying on the right side.
			return this.fixedPointValue(arr, mid+1, high);
		return this.fixedPointValue(arr, low, mid-1);
	}
	
	public int fixedPointValue(int[] arr) {
		return this.fixedPointValue(arr, 0, arr.length - 1);
	}
	
	
	public static void main(String[] args) {
		int[] arr = new int[] {-10,-5,0,3,7};
		int[] arr1 = new int[] {0,2,5,8,17};
		FindFixedPoint f = new FindFixedPoint();
		System.out.println(f.fixedPointValue(arr1));
	}
}

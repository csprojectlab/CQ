package divideandconquer;

public class FloorInSortedArray {

	public int floorOf(int[] arr, int key, int low, int high) {
		if(low == high)
			return arr[low];
		{
			int mid = (low + high) / 2;   // Overflow may happen for large values.
			if(arr[mid] ==  key)
				return arr[mid];
			if(mid - 1 >= low && key > arr[mid - 1] && key < arr[mid])
				return arr[mid - 1];
			if(mid + 1 <= high && key > arr[mid] && key < arr[mid + 1])
				return arr[mid];
			if(key < arr[mid])
				return this.floorOf(arr, key, low, mid - 1);
			return this.floorOf(arr, key, mid + 1, high);
		}
	}
	
	public int floorOf(int[] arr, int x) {
		return this.floorOf(arr, x, 0, arr.length - 1);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,8,10,10,12,19};
		int key = 11;
		System.out.println(new FloorInSortedArray().floorOf(arr, key));
	}
}

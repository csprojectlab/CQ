package arrays;

public class ShortestUnorderedSubArray {

	public boolean increasing(int[] arr, int start, int end) {
		for(int i = start; i < end; i++)
			if(arr[i+1] < arr[i])
				return false;
		return true;
	}
	
	public boolean decreasing(int[] arr, int start, int end) {
		for(int i = start; i < end; i++)
			if(arr[i] > arr[i+1])
				return false;
		return true;
	}
	
	// Can be either 0 or 3.
	public void unorderedSubarray(int[] arr) {
		int start = -1;   // start of shortest subarray.
		int end = -1;   // end of subarray.
		for(int i = 0; i < arr.length - 2; i++) {
			if(!(this.increasing(arr, i, i+2) || this.decreasing(arr, i, i+2))) {
				start = i;
				end = i + 2;
				break;
			}
		}
		if(start != -1)
			System.out.println("Unordered subarray exist: (" + arr[start] + "_ _ _" + arr[end] + ")");
		else
			System.out.println("No unrodered subarray exist.");
	}
	
	public static void main(String[] args) {
		ShortestUnorderedSubArray s = new ShortestUnorderedSubArray();
		int[] arr = new int[] {7,9,10,8,11};
		s.unorderedSubarray(arr);
	}
}

package arrays;

public class FindContiguousSubArrayWithGivenSum {

	public void findSubArray(int[] arr, int sum) {
		int left = 0;
		int right = 1;
		int currentSum = arr[left];
		while(left <= right && right < arr.length) {
			if(currentSum < sum) {
				currentSum += arr[right];
				right++;
			} else if(currentSum > sum) {
				currentSum -= arr[left];
				left++;
			} else {
				System.out.println("Start: " + left + " , End: " + (right-1));
				break;
			}
		}		
		if(left == 0 && right == arr.length)   // Given sum is greater than sum of all the elements of the array.
			System.out.println("No subarray found.");
		else if(left > right)
			System.out.println("Given sum is negative. No such subarray exist.");
	}
	
	public static void main(String[] args) {
		FindContiguousSubArrayWithGivenSum f = new FindContiguousSubArrayWithGivenSum();
		int[] arr = new int[] {1,4,20,3,10,5};
		int[] a = new int[] {1,4};
		f.findSubArray(a, -1);
		f.findSubArray(arr, 33);
	}
}

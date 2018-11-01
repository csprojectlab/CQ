package arrays;

public class LargestPairSumInUnsortedArray {

	public int findLargestPairSum(int[] arr) {
		int sum = arr[0] + arr[1];
		int min = Math.min(arr[0], arr[1]);
		for(int i = 0; i < arr.length; i++) {
			if(sum - arr[i] < min) {
				sum = sum - min + arr[i];
				min = sum - arr[i];
			}			
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {12, 34, 10, 6, 40};
		LargestPairSumInUnsortedArray l = new LargestPairSumInUnsortedArray();
		System.out.println(l.findLargestPairSum(arr));   // 74 : 34 + 40.
	}
	
}

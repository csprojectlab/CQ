package arrays;


// Kadane's algorithm.
public class LargestSumContiguousSubArray {

	public int largestSum(int[] arr) {
		int sum = 0;
		int currentSum = 0;
		for(int i = 0; i < arr.length; i++) {
			currentSum = currentSum + arr[i];
			if(currentSum < 0)
				currentSum = 0;
			else
				if(currentSum > sum)
					sum = currentSum;
		}
		System.out.print(sum);
		return sum;
	}
	
	public static void main(String[] args) {
		LargestSumContiguousSubArray l = new LargestSumContiguousSubArray();
		int[] arr = new int[] {-2,-3,4,-1,-2,1,5,-3};
		l.largestSum(arr);
	}
	
}

package dynamic;

public class MinimumSumIncreasingSubsequence {

	public int minSumIncreasingSubsequence(int[] arr) {
		int[] k = new int[arr.length];
		// Fill with initial value.
		for(int i = 0; i < arr.length; i++)
			k[i] = arr[i];
		for(int i = 1; i < k.length; i++) {
			for(int j = 0; j < k.length; j++) {
				// Process if the sequence is increasing.
				if(arr[i] > arr[j]) {
					// If I don't consider the j'th position element, If I consider the element.
					k[i] = Math.max(k[i], k[j] + arr[i]);
				}
			}
		}
		util.Util.print(k);
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < k.length; i++)
			if(k[i] > max)
				max = k[i];
		System.out.println("Maximum Sum Increasing subsequence is of sum: " + max);
		return max;
	}
	
	public static void main(String[] args) {
		MinimumSumIncreasingSubsequence s = new MinimumSumIncreasingSubsequence();
		int[] arr = new int[] {4,6,1,3,8,4,6};
		s.minSumIncreasingSubsequence(arr);
	}
	
}

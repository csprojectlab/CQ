package dynamic;

public class LongestIncreasingSubsequence {

	public int longestIncreasingSubsequence(int[] arr) {
		// Create array of the same size.
		int[] k = new int[arr.length];
		for(int i = 0; i < k.length; i++)
			k[i] = 1;    
		for(int i = 1; i < k.length; i++) {
			int j = 0;
			while(j < i) {
				if(arr[j] < arr[i])
					k[i] = Math.max(k[i], 1 + k[j]);  // Present value, from j'th index.				
				j++;
			}
		}
		util.Util.print(k);
		// Length is the max from this array.
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < k.length; i++)
			if(max < k[i])
				max = k[i];
		
		System.out.println("Length of longest increasing subsequence: " + max);
		return max;
	}
	
	public static void main(String[] args) {
		LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
		int[] arr = new int[] {3,4,-1,0,6,2,3};
		l.longestIncreasingSubsequence(arr);
	}
	
}

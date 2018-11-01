package dynamic;

public class LongestBitonicSubsequence {

	public int longestBitonicSubsequence(int[] arr) {
		int[] k1 = new int[arr.length];
		for(int i = 0; i < k1.length; i++)
			k1[i] = 1;
		for(int i = 1; i < arr.length; i++) {
			int j = 0;
			while(j < i) {
				if(arr[j] < arr[i])
					k1[i] = Math.max(k1[i], 1 + k1[j]);
				j++;
			}
		}
		util.Util.print(k1);
		
		// Finding from right to left.
		int[] k2 = new int[arr.length];
		for(int i = 0; i < k2.length; i++)
			k2[i] = 1;
		for(int i = arr.length - 2; i >= 0; i--) {
			int j = arr.length - 1;
			while(j > i) {
				if(arr[j] < arr[i])
					k2[i] = Math.max(k2[i], 1 + k2[j]);
				j--;
			}
		}
		util.Util.print(k2);
		
//		for(int i = 0; i < k1.length; i++)
//			k1[i] = k1[i] + k2[i] - 1;   // Subtracting 1 because element is counted twice.
//		
//		System.out.print("Bitonic array: ");
//		util.Util.print(k1);
		
		int max = k1[0] + k2[0] - 1;
		for(int i = 1; i < k1.length; i++) {
			if(k1[i] + k2[i] - 1 > max)
				max = k1[i] + k2[i] - 1;
		}
		System.out.println("Maximum Bitonic subsequence is of length: " + max);
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {12, 11, 40, 5, 3, 1};
		LongestBitonicSubsequence l = new LongestBitonicSubsequence();
		l.longestBitonicSubsequence(arr);
	}
}

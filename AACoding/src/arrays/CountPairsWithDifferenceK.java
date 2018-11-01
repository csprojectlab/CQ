package arrays;

import java.util.Arrays;


// Input numbers are of the range 1 to n.
public class CountPairsWithDifferenceK {

	public void countPairs(int[] arr, int K) {
		Arrays.sort(arr);
		int index = 0;
		while(index + K < arr.length) {
			System.out.println("(" + arr[index] + "," + arr[index+K] + ")");
			index++;
		}
	}
	
	public static void main(String[] args) {
		CountPairsWithDifferenceK c = new CountPairsWithDifferenceK();
		int[] arr = new int[] {2,4,3,5,1};
		int K = 3;
		c.countPairs(arr, K);
	}
}

package dynamic;

public class MatrixChainMultiplication {
	
	public int minCost(int[] arr) {
		int k[][] = new int[arr.length-1][arr.length-1];
		// Initially all values are zero.
		// We will pick length wise.
		int len = 1;   // Means pick two matrices at a time.
		while(len < arr.length) {   // pick len+1 matrices at a time.
			int i = 0;
			int j = i + len;
			while(i < k.length - len) {
				// Multiply left side with the last element, multiply first element with the right side.
				k[i][j] = Math.min(k[i][j-1] + arr[i]*arr[j]*arr[j+1], k[i+1][j] + arr[i]*arr[i+1]*arr[j+1]);
				i++;
				j++;
			}
			len++;
		}
		util.Util.printMatrix(k);
		System.out.println("Minimum Cost: " + k[0][k[0].length-1]);
		return k[0][k[0].length-1];
	}
	
	public static void main(String[] args) {
		MatrixChainMultiplication m = new MatrixChainMultiplication();
		int[] arr = new int[] {2,3,6,4,5};   // 124.
		m.minCost(arr);
	}
}

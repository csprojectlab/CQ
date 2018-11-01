package dynamic;

public class WaysToReachFromTopLeftToBottomRight {

	public int totalWays(int size) {
		int[][] k = new int[size][size];
		for(int i = 0; i < size; i++) {
			k[0][i] = 1;
			k[i][0] = 1;
		}
		for(int i = 1; i < k.length; i++) 
			for(int j = 1; j < k[i].length; j++) 
				k[i][j] = k[i-1][j] + k[i][j-1];
		util.Util.printMatrix(k);
		System.out.println("Total ways to reach end: " + k[k.length-1][k[0].length-1]);
		return k[k.length-1][k[0].length-1];
	}
	
	public static void main(String[] args) {
		int matrixSize = 3;
		WaysToReachFromTopLeftToBottomRight w = new WaysToReachFromTopLeftToBottomRight();
		w.totalWays(matrixSize);
	}
	
}

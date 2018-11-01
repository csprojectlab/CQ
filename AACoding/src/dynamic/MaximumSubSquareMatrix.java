package dynamic;

public class MaximumSubSquareMatrix {

	public int maxSubSquare(int[][] matrix) {
		int[][] k = new int[1+matrix.length][1+matrix[0].length];
		for(int i = 1; i < k.length; i++) {
			for(int j = 1; j < k[i].length; j++) {
				if(matrix[i-1][j-1] == 0)
					k[i][j] = 0;
				else {   
					k[i][j] = 1 + Math.min(k[i-1][j], Math.min(k[i][j-1], k[i-1][j-1]));
				}
			}
		}
		util.Util.printMatrix(k);
		// Finding max from the k.
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < k.length; i++)
			for(int j = 1; j < k[i].length; j++)
				if(k[i][j] > max)
					max = k[i][j];
		System.out.println("Maximum Sub Square Matrix: " + max);
		return max;
	}
	
	public static void main(String[] args) {
		MaximumSubSquareMatrix m = new MaximumSubSquareMatrix();
		int[][] matrix = new int[][] {
			{0,0,1,1,1}, {1,0,1,1,1}, {0,1,1,1,1}, {1,0,1,1,1}
		};
		m.maxSubSquare(matrix);
	}
	
}

package dynamic;

public class MinimumCostPath {

	// We can only move right and bottom.
	public int minCostPath(int[][] m) {
		int[][] k = new int[m.length][m[0].length];
		// Fill the first row and first column with sum.
		k[0][0] = m[0][0];
		for(int i = 1; i < m[0].length; i++) 
			k[0][i] = k[0][i-1] + m[0][i];
		for(int i = 1; i < m.length; i++)
			k[i][0] = k[i-1][0] + m[i][0];
		
		for(int i = 1; i < k.length; i++) {
			for(int j = 1; j < k[i].length; j++) {
				// Coming from top and left.
				k[i][j] = m[i][j] + Math.min(k[i-1][j], k[i][j-1]);
			}
		}
		
		util.Util.printMatrix(k);
		System.out.println("Minimum Cost: " + k[k.length-1][k[0].length-1]);
		return k[k.length-1][k[0].length-1];
	}
	
	public static void main(String[] args) {
		MinimumCostPath p = new MinimumCostPath();
		int[][] m = new int[][] {
			{1,3,5,8},{4,2,1,7},{4,3,2,3}
		};
		p.minCostPath(m);
	}
	
}

package dynamic;

public class CuttingRodToMaximizeProfit {

	public int maxProfit(int[] length, int[] value, int maxLen) {
		int[][] k = new int[1+length.length][1+maxLen];
		// 0'th row and column are already zero.
		for(int i = 1; i < k.length; i++) {
			for(int j = 1; j < k[i].length; j++) {
				if(length[i-1] > j)  // Rod of this length can't be compensated.
					k[i][j] = k[i-1][j];
				else {
					// don't take this size, take this size.
					k[i][j] = Math.max(k[i-1][j], value[i-1] + k[i][j-length[i-1]]);
				}
			}
		}
		util.Util.printMatrix(k);
		System.out.println("Maximum profit: " + k[k.length-1][k[0].length-1]);
		return k[k.length-1][k[0].length-1];
	}
	
	public static void main(String[] args) {
		CuttingRodToMaximizeProfit c = new CuttingRodToMaximizeProfit();
		int[] length = new int[] {1,2,3,4};
		int[] value = new int[] {2,5,7,8};
		int maxLen = 5;
		c.maxProfit(length, value, maxLen);
	}
	
}

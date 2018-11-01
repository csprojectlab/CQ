package dynamic;

/*
 * Number of ways in which we can get a total using coins
 */
public class CoinChangingWays {

	public int numberOfWays(int[] coins, int total) {
		int[][] k = new int[1+coins.length][1+total];
		// 0'th row.
		// all are already zero's.
		// 0'th column.
		for(int i = 0; i < k.length; i++)
			k[i][0] = 1;
		for(int i = 1; i < k.length; i++) {
			for(int j = 1; j < k[i].length; j++) {
				if(coins[i-1] > j)   // Coin can't be compensated.
					k[i][j] = k[i-1][j];
				else {
					// number of ways without using this coin + number of ways by using this coin
					k[i][j] = k[i-1][j] + k[i][j-coins[i-1]];
				}
			}
		}
		util.Util.printMatrix(k);
		System.out.println("Total number of ways: " + k[k.length-1][k[0].length-1]);
		return k[k.length-1][k[0].length-1];
	}
	
	public static void main(String[] args) {
		CoinChangingWays c = new CoinChangingWays();
		int[] coins = new int[] {1,2,3};
		int total = 5;
		c.numberOfWays(coins, total);
	}
}

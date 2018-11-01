package dynamic;

import java.util.HashSet;
import java.util.Set;

public class CoinChangingProblem {
	
	public Set<Integer> getCoins(int[][] k, int[] coins) {
		Set<Integer> coinSet = new HashSet<>();
		int i = k.length - 1;
		int j = k[i].length - 1;
		while(j != 0) {
			if(k[i][j] == k[i-1][j])
				i--;
			else {
				coinSet.add(coins[i-1]);
				j -= coins[i-1];
				i--;
			}
		}		
		System.out.println("Coins selected: " + coinSet);
		return coinSet;
	}

	public int minCoinsRequired(int[] coins, int total) {
		int[][] k = new int[1+coins.length][1+total];
		// All values are initially zero.
		for(int i = 0; i < k.length; i++) 
			for(int j = 1; j < k[i].length; j++)
				k[i][j] = Integer.MAX_VALUE;
		
		for(int i = 1; i < k.length; i++) {
			for(int j = 1; j < k[i].length; j++) {
				if(coins[i-1] > j)  // Coin value can't be compensated.
					k[i][j] = k[i-1][j];
				else {
					// Don't pick the coin, pick the coin.
					k[i][j] = Math.min(k[i-1][j], 1 + k[i][j-coins[i-1]]);
				}
					
			}
		}
		util.Util.printMatrix(k);
		System.out.println("Minimum coins required: " + k[k.length-1][k[0].length-1]);
		this.getCoins(k, coins);
		return k[k.length-1][k[0].length-1];
	}

	public static void main(String[] args) {
		CoinChangingProblem c = new CoinChangingProblem();
		int[] coins = new int[] {1,5,6,8};
		int total = 8;
		c.minCoinsRequired(coins, total);
	}
}

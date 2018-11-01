package dynamic;

/*
 * 3 9 1 2 is the array.
 * If Player1 picks 3 then he make a total of 4 and loose the game.
 * If Player1 picks 2 then he make a total of 11 and win the game.
 */

public class OptimalStrategyGamePickFromEndsOfArray {

	class Pair {
		int first;
		int second;
		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
		
		public String toString() {
			return "" + first + "," + second + " ";
		}
	}

	public int maxProfit(int[] arr) {
		Pair[][] k = new Pair[arr.length][arr.length];
		// If there is only one element in the array then player1 takes the profit.
		for(int i = 0; i < k.length; i++)
			k[i][i] = new Pair(arr[i], 0);   // Second player has no profit.
		int len = 1;   // Means considering len+1 elements at a time.
		while(len < arr.length) {
			int i = 0;
			int j = i + len;
			while(i < arr.length - len) {
				// Two case arise... Either pick the i'th OR either pick the j'th.
				int firstPick = arr[i] + k[i+1][j].second;   // i + whatever will be left int the second turn
				int lastPick = arr[j] + k[i][j-1].second;
				if(firstPick > lastPick) {
					k[i][j] = new Pair(firstPick, k[i+1][j].first);
				} else 
					k[i][j] = new Pair(lastPick, k[i][j-1].first);
				i++;
				j++;
			}
			len++;
		}
		for(int i = 0; i < k.length; i++) {
			for(int j = 0; j < k[i].length; j++)
				System.out.print(k[i][j] + " ");
			System.out.println();
		}
		return -1;
	}

	public static void main(String[] args) {
		OptimalStrategyGamePickFromEndsOfArray o = new OptimalStrategyGamePickFromEndsOfArray();
		int[] arr = new int[] {3,9,1,2};
		o.maxProfit(arr);
	}

}

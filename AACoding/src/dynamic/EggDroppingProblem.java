package dynamic;

/*
 * We are finding minimum number of attempts in worst case.
 */
public class EggDroppingProblem {

	public int minimumNumberOfAttempts(int floors, int eggs) {
		int[][] k = new int[1+eggs][1+floors];
		// 0'th row and column are already zero.
		// 1's row. 1 egg 
		for(int i = 1; i < k[0].length; i++)
			k[1][i] = i;
		for(int i = 2; i < k.length; i++) {
			for(int j = 1; j < k[i].length; j++) {
				if(i > j)   // eggs are greater than floors
					k[i][j] = k[i-1][j];
				else {
					int minFactor = Integer.MAX_VALUE;
					// Throw egg from each floor.
					int f = 1;
					while(f <= j) {
						// if the egg break at floor f, if the egg doesn't break at floor f.
						minFactor = Math.min(minFactor, Math.max(k[i-1][f-1], k[i][j-f]));
						f++;
					}
					k[i][j] = 1 + minFactor;   // adding the attempt.
				}
			}
		}
		util.Util.printMatrix(k);
		System.out.println("Minimum number of attemps required in worst case: " + k[k.length-1][k[0].length-1]);
		return k[k.length-1][k[0].length-1];
	}
	
	public static void main(String[] args) {
		EggDroppingProblem e = new EggDroppingProblem();
		int eggs = 2;
		int floors = 6;
		e.minimumNumberOfAttempts(floors, eggs);
	}
	
}

package dynamic;

/*
 * Find minimum splits required such that all splits are individually palindromic
 */
public class PalindromPartitioning {

	public int minSplits(char[] string) {
		int[][] k = new int[string.length][string.length];  // This stores the splits required.
		// The result matrix is already filled with zeros
		// For string of length 1 not split is required.
		// Therefore all k[i][i] = 0;
		int len = 1;   // Start taking strings of length len + 1
		while(len < k.length) {
			int i = 0;
			int j = i + len;
			while(i < k.length - len) {
				// if the last and the first character match. No split is required.
				if(string[i] == string[j])
					k[i][j] = k[i+1][j-1];
				else {
					// Split from first ...... to the last character.
					int min = Integer.MAX_VALUE;
					for(int t = i; t < j; t++) {
						min = Math.min(min, k[i][t] + k[t+1][j]);
					}
					k[i][j] = 1 + min;   // 1 split and minimum of other splits required.
				}
				i++;
				j++;
			}
			len++;
		}
		util.Util.printMatrix(k);
		System.out.println("Minimum number of splits required: " + k[0][k[0].length-1]);
		return k[0][k[0].length-1];
	}
	
	public static void main(String[] args) {
		String string = "abcbs";   // required splits = 2.
		PalindromPartitioning p = new PalindromPartitioning();
		p.minSplits(string.toCharArray());
	}
}

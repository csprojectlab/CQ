package dynamic;

/*
 *  * means zero or more characters
 *  ? means any character with single occurrence.
 */

public class WildCardMatchingProblem {

	public boolean matchPattern(char[] string, char[] pattern) {
		boolean[][] k = new boolean[1+string.length][1+pattern.length];
		k[0][0] = true;   // Null string and null pattern are matching.
		// rest are already false;
		for(int i = 1; i < k.length; i++) {
			for(int j = 1; j < k[i].length; j++) {
				if(pattern[j-1] == '?' || pattern[j-1] == string[i-1])
					k[i][j] = k[i-1][j-1];
				else if(pattern[j-1] == '*') {
					k[i][j] = k[i][j-1] || k[i-1][j];
				} else
					k[i][j] = false;
			}
		}
		util.Util.printMatrix(k);
		return false;
	}
	
	public static void main(String[] args) {
		WildCardMatchingProblem w = new WildCardMatchingProblem();
		String pattern = "x?y*z";
		String string = "xaylmz";
		w.matchPattern(string.toCharArray(), pattern.toCharArray());
	}
	
}

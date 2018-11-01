package dynamic;

/*
 *  a* -> 0 or more occurrences of character a.
 *  .  -> matches with any character.
 *  
 *  .* -> means 0 or more occurrences with any character.
 */

public class RegularExpressionMatching {

	public boolean matchPattern(char[] string, char[] pattern) {
		// Extra row and column for null string and null pattern.
		boolean[][] k = new boolean[1+string.length][1+pattern.length];
		// All are initially false. But null string and null pattern are matching.
		k[0][0] = true;    // null string and null pattern.
		for(int i = 1; i < k.length; i++) {  // Take till i'th characters from the string.
			for(int j = 1; j < k[i].length; j++) {
				if(pattern[j-1] == '.' || pattern[j-1] == string[i-1])
					k[i][j] = k[i-1][j-1];   // characters are matching.
				else if(pattern[j-1] == '*') {
					// zero occurrences <OR> one or more occurrences.
					k[i][j] = k[i][j-2];   // zero occurrences.
					if(pattern[j-2] == '.' || pattern[j-2] == string[i-1])
						k[i][j] = k[i][j] || k[i-1][j];   // More the 0 occurrences.
				} else  // Not matching.
					k[i][j] = false;
			}
		}
		util.Util.printMatrix(k);
		System.out.println("Pattern Matching: " + k[k.length-1][k[0].length-1]);
		return k[k.length-1][k[0].length-1];
	}
	
	public static void main(String[] args) {
		RegularExpressionMatching r = new RegularExpressionMatching();
		String string = "xaabyyyyc";
		String pattern = "xa*b.*c";
		r.matchPattern(string.toCharArray(), pattern.toCharArray());
	}
	
}

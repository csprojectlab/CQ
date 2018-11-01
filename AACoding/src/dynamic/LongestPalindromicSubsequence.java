package dynamic;

public class LongestPalindromicSubsequence {

	public int longestPalindromeSequence(char[] string) {
		int[][] k = new int[string.length][string.length];
		// We solve it diagonally.
		for(int i = 0; i < k.length; i++)
			k[i][i] = 1;      
		int len = 1;    // Means take substrings of length 2.
		while(len < k.length) {
			int i = 0;
			int j = i + len;
			while(i < string.length - len) {
				if(string[i] == string[j]) {
					k[i][j] = 2 + k[i+1][j-1];   // Move right from left side and left from right side.
				} else {
					// take the first character out, take the last character out.
					k[i][j] = Math.max(k[i+1][j], k[i][j-1]);
				}
				i++;
				j++;
			}
			len++;
		}
		util.Util.printMatrix(k);
		System.out.println("Length of longest palindromic subsequence is: " + k[0][k[0].length-1]);
		return k[0][k[0].length-1];
	}
	
	public static void main(String[] args) {
		LongestPalindromicSubsequence l = new LongestPalindromicSubsequence();
		String string = "agbdba";
		l.longestPalindromeSequence(string.toCharArray());
	}
	
	
	
}

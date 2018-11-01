package dynamic;

import java.util.LinkedList;
import java.util.List;

public class LongestCommonSubsequence {

	public List<Character> findCharacters(int[][] m, char[] first, char[] second) {
		List<Character> chars = new LinkedList<>();
		int i = m.length - 1;
		int j = m[i].length - 1;
		while(m[i][j] != 0) {
			if(m[i][j] - 1 == m[i-1][j-1]) {
				chars.add(first[i-1]);
				i--;
				j--;
			} else
				i--;
		}
		System.out.println(chars);
		return chars;
		
	}
	
	public int longestCommonSubsequence(char[] first, char[] second) {
		int[][] k = new int[1 + first.length][1 + second.length];
		// All values are initially zero.
		for(int i = 1; i < k.length; i++) {   // For each character in the first string.
			for(int j = 1; j < k[i].length; j++) {  // For each character in the second string.
				if(first[i-1] == second[j-1])
					k[i][j] = 1 + k[i-1][j-1];  // lcs of the remaining string.
				else {
					// delete a character from second string, delete a character from first string.
					k[i][j] = Math.max(k[i][j-1], k[i-1][j]);
				}
			}
		}
		util.Util.printMatrix(k);
		this.findCharacters(k, first, second);
		
		return -1;
	}
	
	public static void main(String[] args) {
		LongestCommonSubsequence l = new LongestCommonSubsequence();
		String first = "abcdef";
		String second = "acbef";
		l.longestCommonSubsequence(first.toCharArray(), second.toCharArray());
	}
	
}

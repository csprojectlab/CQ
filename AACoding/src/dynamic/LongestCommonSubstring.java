package dynamic;

public class LongestCommonSubstring {

	public int longestCommonSubstring(char[] first, char[] second) {
		int[][] k = new int[1+first.length][1+second.length];
		// 0'th row and column are already zero.
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < k.length; i++) {
			for(int j = 1; j < k[i].length; j++) {
				if(first[i-1] == second[j-1]) {
					k[i][j] = 1 + k[i-1][j-1];
					max = Math.max(max, k[i][j]);
				}				
				else 
					k[i][j] = 0;
			}
		}
		util.Util.printMatrix(k);
		System.out.println("Length of longest common substring is: " + max);
		return max;
	}
	
	public static void main(String[] args) {
		LongestCommonSubstring l = new LongestCommonSubstring();
		String first = "abcdef";
		String second = "zbcdf";
		l.longestCommonSubstring(first.toCharArray(), second.toCharArray());
	}
	
}

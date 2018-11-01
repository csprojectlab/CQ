package dynamic;

public class MinimumEditDistance {

	public int minEditDistance(char[] first, char[] second) {
		int[][] k = new int[1+second.length][1+first.length];
		// first row. second string is null in this case.
		for(int i = 0; i < k[0].length; i++)
			k[0][i] = i;
		// first column. first string is null in this case.
		for(int i = 1; i < k.length; i++)
			k[i][0] = i;
		
		for(int i = 1; i < k.length; i++) {
			for(int j = 1; j < k[i].length; j++) {
				if(first[j-1] == second[i-1])  // characters match. No edit required.
					k[i][j] = k[i-1][j-1];
				else {
					// edit, delete, insert.
					k[i][j] = 1 + Math.min(k[i-1][j-1], Math.min(k[i][j-1], k[i-1][j]));
				}
			}
		}
		util.Util.printMatrix(k);
		System.out.println("Minimum Edits: " + k[k.length-1][k[0].length-1]);
		return k[k.length-1][k[0].length-1];
	}
	
	public static void main(String[] args) {
		MinimumEditDistance m = new MinimumEditDistance();
		String first = "abcdef";
		String second = "azced";
		m.minEditDistance(first.toCharArray(), second.toCharArray());
	}
	
}

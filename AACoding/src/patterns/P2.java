package patterns;

public class P2 {

	public static void makePattern(int rows) {
		for(int row = rows; row > 0; row--) {
			int spaces = row - 1;
			while(spaces-- >= 0)
				System.out.print(" " + " ");
			int currentRow = rows - row + 1;
			int limit = 2*currentRow - 1;
			while(currentRow <= limit)
				System.out.print(currentRow++ + " ");
			currentRow = rows - row + 1;
			while(limit-- > currentRow)
				System.out.print(limit + " ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		P2.makePattern(6);
	}
}

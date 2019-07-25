package patterns;

/**
 * 
 * @author Aridaman Singh Nandan
 *
 */
public class P1 {

	public static void makePattern(int rows) {
		for(int row = rows; row > 0; row--) {
			int spaces = row-1;
			for(int i = 0; i < spaces; i++)
				System.out.print(" " + " ");
			// Print till zero
			int start = rows - row;
			while(start >= 0) 
				System.out.print(start-- + " ");
			int i = 1;
			while(i <= (rows - row))
				System.out.print(i++ + " ");
			System.out.println();			
		}
	}
	
	public static void main(String[] args) {
		P1.makePattern(9);
	}
	
}

package bitwise;

// No two or more consecutive bits are set.
public class SparseOrNot {

	public static void main(String[] args) {
		int n = 3;  // Not sparse.
		if((n & (n >> 1)) != 0)
			System.out.println("NOT SPARSE");
		else
			System.out.println("SPARSE");
		
	}
	
}

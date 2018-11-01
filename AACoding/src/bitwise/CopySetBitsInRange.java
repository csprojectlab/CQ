package bitwise;


/*
 * Copy the bits which are set. Not all but only in given range.
 * l = 2 means start copying from second bit.
 */
public class CopySetBitsInRange {

	// Copy corresponding set bits of y in n which are in range.
	public static void copyBitsInRange(int n, int y, int l, int r) {
		int mask;
		for(int i = l; i <= r; i++) {
			// If the i'th bit in y is 1 then copy(because we have to copy only set bits)
			mask = 1 << (i - 1);
			if((y & mask) != 0) {   // Bit is set y.
				// Copy the bit.
				n = n | mask;
			}			
		}
		System.out.println(n);
	}
	
	public static void main(String[] args) {
		copyBitsInRange(10, 13, 2, 3);    // 14
		
	}
}

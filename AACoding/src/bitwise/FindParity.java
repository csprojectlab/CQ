package bitwise;

// Parity is 1 if number of 1's in the bits are odd.
// Otherwise it is 0.
public class FindParity {

	public static int parity(int n) {
		// Main motive is to reach the leftmost 1's in the bits.
		boolean parity = false;
		// Toggling the rightmost 1's to reach to zero.
		while(n != 0) {
			n = (n & (n - 1));
			parity = !parity;
		}
		return (parity) ? 1 : 0;
	}
	
	public static void main(String[] args) {
		System.out.println(parity(14));   
	}
}

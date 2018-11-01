package bitwise;

public class SwapTwoBits {

	public static void main(String[] args) {
		int n = 28;   // Toggling gives 21.
		int p1 = 0;
		int p2 = 3;
		
		if(p1 < 0 || p2 > 31)
			System.exit(0);
		
		// Getting the bits at positions.
		int bit1 = (n >> p1) & 1;
		int bit2 = (n >> p2) & 1;
		if((bit1 ^ bit2) != 0) {   //  Bits are different.
			n = (n ^ (1 << p1));   // Toggling the bits.
			n = (n ^ (1 << p2));
		}
		System.out.println(n);
		
		
	}
}

package bitwise;

public class SwapsBitsInANumber {

	// 3 : 0011    12: 1100
	public static void main(String[] args) {
		int n = 3;
		int p1 = 0;   // Start from first bit.
		int p2 = 2;   // Start from third bit.
		int k = 2;   // Swap three bits.
		for(int i = 0; i < k ; i++) {
			if((n & (1 << (p1 + i))) == 0 && (n & (1 << (p2 + i))) == 0)
				continue;    // Bits are same. No need to swap.
			if((n & (1 << (p1 + i))) == 1 && (n & (1 << (p2 + i))) == 1)
				continue;
			// If reach here, means the bits are different. Just toggle the bits.
			n = (n ^ (1 << (p1 + i)));
			n = (n ^ (1 << (p2 + i)));				
		}
		System.out.println(n);
	}
	
}

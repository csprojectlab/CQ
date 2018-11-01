package bitwise;

public class SwapOddAndEvenBits {

	public static int swapOddAndEvenBits(int n) {
		int oddMask = 0x55555555;
		int evenMask = 0xAAAAAAAA;
		int oddBits = n & oddMask;
		int evenBits = n & evenMask;
		oddBits <<= 1;
		evenBits >>= 1;
		return (oddBits | evenBits);
	}
	
	public static void main(String[] args) {
		System.out.println((swapOddAndEvenBits(23)));
	}
	
}

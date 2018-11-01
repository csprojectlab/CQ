package bitwise;

public class CountNumberOfBitsToBeFlippedToConvertAToB {

	public static int countFlips(int first, int second) {
		int xor = first ^ second;    // Distinct bits are set in the result.
		// Now count the number of distinct bits.
		return CountSetBitsInAInteger.countSetBits(xor);
	}
	
	public static void main(String[] args) {
		System.out.println(countFlips(2,2));
	}
	
}

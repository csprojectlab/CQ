package bitwise;


public class CountSetBitsInAInteger {

	public static int countSetBits(int number) {
		int mask = 1;
		int count = 0;
		while(number != 0) {
			count += (number & mask);
			number >>= 1;
		}
		return count;
	}
	
	public static int countSetBitsEfficient(int number) {
		int count = 0;
		while(number != 0) {
			count++;
			number = (number & (number - 1));
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(countSetBits(15));   // Will go through 32 bits
		System.out.println(countSetBitsEfficient(15));    // Will go through only set bits.
	}
	
}

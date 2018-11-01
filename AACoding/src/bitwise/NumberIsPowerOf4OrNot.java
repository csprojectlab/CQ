package bitwise;

public class NumberIsPowerOf4OrNot {

	public static boolean powerOf4OrNot(int number) {
		while(number != 1) {
			if(number % 4 != 0)
				return false;
			number >>= 2;   // Divide the number by 4.
		}		
		return true;
	}
	
	// If a number is power of 4 then there is only one bit set.
	// And number of zeroes after that set bit are always even.
	public static boolean powerOf4OrNotBitwise(int number) {
		// Check if there is only one bit set.
		if(number != 0 && (number & (number - 1)) == 0) {
			// Count the number of zeroes.
			int count = 0;
			int mask = 1;
			while((number & mask) == 0) {   // Mask checking for zero.
				count++;
				mask <<= 1;
			}
			return count % 2 == 0;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		int number = 64;
		System.out.println(powerOf4OrNot(number));
		System.out.println(powerOf4OrNotBitwise(number));
	}
	
}

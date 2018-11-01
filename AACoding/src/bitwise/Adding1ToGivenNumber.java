package bitwise;

public class Adding1ToGivenNumber {

	public static int addOneByNegating(int number) {
		return -(~number);  // Number is evaluated as 2's complement.
	}
	
	public static int addOneByFlipping(int number) {
		int mask = 1;
		while((number & mask) != 0) {   // Flip till the rightmost zero.
			number ^= mask;
			mask <<= 1;
		}
		number ^= mask;   // Set the rightmost zero.
		return number;
	}
	
	public static void main(String[] args) {

		System.out.println(addOneByNegating(2));
		System.out.println(addOneByFlipping(2));
	}

}

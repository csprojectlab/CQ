package bitwise;

public class MultiplyTwoNumbersUsingBitwise {

	public static int multiplyNumbers(int first, int second) {
		int result = 0;
		while(second > 0) {
			if((second & 1) != 0)   // second is an odd number.
				result = result + first;
			first <<= 1;   // double the first number.
			second >>= 1;  // divide by 2.
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(multiplyNumbers(18,2));
	}

}

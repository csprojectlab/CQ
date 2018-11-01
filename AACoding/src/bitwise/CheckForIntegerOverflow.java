package bitwise;

public class CheckForIntegerOverflow {

	public static void main(String[] args) {
		long a = 1000000000;
		long b = 2222222;
		// Overflow can only occur if sign of both the numbers is same.
		if(a > Integer.MAX_VALUE - b) {
			System.out.println("OVERFLOW");
		} else 
			System.out.println("NOT OVERFLOW");
	}

}

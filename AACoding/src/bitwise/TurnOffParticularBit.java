package bitwise;

public class TurnOffParticularBit {

	// Just toggle the bit.
	public static void main(String[] args) {
		int n = 7;
		int k = 1;   // turn off the first bit.
		int mask = 1;
		n = (n ^ (mask << (k - 1)));    // Xoring will toggle the bit.
		System.out.println(n);
	}
	
}

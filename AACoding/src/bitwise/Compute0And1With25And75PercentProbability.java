package bitwise;

import java.util.Random;

public class Compute0And1With25And75PercentProbability {

	public static void main(String[] args) {
		// generating first random number.
		int first = new Random().nextInt();
		// generating second random number.
		int second = new Random().nextInt();
		
		// Now these random numbers can be even and odd with equal probabilities.
		// Convert them to 0 and 1
		int bit1 = first & 1;
		int bit2 = second & 1;
		
		// Bit1 and bit2 are with equal probabilities.
		// Or operation has 0 with 25 and 1 with 75 % chance.
		int result = bit1 | bit2;     
		System.out.println(result);
	}
	
}

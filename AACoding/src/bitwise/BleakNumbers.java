package bitwise;

// If a number n cannot be represented as n = x + countSetBits(x)
// Then the number is called bleak;
// n = 3     n = 2 + countSetBits(2)
//           n = 2 + 1
//           n = 3;
//           Therefore 3 is not a bleak.

public class BleakNumbers {

	// max count of set bits in any number less than n
	public static int maxCountOfSetBits(int n) {
		int count = 0;
		n--;
		while(n != 0) {
			count++;
			n >>= 1;
		}
		return count;
	}
	
	// Count the bits that are set in the parameter n.
	public static int countSetBits(int n) {
		int count = 0;
		while(n != 0) {
			// Going directly to 1's
			count++;
			n = (n & (n - 1));
		}
		return count;
	}
	
	public static boolean isBleak(int n) {
		// Going through every combination.
		for(int i = 1; i < n; i++) {
			if((i + countSetBits(i)) == n)
				return false;   // Not Bleak.
		}
		return true;  // Bleak;
	}
	
	public static boolean isBleakEfficient(int n) {
		// Rather than going through every combination, we go through only selected ones
		for(int i = n - maxCountOfSetBits(n); i < n; i++) {
			if((i + countSetBits(i)) == n)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// 3 is not bleak but 4 is bleak;
		int n = 3;
		System.out.println(isBleakEfficient(n));
		System.out.println(maxCountOfSetBits(8));
	}
	
}

package bitwise;

public class SmallestPowerOf2GreaterThanNumber {

	public static int smallestPower(int n) {
		// If only one bit is set in n
		if(n != 0 && (n & (n - 1)) == 0)
			return n;
		// Find the leftmost set bit.
		int position = 0;
		while(n != 0) {
			position++;
			n >>= 1;
		}
		return (int)Math.pow(2, position);
	}
	
	public static void main(String[] args) {
		System.out.println(smallestPower(4));
	}
	
}

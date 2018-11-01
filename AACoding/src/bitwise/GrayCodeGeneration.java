package bitwise;

// For n it generates 2^n gray codes.
public class GrayCodeGeneration {

	public static String[] grayCode(int n) {
		int size = (int)Math.pow(2, n);
		String[] result = new String[size];
		result[0] = "0";
		result[1] = "1";
		int i = 2;   // Start from 2nd index.
		for(i = 2; i < size; i <<= 1) {
			// Add new entries in reverse order.
			for(int offset = 0; offset < i; offset++) 
				result[i + offset] = result[i - offset - 1];
			// Prefix zeroes in all strings before i's current value.
			for(int j = i - 1; j >= 0; j--)
				result[j] = "0" + result[j];
			// Prefix 1's after i'th index.
			for(int j = i; j < (i << 1); j++)
				result[j] = "1" + result[j];
		}
		for(int j = 0; j < result.length; j++)
			System.out.println(result[j]);
		return null;
	}
	
	public static void main(String[] args) {
		int n = 6;
		grayCode(n);
	}
	
	
}

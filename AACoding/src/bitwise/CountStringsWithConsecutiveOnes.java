package bitwise;

/*
 * For n = 3   we have 8 combinations
 * Out of 8 only 3 has consecutive 1's.
 * So output is 3.
 * 
 * n = 5   Output: 19
 * n = 2   Output: 1
 */

public class CountStringsWithConsecutiveOnes {

	public static int countConsecutiveOnes(int n) {
		int limit = (int)Math.pow(2, n);
		int result = 0;
		for(int i = 3; i < limit; i++) {   // For every combination.
			if((i & (i >> 1)) != 0)
				result++;
		}
		System.out.println(result);
		return result;
	}
	
	public static void main(String[] args) {
		countConsecutiveOnes(5);
	}
}

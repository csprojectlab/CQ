package bitwise;

public class PalindromeBinaryNumber {

	public static boolean isPalindrome(int n) {
		int right = 1;
		int left = Integer.BYTES*8;
		while(right < left) {
			if((n & (1 << (right - 1))) != (n & (1 << (left - 1)))) {
				return false;
			}
			right++;
			left--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(0x0FFFFFFF));
	}
}

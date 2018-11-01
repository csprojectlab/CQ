package bitwise;

public class AddTwoBitStrings {

	public static int addBitStrings(String first, String second) {
		// Converting the bit strings into numbers.
		int n1 = 0;
		int n2 = 0;
		for(int i = 0; i < first.length(); i++)
			if(first.charAt(i) == '1') {
				n1 = (n1 << 1) + 1;
			} else {
				n1 <<= 1;
			}
		for(int i = 0; i < second.length(); i++)
			if(second.charAt(i) == '1')
				n2 = (n2 << 1) + 1;
			else 
				n2 <<= 1;
		return n1 + n2;
	}
	
	public static String addBitStringsUsingCarry(String first, String second) {
		String result = "";  // Store the resultant bits.
		// Make the strings of equal size.
		int flen = first.length();
		int slen = second.length();
		if(flen > slen) {
			int diff = flen - slen;
			for(int i = 0; i < diff; i++)
				second = '0' + second;
		} else if(flen < slen) {
			int diff = slen - flen;
			for(int i = 0; i < diff; i++)
				first = '0' + first;
		}
		System.out.println(first + ": " + second);
		// Calculating the sum.
		int sum = 0;
		int carry = 0;
		for(int i = first.length() - 1; i >= 0; i--) {
			int bit1 = first.charAt(i) - '0';
			int bit2 = second.charAt(i) - '0';
			sum = (bit1 ^ bit2  ^ carry) + '0';
			result = (char)sum + result;
			// next carry.
			carry = (bit1 & bit2) | (bit1 & carry) | (bit2 & carry);
		}
		// if overflow, Then add a leading one.
		if(carry == 1) {
			result = '1' + result;
			System.out.println("Overflow");
		}
		System.out.println(result);
		
		return result;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(addBitStrings("100", "100"));
		addBitStringsUsingCarry("1100011", "110");
	}
}

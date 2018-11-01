package bitwise;

public class TwoNumbersHaveOppositeSign {

	public static boolean hasOppositeSign(int first, int second) {
		return (first ^ second) < 0;   // Last bit is one for negative numbers. 
	}
	
	public static void main(String[] args) {
		System.out.println(hasOppositeSign(-1,-2));
	}
	
}

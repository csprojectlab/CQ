package bitwise;

public class TurnOffRightmostSetBit {

	public static void main(String[] args) {
		int number = 12;
		// 12 : 01100.
		// 11 : 01011.
		number = (number & (number - 1));
		System.out.println(number);
	}
	
}

package bitwise;

public class LeftCircularShift {

	public static int leftCircularShift(int number, int K) {
		return (number << K) | (number >> (Integer.BYTES*8 - K));
	}
	
	public static void main(String[] args) {
		
		System.out.println(leftCircularShift(12,2));
	}
	
}

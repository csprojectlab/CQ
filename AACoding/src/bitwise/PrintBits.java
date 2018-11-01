package bitwise;


// This only works for positive numbers.
public class PrintBits {

	public static void printBits(int number) {
		if(number != 0)
			printBits(number >> 1);
		System.out.print(number & 1);   // Print the bit.
	}
	
	public static void main(String[] args) {
		printBits(2);
	}
	
}

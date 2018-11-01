package bitwise;


// Multiply the number with 3.5
public class MultiplyWith3Point5 {

	public static int multiply(int number) {
		return (number << 2) - (number >> 1);
	}
	
	public static void main(String[] args) {
		System.out.println(multiply(6));
	}
}

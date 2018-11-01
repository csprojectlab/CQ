package bitwise;

public class ComputModulusDivisionByPowerOf2 {

	public static void main(String[] args) {
		int number = 6;
		int d = 4;    // This number is required to be the power of 2.
		int mod = (number & (d - 1));
		System.out.println(mod);
	}
	
}

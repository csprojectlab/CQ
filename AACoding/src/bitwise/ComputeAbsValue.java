package bitwise;

public class ComputeAbsValue {

	public static void main(String[] args) {
		int n = -2;
		int mask = 0xFFFFFFFF;
		n = (n ^ mask);
		n++;
		System.out.println(n);
	}
	
}

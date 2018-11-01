package divideandconquer;

public class PowerOfX {
	/*
	 * x^n is to be calculated.
	 */
	public int pow(int x, int n) {
		if(n <= 1)
			return 1;
		int k = this.pow(x, n/2);
		if((n & 1) == 0)
			return k*k;
		else
			return x*k*k;
	}
	
	public static void main(String[] args) {
		int x = 2;
		int n = 12;
		PowerOfX p = new PowerOfX();
		int k = p.pow(x, n);
		System.out.println(k);
	}
}

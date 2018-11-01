package bitwise;

// 5, 25, 30, 125, 130...........
public class MagicNumberUsing5 {
	
	public static int nthMagicNumber(int n) {
		if(n == 0)
			return 0;
		int pow = 1;
		int result = 0;
		while(n != 0) {
			pow *= 5;
			if((n & 1) != 0)
				result += pow;
			n >>= 1;
		}		
		System.out.println(result);
		return result;
	}
	
	public static void main(String[] args) {
		nthMagicNumber(3);
	}

}

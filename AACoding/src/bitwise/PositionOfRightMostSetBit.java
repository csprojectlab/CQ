package bitwise;

public class PositionOfRightMostSetBit {

	public static void main(String[] args) {
		int number = 18;   // answer = 2.   10010
		int count = 0;
		if(number == 0) {
			System.out.println(0);
			System.exit(0);
		} 
		while((number & 1) == 0) {
			count++;
			number >>= 1;
		}
		
		System.out.println(count+1);
		
	}
	
}

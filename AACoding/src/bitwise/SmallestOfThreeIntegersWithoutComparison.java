package bitwise;

public class SmallestOfThreeIntegersWithoutComparison {

	public static void main(String[] args) {
		int first = 12;
		int second = 13;
		int third = 14;
		int count = 0;
		while(first > 0 && second > 0 && third > 0) {
			first--;
			second--;
			third--;
			count++;
		}
		System.out.println(count);
		
		// Doing by another method. This can cause divide by zero problem.
		first = 12;
		second = 13;
		third = 14;
		int min = 1;
		if(first / second <= 0) {
			min = (first / third <= 0) ? first : third;
		} else 
			min = (second / third <= 0) ? second : third;
		System.out.println(min);
		
		
	}
	
}

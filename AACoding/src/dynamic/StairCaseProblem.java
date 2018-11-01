package dynamic;

/*
 * Given that 2 steps you can take. Find number of ways to reach n'th step.
 * You can take only 1 and 2.
 * 
 * It can be reduced to fibonacci series.
 */
public class StairCaseProblem {

	public int totalWays(int n) {
		if(n <= 3)
			return n;
		int n1 = 2;
		int n2 = 3;
		int result = -1;
		for(int i = 3; i < n; i++) {
			result = n1 + n2;
			n1 = n2;
			n2 = result;
		}
		System.out.println("Number of ways to reach n'th step: " + result);
		return result;
	}
	
	public static void main(String[] args) {
		StairCaseProblem s = new StairCaseProblem();
		int n = 5;
		// count(5) = count(4) + 1 + count(3) + 2     Since we can only take two steps we can't go on count(2).
		s.totalWays(n);
	}
	
}

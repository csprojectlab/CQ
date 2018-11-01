package backtracking;

import java.util.LinkedList;
import java.util.List;

/*Input :  N = 3, P = 2, S = 23 
Output : 3 7 13
         5 7 11*/

public class PrintPrimesAfterPrimePWithSumS {
	
	public List<Integer> findPrimes(int limit, int greaterThan) {
		List<Integer> primes = new LinkedList<>();
		for(int i = 2; i < limit; i++) {
			boolean p = true;
			for(int div = 2; div <= i / 2; div++) {
				if(i % div == 0)
					p = false;
			}
			if(p && i > greaterThan)
				primes.add(i);
		}
		return primes;
	}
	
	public void printPrimesWithSumS(int currentSum, int sum, String result, List<Integer> primes, int index, int N) {
		if(currentSum > sum || N < 0 || index == primes.size())
			return;
		if(currentSum == sum && N == 0) {
			System.out.println(result);
			return;
		}
		this.printPrimesWithSumS(currentSum + primes.get(index), sum, result + " " + primes.get(index), primes, index + 1, N-1);
		this.printPrimesWithSumS(currentSum, sum, result, primes, index + 1, N);
	}

	public static void main(String[] ags) {
		PrintPrimesAfterPrimePWithSumS p = new PrintPrimesAfterPrimePWithSumS();
		int N = 3;
		int P = 2;
		int S = 23;
		
		p.printPrimesWithSumS(0, S, "", p.findPrimes(S, P), 0, N);
	}

}

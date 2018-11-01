package graph;

import java.util.ArrayList;
import java.util.List;

//Shortest path to reach one prime to other by changing single digit at a time
//Given two four digit prime numbers, suppose 1033 and 8179, we need to find the shortest path from 1033 to 8179 by altering only single digit at a time such that every number that we get after changing a digit is prime. For example a solution is 1033, 1733, 3733, 3739, 3779, 8779, 8179
//
//Examples:
//
//Input : 1033 8179
//Output :6
//
//Input : 1373 8017
//Output : 7
//
//Input  :  1033 1033
//Output : 0

public class ShortestPathToReachOnePrimeToAnother {
	
	public static void sieveOfEratosthenes(int start, int end, List<Integer> primeSet) {
		int limit = end;
		boolean prime[] = new boolean[limit + 1];
		for(int i = 0; i < prime.length; i++)
			prime[i] = true;
		for(int p = 2; p*p <= limit; p++) {
			if(prime[p]) {
				for(int i = 2*p; i <= limit; i += p)
					prime[i] = false;
			}
		}
		for(int i = start; i <= limit; i++) {
			if(prime[i]) 
				primeSet.add((i));
		}
	}
	
	// Dealing with only four digits
	public static boolean differByOne(String first, String second) {
		int count = 0;
		if(first.charAt(0) != second.charAt(0))
			count++;
		if(first.charAt(1) != second.charAt(1))
			count++;
		if(first.charAt(2) != second.charAt(2))
			count++;
		if(first.charAt(3) != second.charAt(3))
			count++;
		return count == 1;
		
	}
	
	public static void main(String[] args) {
		List<Integer> primeList = new ArrayList<Integer>(1500);
		sieveOfEratosthenes(1000, 9999, primeList);
		ShortestPathUsingBFS g = new ShortestPathUsingBFS();
		for(int i = 0; i < primeList.size(); i++) {
			g.addVertex(primeList.get(i) + "");
			for(int j = i+1; j < primeList.size(); j++) {
				g.addVertex(primeList.get(j) + "");  
				if(differByOne(primeList.get(i) + "", primeList.get(j) + ""))
					g.addEdge(primeList.get(i) + "", primeList.get(j) + "", 0);
			}
		}
		g.display();
		int first = 1373;
		int second = 8017;
		int count = g.countNumberOfPaths(first + "", second + "");
		System.out.println("Number of paths: " + count);
		System.out.println(g.printPath(first + "", second + ""));		
	}

}

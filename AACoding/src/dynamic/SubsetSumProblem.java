package dynamic;

import java.util.HashSet;
import java.util.Set;

public class SubsetSumProblem {
	
	public Set<Integer> getElements(boolean[][] k, int[] arr) {
		Set<Integer> elements = new HashSet<>();
		int i = k.length - 1;
		int j = k[i].length - 1;
		while(j != 0) {
			if(k[i][j] == k[i-1][j])
				i--;
			else {
				elements.add(arr[i-1]);
				j -= arr[i-1];
				i--;
			}
		}
		System.out.println("Elements: " + elements);
		return elements;
	}

	public boolean subsetSumProblem(int[] arr, int total) {
		boolean[][] k = new boolean[1+arr.length][1+total];
		k[0][0] = true;
		// If there is no element then all false.
		for(int i = 1; i < k[0].length; i++)
			k[0][i] = false;
		// If total is zero, then subset sum is true as by choosing no element.
		for(int i = 1; i < k.length; i++)
			k[i][0] = true;
		for(int i = 1; i < k.length; i++) {   // for elements till i.
			for(int j = 1; j < k[i].length; j++) {     // for total as j.
				if(arr[i-1] > j)   // Element can't be considered.
					k[i][j] = k[i-1][j];
				else {
					// Don't consider, Consider 
					k[i][j] = k[i-1][j] || k[i-1][j-arr[i-1]];
				}
					
			}
		}
		util.Util.printMatrix(k);
		System.out.println("Subset found: " + k[k.length-1][k[0].length-1]);
		this.getElements(k, arr);
		return k[k.length-1][k[0].length-1];
	}
	
	public static void main(String[] args) {
		SubsetSumProblem s = new SubsetSumProblem();
		int[] arr = new int[] {2,3,7,8,10};
		int total = 11;
		s.subsetSumProblem(arr, total);
	}
	
}

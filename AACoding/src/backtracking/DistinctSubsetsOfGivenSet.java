package backtracking;

import java.util.HashSet;
import java.util.Set;

public class DistinctSubsetsOfGivenSet {

	public void distinctSubsets(int[] arr) {
		Set<String> subsets = new HashSet<>();
		subsets.add(" ");
		this.distinctSubsets(arr, 0, subsets, new StringBuffer(""));
		System.out.println(subsets);
	}
	
	public void distinctSubsets(int[] arr, int index, Set<String> subsets, StringBuffer output) {
		for(int i = index; i < arr.length; i++) {
			output.append(arr[i]);
			subsets.add(output.toString());
			this.distinctSubsets(arr, i+1, subsets, output);
			output.deleteCharAt(output.length() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] S = {1, 2, 2};
		DistinctSubsetsOfGivenSet d = new DistinctSubsetsOfGivenSet();
		d.distinctSubsets(S);
		
	}
}

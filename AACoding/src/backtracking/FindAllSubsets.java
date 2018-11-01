package backtracking;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FindAllSubsets {

	public void findSubsets(int[] arr) {
		Set<Set<Integer>> result = new LinkedHashSet<>();
		result.add(new HashSet<>());
		this.findSubsets(arr, 0, new HashSet<>(), result);
		System.out.println(result);
	}
	
	public void findSubsets(int[] arr, int index, Set<Integer> subset, Set<Set<Integer>> result) {
		for(int i = index; i < arr.length; i++) {
			subset.add(arr[i]);
			result.add(new HashSet<>(subset));
			this.findSubsets(arr, i+1, new HashSet<>(subset), result);
			subset.remove(arr[i]);  // backtrack.
		}
	}
	
	public static void main(String[] args) {
		FindAllSubsets f = new FindAllSubsets();
		int[] arr = {1, 2, 3};
		f.findSubsets(arr);
	}

}

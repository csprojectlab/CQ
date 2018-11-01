package backtracking;

import java.util.HashSet;
import java.util.Set;

public class MinimumNumberOfUniqueCharactersInString {

	public String swap(String a, String b, int index) {
		char[] ac = a.toCharArray();
		char[] bc = b.toCharArray();
		ac[index] = bc[index];
		return String.valueOf(ac);
	}
	
	public int countUnique(String a) {
		Set<Character> set = new HashSet<>();
		for(int i = 0; i < a.length(); i++)
			set.add(a.charAt(i));
		return set.size();
	}
	
	public int findMinCharacters(String a, String b) {
		return this.findMinCharacters(a, b, 0);
	}
	
	public int findMinCharacters(String a, String b, int index) {
		if(index == a.length()) {
			return this.countUnique(a);
		}
		int swapCount = 0;  // Count of unique characters that will be obtained if we perform swap at this index.
		int nonSwapCount = 0;
		nonSwapCount = this.findMinCharacters(a, b, index+1);
		a = this.swap(a, b, index);
		swapCount = this.findMinCharacters(a, b, index + 1);
		return Math.min(swapCount, nonSwapCount);
	}
	
	public static void main(String[] args) {
		MinimumNumberOfUniqueCharactersInString m = new MinimumNumberOfUniqueCharactersInString();
		String a = "ababa";
		String b = "babab";
		System.out.println(m.findMinCharacters(a, b));
	}
	
}

package backtracking;
import java.util.LinkedHashSet;
import java.util.Set;

public class BitwiseFindingSubsets {

	public Set<String> findSubsets(String string) {
		Set<String> result = new LinkedHashSet<>();
		int counterSize = (int)Math.pow(2, string.length());  // Total number of possible subsets.
		for(int counter = 0; counter < counterSize; counter++) {
			String str = "";
			for(int j = 0; j < string.length(); j++) {
				if((counter & (1 << j)) != 0) 
					str += string.charAt(j);
			}
			result.add(str);
		}		
		return result;		
	}
	
	public static void main(String[] args) {
		BitwiseFindingSubsets b = new BitwiseFindingSubsets();
		System.out.println(b.findSubsets("abc"));;
	}
	
}

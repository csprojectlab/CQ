package backtracking;

import java.util.HashSet;
import java.util.Set;

public class BitwisePrintSpacesBetweenCharactersInString {

	public void printSpacesInString(String string) {
		Set<String> result = new HashSet<>();
		int counterSize = (int)Math.pow(2, string.length()-1);		
		for(int counter = 0; counter < counterSize; counter++) {
			String str = "";
			for(int j = 0; j < string.length(); j++) {
				str += string.charAt(j);
				if((counter & (1 << j)) != 0)
					str += "_";
			}
			result.add(str);
		}
		System.out.println(result);		
	}
	
	public static void main(String[] args) {
		BitwisePrintSpacesBetweenCharactersInString b = new BitwisePrintSpacesBetweenCharactersInString();
		b.printSpacesInString("ABCD");
	}
	
}

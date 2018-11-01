package backtracking;

import java.util.LinkedList;
import java.util.List;

public class PrintSpacesBetweenCharactersInString {

	public void printSpacesInString(String string) {
		List<String> result = new LinkedList<>();
		this.printSpacesInString(string, 1, result);
		System.out.println(result);
	}
	
	public void printSpacesInString(String string, int index, List<String> result) {
		if(index >= string.length()) {
			result.add(string);
			return;
		}
		this.printSpacesInString(string, index + 1, result);  // Don't add a space here.
		this.printSpacesInString(string.substring(0, index) + "_" + string.substring(index), index + 2, result);
	}
	
	public static void main(String[] args) {
		PrintSpacesBetweenCharactersInString p = new PrintSpacesBetweenCharactersInString();
		p.printSpacesInString("ABCD");
	}
}

package bitwise;

public class CompareTwoStrings {

	// Geek and geek are same.     Ignore case.
	public static int compare(String first, String second) {
		if(first.length() < second.length())
			return -1;
		else if(first.length() > second.length())
			return 1;
		else {   // Equal length.
			int i;
			for(i = 0; i < first.length(); i++) {
				if(first.charAt(i) == second.charAt(i))
					continue;   // No issue.
				else if((first.charAt(i) ^ 32) == second.charAt(i)) {    // Checking the case issue.
					continue;
				} else
					break;
			}
			if(i == first.length())
				return 0;   // strings are equal.
			if(first.charAt(i) < second.charAt(i))
				return -1;
			return 1;			
		}
	}
	
	public static void main(String[] args) {
		System.out.println(compare("geek", "GEek"));
	}
	
}

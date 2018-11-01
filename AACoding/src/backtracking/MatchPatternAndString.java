package backtracking;

import java.util.HashMap;
import java.util.Map;

public class MatchPatternAndString {
	
	public void matchPattern(String string, String pattern) {
		Map<Character, String> map = new HashMap<>();
		this.matchPattern(string, pattern, map, 0);
		if(map.size() != 0)
		  System.out.println(map);
		else
		  System.out.println("SOLUTION DOESN'T EXIST.");
		
	}
	
	public boolean matchPattern(String string, String pattern, Map<Character, String> map, int pi) {
		for(int i = 1; i <= string.length(); i++) {
			String str = string.substring(0, i);
			String ros = string.substring(i);
			if(map.containsKey(pattern.charAt(pi))) {  // If map contains the pattern character.
				// If pattern character points to the same string and current string has no ros then solution is found.
				if(map.get(pattern.charAt(pi)).equalsIgnoreCase(str) && str.length() == string.length() &&
					pi == pattern.length() - 1) {   // These all conditions are necessary.
					return true;
				}
				continue;
			}
			map.put(pattern.charAt(pi), str);
			if(this.matchPattern(ros, pattern, map, pi+1))
				return true;
			map.remove(pattern.charAt(pi));  // backtrack.
	   }
		return false;
	}
	
	public static void main(String[] args) {
		String string = "geeksforgeeks";
		String pattern = "aba";
		MatchPatternAndString m = new MatchPatternAndString();
		m.matchPattern(string, pattern);
	}
	
}

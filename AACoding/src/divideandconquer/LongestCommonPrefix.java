package divideandconquer;

public class LongestCommonPrefix {

	private String longestCommonPrefix(char[] first, char[] second) {
		String result = "";
		for(int i = 0, j = 0; i < first.length && j < second.length; i++, j++) {
			if(first[i] != second[j])
				break;
			result += first[i];   // adding the prefix to the result.
		}
		return result;
	}
	
	private String longestCommonPrefix(String[] strings, int low, int high) {
		if(low == high) 
			return strings[low];   // Return the atomic string.
		if(high > low) {
			// divide the strings.
			int mid = low + (high - low) / 2;   // To avoid overflow, we don't go out of number line.
			String leftPrefix = this.longestCommonPrefix(strings, low, mid);
			String rightPrefix = this.longestCommonPrefix(strings, mid + 1, high);
			// Build the result.
			return this.longestCommonPrefix(leftPrefix.toCharArray(), rightPrefix.toCharArray());
		}		
		System.out.println("NULL Case");
		return null;     // Will never reach this case.
	}
	
	public String longestCommonPrefix(String[] strings) {
		return this.longestCommonPrefix(strings, 0, strings.length - 1);
	}
	
	public static void main(String[] args) {
		String[] strings = new String[] { "geeksforgeeks", "geeks", "geek", "geezer" };
		LongestCommonPrefix l = new LongestCommonPrefix();
		String prefix = l.longestCommonPrefix(strings);
		System.out.println(prefix);
	}
}

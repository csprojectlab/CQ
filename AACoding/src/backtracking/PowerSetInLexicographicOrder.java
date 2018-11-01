package backtracking;

import java.util.Arrays;

public class PowerSetInLexicographicOrder {
	public int count = 0;
	public String sort(String str) {
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
	
	public void printLexicographicOrder(String str) {
		str = this.sort(str);
		this.printLexicographicOrder(str, 0, new StringBuffer(""));
	}
	
	public void printLexicographicOrder(String str, int index, StringBuffer output) {
		if(index == str.length()) 
			return;
		for(int i = index; i < str.length(); i++) {
			output.append(str.charAt(i));
			System.out.println(output);
			this.count++;
			this.printLexicographicOrder(str, i+1, output);
			output.deleteCharAt(output.length() - 1);  // Backtrack.
		}
	}
	
	public void printLexico(int[] arr) {
		Arrays.sort(arr);
		this.printLexico(arr, 0, new StringBuffer(""));
	}
	
	public void printLexico(int[] arr, int index, StringBuffer output) {
		if(index == arr.length)
			return;
		for(int i = index; i < arr.length; i++) {
			output.append(arr[i]);
			System.out.println(output);
			this.printLexico(arr, i+1, output);
			output.deleteCharAt(output.length() - 1);
		}
	}
	
	public static void main(String[] args) {
		PowerSetInLexicographicOrder p = new PowerSetInLexicographicOrder();
		String s = "abc";
		p.printLexicographicOrder(s);
		System.out.println("count: " + p.count);
		
		// If we have to print integer array elements.
		int[] arr = {2,1,3};
		p.printLexico(arr);
	}

}

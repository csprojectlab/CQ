package stack;

public class IndexOfClosingBracketForOpeningBracket {

	public int indexOfClosing(char[] input, int openingIndex) {
		int i = openingIndex;
		while(i < input.length) {
			if(input[i] == ')')
				return i;
			i++;
		}
		return -1;
	}
}

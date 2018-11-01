package backtracking;

public class WordBreakProblem {
	public String[] dictionary = {"i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", 
			                      "icecream", "man", "go", "mango", "and"};
	public boolean inDictionary(String s) {
		for(String word : this.dictionary) {
			if(word.equalsIgnoreCase(s))
				return true;
		}
		return false;
	}
	
	public void breakWord(String sentence, int index, String output) {
		if(index == sentence.length()) {
			System.out.println(output);
			return;
		}
		for(int i = index + 1; i <= sentence.length(); i++) {
			String prefix = sentence.substring(index, i);
			if(this.inDictionary(prefix)) 
				this.breakWord(sentence, i, output + prefix + " ");
		}
	}
	
	public static void main(String[] args) {
		WordBreakProblem p = new WordBreakProblem();
		String i = "ilikesamsungmobile";
		String j = "ilikeicecreamandmango";
		p.breakWord(j, 0, "");
		
	}
}

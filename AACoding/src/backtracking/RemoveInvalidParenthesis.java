package backtracking;
//??????????????????????
public class RemoveInvalidParenthesis {
	public boolean flag = false;
	public boolean isValidParenthesis(String s) {
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(')
				count++;
			else if(s.charAt(i) == ')')
				count--;
		}
		return count == 0;
	}

	public void removeInvalidParenthesis(String s, int l) {
		if(this.isValidParenthesis(s)) {
			if(s.length() != l - 1)
				return;
			System.out.println(s);
			this.flag = true;
			return;
		}
		if(this.flag)
			return;
		for(int i = 0; i < s.length(); i++) {
			String trimmedString = s.substring(0, i) + s.substring(i+1);
			this.removeInvalidParenthesis(trimmedString, l);
		}
	}
	
	public static void main(String[] args) {
		RemoveInvalidParenthesis p = new RemoveInvalidParenthesis();
		String s= "()())()";
		p.removeInvalidParenthesis(s, s.length());
	}
}

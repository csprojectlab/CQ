package backtracking;

public class Permutations {

	public String swap(String str, int i, int j) {
		char[] arr = str.toCharArray();
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return String.valueOf(arr);
	}
	
	public void permute(String str, int left, int right) {
		if(left == right)
			System.out.println(str);
		else {
			for(int i = left; i <= right; i++) {
				str = this.swap(str, left, i);
				this.permute(str, left+1, right);
				str = this.swap(str, left, i);
			}
		}
	}
	
	public static void main(String[] args) {
		Permutations p = new Permutations();
		p.permute("abc", 0, "abc".length() - 1);
	}

}

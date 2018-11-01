package backtracking;

/*Input :  n = 3
Output : 3 1 2 1 3 2
         2 3 1 2 1 3
All elements from 1 to 3 appear
twice and distance between two
appearances is equal to value
of the element.*/

public class CombinationalAppearance {
	
	public void allCombinations(int N) {
		int[] arr = new int[2*N];
		for(int i = 0; i < arr.length; i++)
			arr[i] = -1;
		this.allCombinations(arr, 1, N);
	}

	public void allCombinations(int[] arr, int value, int N) {
		if(value > N) {
			for(Integer i : arr)
				System.out.print(i + " ");
			System.out.println();
			return;
		}
		for(int i = 0; i < 2*N; i++) {
			if(arr[i] == -1 && (i + value + 1) < 2*N && arr[i + value + 1] == -1) {
				arr[i] = value;
				arr[i+value+1] = value;
				this.allCombinations(arr, value+1, N);
				arr[i] = -1;
				arr[i+value+1] = -1;  // backtracking.
			}
		}
	}

	public static void main(String[] args) {
		CombinationalAppearance c = new CombinationalAppearance();
		c.allCombinations(4);
	}

}

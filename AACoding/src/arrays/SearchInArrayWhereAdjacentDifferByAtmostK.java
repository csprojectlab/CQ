package arrays;

public class SearchInArrayWhereAdjacentDifferByAtmostK {

	public int searchArray(int[] arr, int K, int key) {
		int index = 0;
		while(index < arr.length) {
			if(arr[index] == key)
				break;
			index += Math.max(1, Math.abs(arr[index] - key) / K);
		}
		System.out.println("Index is: " + index);
		return index;
	}
	
	public static void main(String[] args) {
		SearchInArrayWhereAdjacentDifferByAtmostK s = new SearchInArrayWhereAdjacentDifferByAtmostK();
		int[] arr = new int[] {20,40,50,70,70,60};     // Array is not sorted.
		int K = 20;   // Adjacent differ by at-most 20.
		int key = 60;
		s.searchArray(arr, K, key);
	}
	
}

package arrays;

public class SortArrayAccordingToDifferenceWithAGivenValue {
	
	

	// Using insertion sort.
	public void insertionSort(int[] arr, int value) {
		for(int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int k = i - 1;
			while(k >= 0 && Math.abs(value - arr[k]) > Math.abs(value - key)) {
				arr[k+1] = arr[k];
				k--;
			}
			arr[k+1] = key;
		}
	}
	
	public static void main(String[] args) {
		SortArrayAccordingToDifferenceWithAGivenValue s = new SortArrayAccordingToDifferenceWithAGivenValue();
		int value = 7;
		int[] arr = new int[] {10,5,3,9,2};
		s.insertionSort(arr, value);
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
}

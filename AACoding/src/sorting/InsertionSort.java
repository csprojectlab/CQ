package sorting;

public class InsertionSort {

	public void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int k = i - 1;
			while(k >= 0 && arr[k] > key) {
				arr[k+1] = arr[k];
				k--;
			}
			arr[k+1] = key;
		}
	}
	
	public static void main(String[] args) {
		InsertionSort is = new InsertionSort();
		int[] arr = new int[] {70,10,30,90,40};
		is.insertionSort(arr);
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}

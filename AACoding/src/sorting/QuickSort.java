package sorting;

public class QuickSort {

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j]  = temp;
	}
	
	public int partition(int[] arr, int low, int high, int pivot) {
		int index = low;
		for(int j = low; j <= high; j++) {
			if(arr[j] < arr[pivot]) {
				this.swap(arr, index, j);
				index++;
			}
		}
		this.swap(arr, index, pivot);   // Pivot get to its correct position.
		return index;
	}
	
	public void quickSort(int[] arr, int low, int high) {
		if(low < high) {
			int partition = this.partition(arr, low, high, high);   // Taking last element as pivot.
			this.quickSort(arr, low, partition - 1);  // Left side of partition.
			this.quickSort(arr, partition + 1, high);  // right side of partition.
		}
	}
	
	public void quickSort(int[] arr) {
		this.quickSort(arr, 0, arr.length-1);
	}
	
	public static void main(String[] args) {
		QuickSort q = new QuickSort();
		int[] arr = new int[] {10,80,30,90,40,50,70};
		q.quickSort(arr);
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}

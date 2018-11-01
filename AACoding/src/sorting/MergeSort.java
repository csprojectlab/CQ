package sorting;

public class MergeSort {
	
	public void merge(int[] arr, int low, int mid, int high) {
		int[] result = new int[high-low+1];    // This is the sorted merged array.
		int left = low;   // Start of left side.
		int right = mid + 1;   // Start of right side.
		int index = 0;
		while(left <= mid && right <= high) {
			if(arr[left] <= arr[right]) {
				result[index] = arr[left];
				left++;
			} else {    // Element at right side is greater.
				result[index] = arr[right];
				right++;
			}
			index++;
		}
		while(left <= mid) {
			result[index] = arr[left];
			left++;
			index++;
		}
		while(right <= high) {
			result[index] = arr[right];
			right++;
			index++;
		}
		// Copying the result to the main array.
		index = 0;
		for(int i = low; i <= high; i++) {
			arr[i] = result[index];
			index++;
		}
	}
	
	public void mergeSort(int[] arr, int low, int high) {
		if(low < high) {
			int mid = (low + high) / 2;
			this.mergeSort(arr, low, mid);   // left half.
			this.mergeSort(arr, mid+1, high);   // right half.
			this.merge(arr, low, mid, high);   // Merge the two halves in sorted way.
		}
	}
	
	public void mergeSort(int[] arr) {
		this.mergeSort(arr, 0, arr.length-1);
	}
	
	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		int[] arr = new int[] {10,80,30,90,40,50,70};
		m.mergeSort(arr);
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}














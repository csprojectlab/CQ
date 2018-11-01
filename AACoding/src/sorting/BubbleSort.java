package sorting;

public class BubbleSort {

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length-1-i; j++) {
				if(arr[j] > arr[j+1])
					this.swap(arr, j, j+1);
			}
		}
	}

	public static void main(String[] args) {
		BubbleSort s = new BubbleSort();
		int[] arr = new int[] {50,20,40,10,80,7};
		s.bubbleSort(arr);
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
}

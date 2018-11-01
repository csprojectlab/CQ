package arrays;


// In O(N)
public class SortArrayWihtNValues {
	
	public void swap(int[] arr, int i , int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


	public void sort(int[] arr) {
		int index = 0;
		while(index < arr.length) {
			if(index != (arr[index] - 1)) {  // Number is not at it's correct position.
				this.swap(arr, index, arr[index]-1);
			} else
				index++;
		}
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
	public static void main(String... args) {
		SortArrayWihtNValues s = new SortArrayWihtNValues();
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
		s.sort(arr);
	}
	
}

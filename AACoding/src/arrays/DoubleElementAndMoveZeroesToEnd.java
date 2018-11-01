package arrays;

// Double the element if consecutive elements are same.

public class DoubleElementAndMoveZeroesToEnd {
	
	public void swap(int[] arr, int i , int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void print(int[] arr) {
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public void doIt(int[] arr) {
		int high = arr.length - 1;
		int index = 0;
		for(int j = 0; j <= high; j++) {
			if(arr[j] != 0) {
				if(j+1 <= high && arr[j] == arr[j+1]) {
					arr[j] = 2*arr[j];
					arr[j+1] = 0;
				}					
				this.swap(arr, index, j);
				index++;
			}
		}
	}
	
	public static void main(String[] ags) {
		DoubleElementAndMoveZeroesToEnd d = new DoubleElementAndMoveZeroesToEnd();
		int arr[] = new int[] {2,2,0,4,0,8};
		d.doIt(arr);
		d.print(arr);
	}
	
}

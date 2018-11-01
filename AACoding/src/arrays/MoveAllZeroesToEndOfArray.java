package arrays;

public class MoveAllZeroesToEndOfArray {
	
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

	public void moveUsingFirstMethod(int[] arr) {
		int index = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				this.swap(arr, index, i);
				index++;
			}
		}
		System.out.println("Moving using the first method:");
		this.print(arr);
	}
	
	public void moveUsingSecondMethod(int[] arr) {
		int index = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				arr[index] = arr[i];
				index++;
			}
		}
		// Appending the zeroes
		while(index < arr.length) 
			arr[index++] = 0;
		System.out.println("Moving using the second method:");
		this.print(arr);
	}
	
	public static void main(String[] args) {
		MoveAllZeroesToEndOfArray m = new MoveAllZeroesToEndOfArray();
		int[] arr = new int[] {1,9,8,4,0,0,2,7,0,6,0};
		int[] arr1 = new int[] {1,9,8,4,0,0,2,7,0,6,0};
		m.moveUsingFirstMethod(arr);
		m.moveUsingSecondMethod(arr1);
	}
	
}

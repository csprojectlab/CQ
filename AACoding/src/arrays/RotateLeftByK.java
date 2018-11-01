package arrays;

public class RotateLeftByK {
	
	public void reverse(int[] arr, int start, int end) {
		if(start >= end)
			return;
		while(start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	
	public void printArray(int[] arr) {
		System.out.println("=========== Printing==========");
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public void rotateLeftByk(int[] arr, int K) {
		this.reverse(arr, 0, K-1);
		this.reverse(arr, K, arr.length-1);
		this.reverse(arr, 0, arr.length-1);
	}
	
	public void rotateRightByK(int[] arr, int K) {
		this.reverse(arr, arr.length - K, arr.length-1);
		this.reverse(arr, 0, arr.length - K - 1);
		this.reverse(arr, 0, arr.length - 1);
	}
	
	public static void main(String[] args) {
		RotateLeftByK k = new RotateLeftByK();
		int[] arr = new int[]{1,2,3,4,5,6,7};
		k.printArray(arr);
		// Rotating left.
		k.rotateLeftByk(arr, 2);
		k.printArray(arr);
		// Rotating right to get the original array back.
		k.rotateRightByK(arr, 2);
		k.printArray(arr);
	}
	
	
}

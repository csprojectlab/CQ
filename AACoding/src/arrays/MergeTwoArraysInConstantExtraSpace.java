package arrays;

public class MergeTwoArraysInConstantExtraSpace {

	private void swapBetweenTwoArrays(int[] first, int[] second, int fi, int si) {
		int temp = first[fi];
		first[fi] = second[si];
		second[si] = temp;
	}
	
	// Get one element to it's correct position in an already sorted array.
	private void modifiedInsertionSort(int[] arr) {
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
	
	public void mergeArrays(int[] first, int[] second) {
		int left = 0;   // For first array
		int right = 0;  // For second array.
		while(left < first.length) {
			if(first[left] < second[right])   // element in first array is at it's correct position.
				left++;
			else if(first[left] > second[right]) {  // Swap and sort the second array.
//				System.out.println(first[left] + ":" + second[right]);
				this.swapBetweenTwoArrays(first, second, left, right);  // Swap between two arrays.
				// Get the element to it's correct position.
				this.modifiedInsertionSort(second);
			}
		}
		util.Util.print(first);
		util.Util.print(second);
	}
	
	public static void main(String[] srg) {
		MergeTwoArraysInConstantExtraSpace m = new MergeTwoArraysInConstantExtraSpace();
		int[] first = new int[] {1,5,9,10,15,20};
		int[] second = new int[] {2,3,8,13};
		m.mergeArrays(first, second);
	}
}

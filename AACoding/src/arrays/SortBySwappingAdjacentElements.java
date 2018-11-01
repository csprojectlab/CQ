package arrays;

// We always have 1 to N elements.
public class SortBySwappingAdjacentElements {

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public boolean canSort(int[] arr, int[] canSwap) {
		int index = 0;
		int prevIndex = -1;
		while (index < arr.length) {
			if (index != (arr[index] - 1)) { // Number at wrong position.
				if (index < canSwap.length && canSwap[index] == 1 && index != prevIndex) { // If we can swap.
					this.swap(arr, index, index+1);
					prevIndex = index;
				} else // Element is at wrong position and we cannot swap.
					return false; // Return false.
			} else // Number at right position.
				index++;
		}
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		return true;
	}
	
	public static void main(String[] args) {
		SortBySwappingAdjacentElements s = new SortBySwappingAdjacentElements();
		int[] arr = new int[] {1,2,5,4,3,6};   // For this input it doesn't work. Goes into infinite loop.
												// That's why prevIndex is used.
		int[] canSwap = new int[] {0,1,1,1,0};
		s.canSort(arr, canSwap);
	}
}

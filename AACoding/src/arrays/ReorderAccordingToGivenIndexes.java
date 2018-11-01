package arrays;

public class ReorderAccordingToGivenIndexes {

	public void reorder(int[] arr, int[] indexes) {
		int i = 0;
		int value = -1;
		int index = -1;
		while(i < arr.length) {   // Go through each index.
			if(indexes[i] != i) {   // Element is not in its place.
				value = arr[i];    // Get the value.
				index = indexes[i];    // Destination index for this value.
				// Update.
				arr[i] = arr[index];
				indexes[i] = indexes[index];
				
				arr[index] = value;
				indexes[index] = index;				
			} else 
				i++;   // Increment if value is at it's correct position.
		}
		for(int j = 0; j < arr.length; j++)
			System.out.print(arr[j] + " ");
	}
	
	public static void main(String[] args) {
		ReorderAccordingToGivenIndexes r = new ReorderAccordingToGivenIndexes();
		int[] arr = new int[] {50,40,70,60,90};
		int[] indexes = new int[] {3,0,4,1,2};
		r.reorder(arr, indexes);
	}
	
}

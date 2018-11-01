package arrays;

public class SegregateEvenAndOddNumbers {
	
	public void swap(int[] arr, int i , int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void segregateNumbers(int[] arr) {
		int index = 0;
		while(index < arr.length && arr[index] % 2 == 0) // Looking for odd number's index.
			index++;
		for(int j = 0; j < arr.length; j++) {
			if(arr[j] % 2 == 0) {   // Process an even number.
				this.swap(arr, index, j);   // Swap even and odd.
				index++;
			}
		}
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
	public static void main(String[] args) {
		SegregateEvenAndOddNumbers s = new SegregateEvenAndOddNumbers();
		int[] arr = new int[] {1,3,13,4,6,55,12,16};
		s.segregateNumbers(arr);
	}
	
}

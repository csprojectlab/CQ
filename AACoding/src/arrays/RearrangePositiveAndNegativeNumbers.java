package arrays;


// We have to put the array elements in alternate positive and negative positions.
public class RearrangePositiveAndNegativeNumbers {

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
	
	public int[] rearrangeNumbers(int[] arr) {
		// Taking all negative to the left side.
		int index = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < 0) {
				this.swap(arr, index, i);
				index++;  // This should be under the while loop for incrementation.
			}
		}
		
		// index variable points to the index of the first positive number.
		// Now we pick one negative number and replace it with another positive number.
		int pos = index;
		int neg = 0;
		while(neg < pos) {
			this.swap(arr, neg, pos);
			neg += 2;
			pos++;
		}
		this.print(arr);  // Resultant output.
		return null;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {-1,2,-3,4,5,6,-7,8,9};
		RearrangePositiveAndNegativeNumbers r = new RearrangePositiveAndNegativeNumbers();
		r.rearrangeNumbers(arr);
	}
	
}

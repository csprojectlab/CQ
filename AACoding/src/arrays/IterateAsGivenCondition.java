package arrays;

//  a[i] <= a[i+1]    for even.
//  a[i] >= a[i+1]    for odd.

public class IterateAsGivenCondition {
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void iterateAsCondition(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			if(i % 2 == 0) {
				if(arr[i+1] <= arr[i]) 
					this.swap(arr, i+1, i);
			} else {
				if(arr[i] < arr[i+1])
					this.swap(arr, i, i+1);
			}
		}
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
	public static void main(String[] args) {
		IterateAsGivenCondition i = new IterateAsGivenCondition();
		int[] arr = new int[] {6,4,2,1,8,3};
		i.iterateAsCondition(arr);
	}
	
}

package arrays;

public class ReplaceWithMultiplicationOfNextAndPrevious {

	public void replaceWithMultiplication(int[] arr) {
		int previous = arr[0];
		arr[0] = arr[0]*arr[1];   // Set the first result.
		for(int i = 1; i < arr.length - 1; i++) {
			int temp = arr[i];
			arr[i] = previous * arr[i+1];
			previous = temp;
		}
		arr[arr.length-1] = previous * arr[arr.length - 1];
		for(int j = 0; j < arr.length; j++)
			System.out.print(arr[j] + " ");
	}
	
	public static void main(String[] args) {
		ReplaceWithMultiplicationOfNextAndPrevious r = new ReplaceWithMultiplicationOfNextAndPrevious();
		int[] arr = new int[] {2,3,4,5,6};
		r.replaceWithMultiplication(arr);
	}
	
}

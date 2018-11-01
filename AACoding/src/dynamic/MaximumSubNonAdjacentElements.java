package dynamic;

public class MaximumSubNonAdjacentElements {

	public int maxNonAdjacentSum(int[] arr) {
		int inclusive = arr[0];   
		int exclusive = 0;
		
		for(int i = 1; i < arr.length; i++) {
			int temp = inclusive;
			inclusive = Math.max(arr[i] + exclusive, inclusive);
			exclusive = temp;
		}
		System.out.println("Maximum Sum With Non-Adjacent Elements: " + inclusive);
		
		return -1;
	}
	
	public static void main(String[] args) {
		MaximumSubNonAdjacentElements e = new MaximumSubNonAdjacentElements();
		int[] arr = new int[] {4,1,1,4,2,1};   // 9
		e.maxNonAdjacentSum(arr);
	}
}

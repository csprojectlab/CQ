package divideandconquer;

public class FindMinimumInArray {

	public int findMin(int[] arr, int low, int high) {
		if(low == high)
			return arr[low];
		if(low + 1 == high) {  // Only two elements left.
			return Math.min(arr[low], arr[high]);
		}
		int mid = (low + high) / 2;
		return Math.min(this.findMin(arr, low, mid), this.findMin(arr, mid+1, high));
	}
	
	public static void main(String[] args) {
		FindMinimumInArray f = new FindMinimumInArray();
		int[] arr = new int[] {3,5,7,1,8,0};
		int m = f.findMin(arr, 0, arr.length - 1);
		System.out.println(m);
	}
	
}

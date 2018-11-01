package divideandconquer;

public class CountInversions {

	public int merge(int[] arr, int low, int mid, int high) {
		int inversionCount = 0;
		int left = low;
		int right = mid + 1;
		int[] temp = new int[high - low + 1];
		int index = 0;
		while(left <= mid && right <= high) {
			if(arr[left] < arr[right])
				temp[index++] = arr[left++];
			else if(arr[left] >= arr[right]) {   // Larger element is on the left side. Inversion.
				temp[index++] = arr[right++];
				// adding one is the point here. Examine with example
				inversionCount += (mid - left + 1);   // All the numbers after this point will add to inversions.
			}
		}
		while(left <= mid)
			temp[index++] = arr[left++];
		while(right <= high)
			temp[index++] = arr[right++];
		index = 0;
		for(int i = low; i <= high; i++)
			arr[i] = temp[index++];
		return inversionCount;
	}
	
	public int enhancedMergeSort(int[] arr, int low, int high) {
		int inversionCount = 0;
		if(low < high) {
			int mid = (low + high) / 2;
			inversionCount += this.enhancedMergeSort(arr, low, mid);
			inversionCount += this.enhancedMergeSort(arr, mid + 1, high);
			inversionCount += this.merge(arr, low, mid, high);
		}		
		return inversionCount;
	}
	
	public int countInversions(int[] arr) {
		
		return this.enhancedMergeSort(arr, 0, arr.length - 1);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 20, 6, 4, 5 }; 
		CountInversions c = new CountInversions();
		int inversion = c.countInversions(arr);
		util.Util.print(arr);
		System.out.println("Inversion required: " + inversion);
		
	}

}

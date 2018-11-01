package arrays;

// Such that : arr[i] = i;
public class RearrangeArraySuchThat {

	public int[] rearrangeArray(int[] arr) {
		int[] result = new int[arr.length];
		for(int i = 0; i < result.length; i++)
			result[i] = -1;
		for(int i = 0; i < arr.length; i++)
			if(arr[i] != -1)
				result[arr[i]] = arr[i];
		return result;
	}
	
	public int[] rearrangeArrayEfficient(int[] arr) {
		int i = 0;
		while(i < arr.length) {
			if(arr[i] == -1 || arr[i] == i) {
				i++;
				continue;
			}
			int temp = arr[arr[i]];
			arr[arr[i]] = arr[i];
			arr[i] = temp;			
		}		
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {-1,-1,6,1,9,3,2,-1,4,-1};
		RearrangeArraySuchThat r = new RearrangeArraySuchThat();
		int[] result = r.rearrangeArray(arr);
		for(int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
		System.out.println();
		System.out.println("Efficient method: ");
		int[] ans = r.rearrangeArrayEfficient(arr);
		for(int i = 0; i < ans.length; i++)
			System.out.print(ans[i] + " ");
	}
}

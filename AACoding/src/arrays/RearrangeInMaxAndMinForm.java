package arrays;

public class RearrangeInMaxAndMinForm {

	public int[] rearrange(int[] sortedArr) {
		int left = 0;
		int right = sortedArr.length - 1;
		int[] result = new int[sortedArr.length];
		int index = 0;
		while(left <= right) {
			if(index < result.length)
				result[index++] = sortedArr[right];
			if(index < result.length)
				result[index++] = sortedArr[left];
			left++;
			right--;
		}
		for(int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");		
		return null;
	}
	
	public static void main(String[] args) {
		RearrangeInMaxAndMinForm r = new RearrangeInMaxAndMinForm();
		int[] sortedArr = new int[] {1,2,3,4,5,6,7};
		r.rearrange(sortedArr);
	}
	
}

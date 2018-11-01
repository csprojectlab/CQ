package arrays;

import util.Util;

// We will use a variation of DUTCH NATIONAL FLAG ALGORITHM.

public class SortArrayOf0s1sAnd2s {

	// Conceptually partition the array into three parts: 0 1 and 2.
	public void sortArray(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		int mid = 0;
		while(mid <= right) {
			switch(arr[mid]) {
			case 0:		Util.swap(arr, mid++, left++); 		break;
			case 1:		mid++;								break;
			case 2: 	Util.swap(arr, mid, right--);		break;
			}
		}
		Util.print(arr);
	}
	
	public static void main(String[] args) {
		SortArrayOf0s1sAnd2s s = new SortArrayOf0s1sAnd2s();
		int[] arr = new int[] {2,1,1,0,1,2,1,2,0,0,0,1};
		s.sortArray(arr);
	}
	

}

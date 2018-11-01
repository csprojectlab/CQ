package arrays;

import java.util.Arrays;

/*
 * a[1] >= a[2] <= a[3] >= a[4]................
 */

public class SortArrayInWaveform {
	
	public void swap(int[] arr, int i , int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void sortInWaveform(int[] arr) {
		Arrays.sort(arr);    // nlogn
		int i = 0;
		while(i + 1 < arr.length) {
			this.swap(arr, i, i+1);
			i = i + 2;
		}
		i = 0;
		while(i < arr.length)
			System.out.print(arr[i++] + " ");
	}
	
	public static void main(String[] args) {
		SortArrayInWaveform s = new SortArrayInWaveform();
		int[] arr = new int[] {10,5,6,3,2,20,100,80};
		s.sortInWaveform(arr);
	}
}

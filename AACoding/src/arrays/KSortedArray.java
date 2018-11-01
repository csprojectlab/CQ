package arrays;

import heap.Heap;
/*
 * Each element is atmost k away from its target position.
 */

// Complexity is O(nlogK)   not O(NlogN)
public class KSortedArray {
	Heap<Integer> heap = new Heap<>(true);   // Min heap.
	
	public void sortKSortedArray(int[] arr, int K) {
		// The smallest element will lie within k+1 positions.
		for(int i = 0; i < K+1; i++)
			heap.add(arr[i]);
		int index = 0;
		for(int i = 4; i < arr.length; i++) {
			arr[index++] = heap.remove();
			heap.add(arr[i]);
		}
		while(index < arr.length)
			arr[index++] = heap.remove();
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
	public static void main(String[] args) {
		KSortedArray k = new KSortedArray();
		int arr[] = new int[] {6,5,3,2,8,10,11,9};
		int K = 3;
		k.sortKSortedArray(arr, K);
	}
	
	
	
	
}

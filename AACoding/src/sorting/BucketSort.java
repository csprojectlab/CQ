package sorting;

import java.util.LinkedList;
import java.util.List;

public class BucketSort {

	
	public void insertionSort(List<Double> list) {
		for(int i = 1; i < list.size(); i++) {
			double key = list.get(i);
			int k = i - 1;
			while(k >= 0 && list.get(k) > key) {
				list.set(k+1, list.get(k));
				k--;
			}
			list.set(k+1, key);
		}
	}
	
	public void bucketSort(double[] arr) {
		@SuppressWarnings("unchecked")
		LinkedList<Double> bucket[] = (LinkedList<Double>[])new LinkedList[arr.length];
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			int bucketIndex = (int) (n*arr[i]);  
			if(bucket[bucketIndex] == null)
				bucket[bucketIndex] = new LinkedList<>();
			bucket[bucketIndex].add(arr[i]);
		}
		// Sort the buckets.
		for(int i = 0; i < n; i++) 
			if(bucket[i] != null) 
				this.insertionSort(bucket[i]);
		int index = 0;
		for(int i = 0; i < n; i++) {
			if(bucket[i] != null) {
				for(Double d : bucket[i])
					arr[index++] = d;
			}
		}
		
	}
	
	public static void main(String[] args) {
		BucketSort s = new BucketSort();
		double[] arr = new double[] {0.124, 0.785, 0.301, 0.451, 0.997, 0.111, 0.456, 0.667, 0.995};
		s.bucketSort(arr);
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}

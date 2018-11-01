package arrays;

import java.util.Arrays;

/*
 * Sum of any two sides should be greater than third side.
 */

public class CountNumberOfPossibleTriangles {

	public int numberOfTriangles(int[] arr) {
		int count = 0;
		// Sort the array first.
		Arrays.sort(arr);
		// For each pair of two numbers.
		for(int first = 0; first < arr.length - 1; first++) { 
			for(int second = first + 1; second < arr.length; second++) {
				int k = second + 1;
				while(k < arr.length && arr[first] + arr[second] > arr[k])
					k++;
				count += k - second - 1;
			}
		}
		System.out.println("Number of possible triangles: " + count);
		return count;
	}
	
	public static void main(String[] args) {
		CountNumberOfPossibleTriangles c = new CountNumberOfPossibleTriangles();
		int[] arr = new int[] {10,21,22,100,101,200,300};
		c.numberOfTriangles(arr);
	}
}

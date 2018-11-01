package arrays;

public class LargestThreeElementsInArray {

	public void printLargestThree(int[] arr) {
		int first;
		int second;
		int third;
		first = second = third = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > first) {
				third = second;
				second = first;
				first = arr[i];
			} else if(arr[i] > second) {
				third = second;
				second = arr[i];
			} else if(arr[i] > third) {
				third = arr[i];
			}
		}
		
		System.out.print(first + " " + second + " " + third);
	}
	
	public static void main(String[] args) {
		LargestThreeElementsInArray l = new LargestThreeElementsInArray();
		int[] arr = new int[] {10,4,3,50,23,90};
		l.printLargestThree(arr);
	}
	
}

package arrays;

/*
 * Find element that appears only once in array where other elements appear twice.
 */

public class ElementThatAppearsOnce {

	public int findElementAppearingOnce(int[] arr) {
		int element = arr[0];
		for(int i = 1; i < arr.length; i++)
			element = element ^ arr[i];
		System.out.println("element is: " + element);
		return element;
	}
	
	public static void main(String[] args) {
		ElementThatAppearsOnce e = new ElementThatAppearsOnce();
		int[] arr = new int[] {7,3,5,4,5,3,4};
		e.findElementAppearingOnce(arr);
	}
	
}

package arrays;

/*
 * Find repetitive element in the array.
 * All other elements appear only once.
 */
public class ElementThatAppearsTwice {

	// This is wrong. NOT CORRECT.
	public int findRepetitiveElement(int[] arr) {
		int element = arr[0];
		for(int i = 1; i < arr.length; i++) {
			element = ~(element ^ arr[i]);
			System.out.println(element);
		}
		System.out.println("Repetitive element: " + element);
		return element;
	}
	
	// This is working fine.
	public int findElement(int[] arr) {
		int i = 0;
		while(i < arr.length) {
			if(arr[i] == -1) {
				i++;
				continue;
			}
			int index = arr[i] - 1;
			if(arr[index] == -1)
				return arr[i];
			else {
				arr[i] = arr[index];
//				util.Util.swap(arr, i, index);
				arr[index] = -1;
			}				
		}
		return -1;
	}
	
	public static void main(String[] args) {
		ElementThatAppearsTwice e = new ElementThatAppearsTwice();
		int[] arr = new int[] {1,3,2,3,4};
		System.out.print(e.findElement(arr));
	}
}

package arrays;

public class PrintElementsWhichHaveAtleastTwoGreaterElements {

	public void print(int[] arr) {
		int first;
		int second;
		first = second = Integer.MIN_VALUE;
		int i = 0;
		while(i < arr.length) {
			if(arr[i] > first) {
				second = first;
				first = arr[i];
			} else if(arr[i] > second) {
				second = arr[i];
			}
			i++;
		}
		i = 0;
		System.out.println("Elements having atleast two greater elements: ");
		while(i < arr.length) {
			if(arr[i] < second)
				System.out.print(arr[i] + " ");
			i++;
		}
	}
	
	public static void main(String[] args) {
		PrintElementsWhichHaveAtleastTwoGreaterElements p = new PrintElementsWhichHaveAtleastTwoGreaterElements();
		int[] arr = new int[] {2,8,7,1,5};
		p.print(arr);
	}
}

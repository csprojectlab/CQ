package stack;


public class NumberOfNextGreaterElements {

	public int[] numberOfNge(int[] arr) {
		// Find the indexes of next greater element.
		int[] indexes = new NextGreaterElement().nge(arr);
		int[] k = new int[arr.length];
		for(int i = 0; i < k.length; i++)
			k[i] = 1;
		for(int i = k.length - 1; i >= 0; i--) {
			if(indexes[i] == -1)  // nge doesn't exist.
				k[i] = 0;
			else {
				int ngeIndex = indexes[i];
				k[i] += k[ngeIndex];
			}
		}
		System.out.println("Number of next greater elements: ");
		util.Util.print(k);
		return null;
	}
	
	public static void main(String[] args) {
		NumberOfNextGreaterElements n = new NumberOfNextGreaterElements();
		int[] arr = new int[] {3,5,2,7,5,8,10,6};
		n.numberOfNge(arr);
	}
	
}

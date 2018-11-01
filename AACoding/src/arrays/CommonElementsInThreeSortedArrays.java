package arrays;

public class CommonElementsInThreeSortedArrays {

	public void printCommonElements(int[] first, int[] second, int[] third) {
		int x = 0;   // for array first.
		int y = 0;   // for array second.
		int z = 0;  // for array third.
		while(x < first.length && y < second.length && z < third.length) {
			if(first[x] == second[y] && first[x] == third[z])   // Print the common element.
				System.out.print(first[x] + " ");
			if(first[x] < second[y])
				x++;
			else if(third[z] < second[y])
				z++;
			else
				y++;
		}
	}
	
	public static void main(String[] args) {
		CommonElementsInThreeSortedArrays c = new CommonElementsInThreeSortedArrays();
		int[] first = new int[] {1,5,10,20,40,80};
		int[] second = new int[] {6,7,20,80,100};
		int[] third = new int[] {2,3,15,20,30,70,80,120};
		c.printCommonElements(first, second, third);
	}
}

package arrays;

import java.util.HashSet;
import java.util.Set;

// Numbers are in range of 1 to n.
// if n = 5   means 1 to 5
// Then array size will be n + 2 = 7.
public class FindTwoRepeatingElementsInGivenArray {

	public void findRepeatingElementsUsingIndexing(int[] arr) {
		Set<Integer> set = new HashSet<>();
		int i = 0;
		while(i < arr.length) {
			if(arr[i] == -1) {
				i++;
				continue;
			}
			int index = arr[i] - 1;    // Index of the number.
			if(arr[index] == -1) {   // Means the number is repeating.
				set.add(arr[i]);
				i++;
			} else {
				arr[i] = arr[index];
				arr[index] = -1;
			}
		}
		System.out.println(set);
	}
	
	// This is wrong . Not giving correct answer.
	public void findRepeatingElementsUsingEquations(int[] arr) {
		int n = arr.length - 2;
		int sumTillN = (n*( n- 1)) / 2;   // Sum of first n numbers.
		int arraySum = 0;
		int arrayProduct = 1;
		for(int i = 0; i < arr.length; i++) {
			arraySum += arr[i];
			arrayProduct *= arr[i];
		}
		int XplusY = arraySum - sumTillN;   // First equation. We get x + y.
		
		int productTillN = 1;
		for(int i = 2; i <= n; i++)
			productTillN *= i;
		
		int XmultY = arrayProduct / productTillN;
		
		int XminusY = (int)Math.sqrt(XplusY*XplusY - 4*XmultY);
		
		int x = (XplusY + XminusY) / 2;
		int y = XplusY - x;
		System.out.println(x + " " + y);
		
		
	}
	
	public static void main(String[] args) {
		FindTwoRepeatingElementsInGivenArray f = new FindTwoRepeatingElementsInGivenArray();
		int[] arr = new int[] {4,2,4,5,2,3,1};
		f.findRepeatingElementsUsingIndexing(arr);
		f.findRepeatingElementsUsingEquations(arr);
	}
}

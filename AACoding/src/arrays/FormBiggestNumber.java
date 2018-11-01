package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FormBiggestNumber {

	public long formBiggestNumber(int[] a) {
		Integer arr[] = new Integer[a.length];
		for(int i = 0; i < arr.length; i++)
			arr[i] = new Integer(a[i]);
		
		List<Integer> list = Arrays.asList(arr);
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				String result1 = String.valueOf(o1) + String.valueOf(o2);
				String result2 = String.valueOf(o2) + String.valueOf(o1);
				return result2.compareTo(result1);
			}
		});
		String result = "";
		for(Integer i : list)
			result += i;
		return Long.valueOf(result);
	}
	
	public static void main(String[] args) {
		FormBiggestNumber f = new FormBiggestNumber();
		int[] arr = new int[] {54,548,546,60};
		System.out.print(f.formBiggestNumber(arr));
	}
	
}

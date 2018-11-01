package arrays;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("rawtypes")
class Pair implements Comparable{
	int key;
	int index;
	public Pair(int key, int index) {
		this.key = key;
		this.index = index;
	}
	public String toString() {
		return "(" + this.key + "," + this.index + ")";
	}
	@Override
	public int compareTo(Object o) {
		Pair other = (Pair)o;
		if(this.key > other.key)
			return 1;
		else if(this.key < other.key)
			return -1;
		return 0;   // equal
	}
}

/*
 *  Independent cycles are formed. Eccentric kind of.
 */
public class NumberOfSwapsRequiredToSort {

	@SuppressWarnings("unchecked")
	public void numberOfSwaps(int[] arr) {
		List<Pair> list = new LinkedList<>();
		for(int i = 0; i < arr.length; i++)
			list.add(new Pair(arr[i], i));   // Store the value and it's corresponding wrong index.
		// Sort the list so that keys get at their correct positions.
		Collections.sort(list);
		System.out.println(list);
		boolean visited[] = new boolean[arr.length];
		int swaps = 0;
		for(int j = 0; j < list.size(); j++) {
			if(visited[j] || list.get(j).index == j)   // Means list element is at correct position in the array.
				continue;
			int i = j;
			int cycleLength = 0;
			while(!visited[i]) {
				visited[i] = true;
				i = list.get(i).index;
				cycleLength++;
			}
			swaps += cycleLength - 1;
		}
		System.out.println("Swaps required: " + swaps);
	}
	
	public static void main(String[] args) {
		NumberOfSwapsRequiredToSort n = new NumberOfSwapsRequiredToSort();
		int arr[] = new int[] {4,3,2,1};
		n.numberOfSwaps(arr);
	}
	
}

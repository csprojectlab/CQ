package arrays;

import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersectionUnsortedArray {

	public void unionAndIntersection(int[] first, int[] second) {
		Set<Integer> union = new HashSet<>();
		Set<Integer> intersection = new HashSet<>();
		for(int i = 0; i < first.length; i++)
			union.add(first[i]);
		for(int i = 0; i < second.length; i++) {
			if(union.contains(second[i]))
				intersection.add(second[i]);
			union.add(second[i]);    // Hashing being used inside.
		}
		System.out.println("Union: " + union);
		System.out.print("Intersection: " + intersection);
	}
	
	public static void main(String[] args) {
		UnionAndIntersectionUnsortedArray u = new UnionAndIntersectionUnsortedArray();
		int[] first = new int[] {7,2,4,1,5,6};
		int[] second = new int[] {7,8,6,9};
		u.unionAndIntersection(first, second);
		
	}
	
}

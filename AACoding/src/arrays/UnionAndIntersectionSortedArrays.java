package arrays;

import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersectionSortedArrays {

	public void unionAndIntersection(int[] first, int[] second) {
		Set<Integer> union = new HashSet<>();
		Set<Integer> intersection = new HashSet<>();
		int leftMin = 0;
		int rightMin = 0;
		while (leftMin < first.length && rightMin < second.length) {
			if (first[leftMin] < second[rightMin])
				union.add(first[leftMin++]);
			else if (first[leftMin] > second[rightMin])
				union.add(second[rightMin++]);
			else { // Both are equal. We can also store the intersection here.
				union.add(first[leftMin]);
				intersection.add(first[leftMin]);
				leftMin++;
				rightMin++;
			}
		}
		while (leftMin < first.length)
			union.add(first[leftMin++]);
		while (rightMin < second.length)
			union.add(second[rightMin++]);
		System.out.println("Union: " + union);
		System.out.println("Intersection: " + intersection);
	}

	public static void main(String[] args) {
		UnionAndIntersectionSortedArrays u = new UnionAndIntersectionSortedArrays();
		int[] first = new int[] { 1, 2, 3, 4, 5, 7 };
		int[] second = new int[] { 2, 5, 6 };
		u.unionAndIntersection(first, second);
	}
}

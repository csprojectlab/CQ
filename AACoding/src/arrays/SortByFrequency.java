package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class SortByFrequency {

	public void sort(int[] arr) {
		Map<Integer, Integer> map = new TreeMap<>();
		for(int i = 0; i < arr.length; i++) {
			if(map.get(arr[i]) != null) {
				map.put(arr[i] , map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		// Sorting the hashmap.
		Set<Entry<Integer, Integer>> entries = map.entrySet();   // This is set form.
		List<Entry<Integer, Integer>> entriesList = new ArrayList<>(entries);  // This is list form. Can be sorted.
		Collections.sort(entriesList, new Comparator<Entry<Integer, Integer>> () {
			@Override
			public int compare(Entry<Integer, Integer> first, Entry<Integer, Integer> second) {
				return second.getValue().compareTo(first.getValue());
			}
		});
		map = new LinkedHashMap<>();  // To store the sorted result.
		for(Entry<Integer, Integer> e : entriesList)
			map.put(e.getKey(), e.getValue());
		for(Integer key : map.keySet())
			System.out.println(key);
		
	}
	
	public static void main(String[] args) {
		SortByFrequency f = new SortByFrequency();
		int[] arr = new int[] {2, 5, 2, 8, 5, 6, 8, 8};
		f.sort(arr);
	}
}

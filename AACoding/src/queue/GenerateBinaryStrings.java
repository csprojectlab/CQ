package queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateBinaryStrings {

	/*
	 * Generate binary strings till N. This method wastes a lot of space if the
	 * value of N is big.
	 */
	public List<String> generateBinaryString(int N) {
		List<String> list = new LinkedList<>();
		Queue<String> queue = new LinkedList<>();
		queue.add("1"); // Just a kind of seed value.
		while (N-- > 0) {
			String number = queue.poll(); // Getting the binary sequence out of the queue.
			list.add(number); // adding to the result.
			// Generating the next numbers from this number.
			queue.add(number + "0");
			queue.add(number + "1");
		}
		System.out.println(list);
		System.out.println("Wasted space of queue: " + queue);
		return list;
	}

	/*
	 * Can't say about it's efficiency as it is traversing all the previous numbers to generate new number.
	 */
	public String[] efficientGenerateBinaryString(int N) {
		int limit = N;
		String[] list = new String[limit];
		list[0] = "0";
		list[1] = "1";
		int i = 2;
		for (; i < limit; i <<= 1) {
			// Replicating the numbers.
			int index = i;
			int j = 0;
			while (index < list.length && index < (i << 1)) {
				list[index] = list[j++];
				index++;
			}

			// Adding zeros to the previous numbers.
			for (j = 0; j < i; j++)
				list[j] = "0" + list[j];
			// Adding one to the new numbers.
			for (j = i; j < list.length && j < (i << 1); j++)
				list[j] = "1" + list[j];
		}
		for (String s : list)
			System.out.print(s + " ");
		return list;
	}

	public static void main(String[] args) {
		GenerateBinaryStrings gen = new GenerateBinaryStrings();
		int N = 12;
		 gen.generateBinaryString(N);
		System.out.println("Efficient method:");
		gen.efficientGenerateBinaryString(N);
	}

}

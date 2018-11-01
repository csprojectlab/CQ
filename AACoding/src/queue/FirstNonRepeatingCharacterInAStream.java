package queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacterInAStream {

	public void printFirstNonRepeating(char[] arr) {
		int[] freq = new int[26];
		Queue<Character> queue = new LinkedList<>();
		int i = 0;
		while(i < arr.length) {
			freq[arr[i] - 'a']++;  // Increase the count.
			if(freq[arr[i] - 'a'] == 1)
				queue.add(arr[i]);
			while(!queue.isEmpty() && freq[queue.peek() - 'a'] > 1)
				queue.poll();
			if(queue.isEmpty())
				System.out.print(-1);
			else
				System.out.print(queue.peek());			
			i++;
		}
	}
	
	public static void main(String[] args) {
		FirstNonRepeatingCharacterInAStream f = new FirstNonRepeatingCharacterInAStream();
		String string = "aac";
		f.printFirstNonRepeating(string.toCharArray());
	}
	
}

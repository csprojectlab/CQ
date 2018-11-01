package linkedlist;

public class NthNodeFromEndOfLinkedList<T> {

	/*
	 * Using the two pointer method.
	 */
	public Node<T> NthNodeFromEnd(Node<T> head, int N) {
		Node<T> firstPointer = head;
		Node<T> secondPointer = null;
		while(N-- > 0 && firstPointer != null)
			firstPointer = firstPointer.next;
		if(N == -1 && firstPointer == null)   // Carefully note this point
			return head;    // Talking about the first element of the list.
		else if(firstPointer == null)
			return null;	// N specified is greater than the size of the list.
		secondPointer = head;
		while(firstPointer != null) {
			firstPointer = firstPointer.next;
			secondPointer = secondPointer.next;
		}
		return secondPointer;
	}
	
	public static void main(String[] args) {
		NthNodeFromEndOfLinkedList<Integer> n = new NthNodeFromEndOfLinkedList<>();
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 1; i <= 10; i++)
			list.add(i);
		System.out.println("N'th node from end is: " + n.NthNodeFromEnd(list.head, 11));
	}
	
}

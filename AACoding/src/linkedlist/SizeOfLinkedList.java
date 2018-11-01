package linkedlist;

public class SizeOfLinkedList<T> {

	/*
	 * Calculates the size in recursive manner.
	 */
	public int size(Node<T> node) {
		if(node == null)
			return 0;
		return 1 + this.size(node.next);
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		SizeOfLinkedList<Integer> soll = new SizeOfLinkedList<>();
		for(int i = 1; i < 11; i++)
			list.add(i);
		System.out.println("Size of the list is: " + soll.size(list.head));
	}
}

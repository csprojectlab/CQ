package linkedlist;

public class MoveLastElementToFrontOfLinkedList<T> {

	public void moveLastToFirst(LinkedList<T> list) {
		// Reach the last and second last element.
		Node<T> current = list.head;
		while(current.next.next != null)
			current = current.next;
		// Current holds reference to second last element.
		Node<T> temp = list.head;
		list.head = current.next;
		current.next.next = temp;
		current.next = null;
	}
	
	public static void main(String[] args) {
		MoveLastElementToFrontOfLinkedList<Integer> m = new MoveLastElementToFrontOfLinkedList();
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 1; i < 6; i++)
			list.add(i);
		m.moveLastToFirst(list);
		list.display();
	}
}

package linkedlist;

public class ReverseLinkedList<T> {

	public void reverse(LinkedList<T> list, Node<T> prev, Node<T> current) {
		if(current.next == null) {  // If it is the last node.
			list.head = current;
			current.next = prev;
		} else {
			this.reverse(list, current, current.next);
			current.next = prev;
		}			
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		ReverseLinkedList<Integer> reverse = new ReverseLinkedList<>();
		for(int i = 1; i < 10; i++)
			list.add(i);
		list.display();
		reverse.reverse(list, null, list.head);
		list.display();
	}
}

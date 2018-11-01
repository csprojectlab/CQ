package linkedlist.circularlinkedlist;

/*
 * If there are odd number of nodes, then first list should contain one extra.
 */
public class SplitIntoTwoHalves {

	public void printUtil(Node head) {		
		Node start = head.next;
		Node current = start;
		do {
			System.out.print(current + " ");
			current = current.next;
		} while (current != start);
		System.out.println();
	}
	
	public void split(CircularLinkedList list) {
		if(list.head == null)
			return;
		// Initialize from the starting node.
		Node fastPointer = list.head.next;
		Node slowPointer = list.head.next;
		Node start = list.head.next;
		// Even and odd number of elements.
		while(fastPointer.next != start && fastPointer.next.next != start) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		fastPointer = list.head;   // Pointing to the last node.
		Node head1 = slowPointer;
		Node head2 = null;
		// If there is only one element in the list.
		if(list.head.next != list.head)
			head2 = fastPointer;
		// Make second half circular.
		fastPointer.next = slowPointer.next;
		slowPointer.next = start;
		this.printUtil(head1);
		this.printUtil(head2);
	}
	
	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		for(int i = 1; i <= 6; i++)
			list.addLast(i);
		System.out.println("Original list");
		list.display();
		SplitIntoTwoHalves s = new SplitIntoTwoHalves();
		s.split(list);
	}
}

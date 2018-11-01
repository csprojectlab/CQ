package linkedlist.circularlinkedlist;

public class SortedInsert {

	public void insertInSorted(CircularLinkedList list, int data) {
		Node node = new Node(data);
		if(list.head == null) {  // Empty list.
			node.next = node;
			list.head = node;
		} else if(data >= list.head.next.data) {   // Data is greater than start.
			// Find it's position.
			Node current = list.head.next;
			Node prev = null;
			while(data >= current.data) {
				if(current == list.head) {
					list.addLast(data);
					return;
				}
				prev = current;
				current = current.next;
			}
			node.next = current;
			prev.next = node;			
		} else {    // Data is less than the start. Insert in beginning.
			list.addFirst(data);
		}
	}
	
	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		list.addLast(3);
		list.addLast(5);
		list.addLast(7);
		list.addLast(9);
		list.display();
		SortedInsert s = new SortedInsert();
		s.insertInSorted(list, 8);
		list.display();
		
	}
}

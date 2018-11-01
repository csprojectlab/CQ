package linkedlist;
/*
 * Linked list is sorted in non-decreasing order
 */
public class RemoveDuplicatesFromLinkedList<T> {

	public Node<T> removeDuplicates(Node<T> head) {
		Node<T> current = head;
		while(current.next != null) {
			if(current.data.equals(current.next.data)) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		Node<T> node = head;
		while(node != null) {
			System.out.print(node + " ");
			node = node.next;
		}
		return head;
	}
	
	public Node<T> removeDuplicatesRecursive(Node<T> node) {
		if(node == null)
			return null;
		if(node.next == null)
			return node;
		if(node.data.equals(node.next.data)) {
			node.next = node.next.next;
			return this.removeDuplicatesRecursive(node);
		} else {
			node.next = this.removeDuplicatesRecursive(node.next);
			return node;
		}
	}
	
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		RemoveDuplicatesFromLinkedList<Integer> rd = new RemoveDuplicatesFromLinkedList<>();
		list.add(11);
		list.add(11);
		list.add(11);
		list.add(12);
		list.add(12);
		list.add(24);
		list.add(34);
		list.display();
//		rd.removeDuplicates(list.head);
		Node<Integer> node = rd.removeDuplicatesRecursive(list.head);
		rd.removeDuplicatesRecursive(node);
		list.display();
	}
	
}

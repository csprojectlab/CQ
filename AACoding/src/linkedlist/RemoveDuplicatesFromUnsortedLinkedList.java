package linkedlist;

import java.util.HashSet;
import java.util.Set;

/*
 * Merge sort is best suited for linked lists.
 */
public class RemoveDuplicatesFromUnsortedLinkedList<T> {

	private Set<T> set;
	
	public RemoveDuplicatesFromUnsortedLinkedList() {
		this.set = new HashSet<>();
	}
	
	public Node<T> removeDuplicates(Node<T> node) {
		if(node == null)
			return null;
		if(node.next == null)
			return node;
		if(this.set.contains(node.data)) {
			node.next = node.next.next;
			return this.removeDuplicates(node);
		} else {
			this.set.add(node.data);   // Hashing.
			node.next = this.removeDuplicates(node.next);
			return node;
		}
		
	}
}

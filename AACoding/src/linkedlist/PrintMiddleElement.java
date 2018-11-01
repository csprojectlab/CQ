package linkedlist;
/*
 * If there are even nodes, then there would be two middle nodes, we need to print second middle element.
 *  For example, if given linked list is 1->2->3->4->5->6 then output should be 4.
 */

public class PrintMiddleElement<T> {

	/*
	 * Incrementing the pointer by two.
	 */
	public Node<T> middleElement(Node<T> head) {
		Node<T> fastPointer = head;
		Node<T> slowPointer = head;
		while(fastPointer.next != null) {   // Reaching the last node.
			slowPointer = slowPointer.next;
			// If it is second last node.
			if(fastPointer.next.next == null)   // For handling the even case. Odd is being held by the loop.
				break;
			fastPointer = fastPointer.next.next;
		}
		System.out.println(slowPointer);
		return slowPointer;
	}
	
	public static void main(String[] args) {
		PrintMiddleElement<Integer> p = new PrintMiddleElement<>();
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 1; i <= 13; i++)
			list.add(i);
		p.middleElement(list.head);
	}
	
}

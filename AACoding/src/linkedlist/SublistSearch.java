package linkedlist;
/*
 * Input  : list1 =  10->20
         list2  = 5->10->20
Output : LIST FOUND

Input  : list1 =  1->2->3->4
         list2  = 1->2->1->2->3->4
Output : LIST FOUND

Input  : list1 =  1->2->3->4
         list2  = 1->2->2->1->2->3
Output : LIST NOT FOUND
 */
public class SublistSearch {

	public void search(Node<Integer> head1, Node<Integer> head2) {
		Node<Integer> ptr1 = head1;
		Node<Integer> ptr2 = head2;
		// Pre-conditions
		if(ptr1 == null && ptr2 == null) {
			System.out.println("Empty lists");
			return;
		}
		if(ptr1 == null || (ptr2 == null)) {
			System.out.println("One of the two list is empty.");
			return;
		}
		// Traverse the second list by taking elements one by one.
		while(head2 != null) {
			ptr2 = head2;   // Current node of second.
			while(ptr1 != null) {
				if(ptr2 == null) {
					System.out.println("List Not Found");
					return;
				} else if(ptr1.data.equals(ptr2.data)) {
					ptr1 = ptr1.next;
					ptr2 = ptr2.next;
				} else break;
			}
			if(ptr1 == null) {
				System.out.println("List found");
				return;
			}
			ptr1 = head1;
			head2 = head2.next;
		}		
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		list1.add(10);
		list1.add(20);
		list2.add(12);
		list2.add(10);
		list2.add(20);
		SublistSearch s = new SublistSearch();
		s.search(list1.head, list2.head);
		
	}
}

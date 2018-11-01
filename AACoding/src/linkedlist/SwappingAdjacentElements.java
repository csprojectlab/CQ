package linkedlist;

public class SwappingAdjacentElements<T> {

	public void swap(Node<T> first, Node<T> second) {
		T temp = first.data;
		first.data = second.data;
		second.data = temp;
	}
	
	public void swapAdjacent(Node<T> node) {
		// Handles the case of list containing odd number of elements.
		if(node != null && node.next != null) {
			// Swap node and node.next
			this.swap(node, node.next);
			this.swapAdjacent(node.next.next);
		}
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 1; i <= 6; i++)
			list.add(i);
		list.display();
		SwappingAdjacentElements<Integer> s = new SwappingAdjacentElements<>();
		s.swapAdjacent(list.head);
		list.display();
	}
}

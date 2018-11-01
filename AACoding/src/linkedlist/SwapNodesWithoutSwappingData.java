package linkedlist;

public class SwapNodesWithoutSwappingData<T> {

	public void swapNodes(LinkedList<T> list, int x, int y) {
		if(list.head == null)
			return;
		Node<T> xNode = null;
		Node<T> yNode = null;
		Node<T> temp = list.head;
		Node<T> prev = null;
		Node<T> xPrev = null;
		Node<T> yPrev = null;
		while(temp != null) {
			if(temp.data.equals(x)) {
				xNode = temp;
				xPrev = prev;
			}
			if(temp.data.equals(y)) {
				yNode = temp;
				yPrev = prev;
			}
			prev = temp;
			temp = temp.next;
		}
		if(xNode == null || yNode == null)   // If any of the one node is not present.
			return;
		// Checking if the nodes are head or not.
		if(xPrev == null)   // x is the head of the linked list
			list.head = yNode;
		else
			xPrev.next = yNode;
		if(yPrev == null)
			list.head = xNode;
		else
			yPrev.next = xNode;
		// Swapping the nodes
		temp = xNode.next;
		xNode.next = yNode.next;
		yNode.next = temp;
		list.display();
		
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 1; i < 11; i++)
			list.add(i);
		list.display();
		SwapNodesWithoutSwappingData<Integer> s = new SwapNodesWithoutSwappingData<>();
		s.swapNodes(list, 1, 7);
	}
}

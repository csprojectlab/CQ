package linkedlist;

public class NthNodeInLinkedList<T> {

	public Node<T> getNthNode(Node<T> node, int N) {
		if(N == 0)
			return node;
		else if(node == null)
			return null;
		else 
			return this.getNthNode(node.next, N-1);
	}
	
}

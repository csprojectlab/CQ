package linkedlist.unrolled;

class Node<T> {
	int index;
	T[] elements;
	Node<T> next;
	@SuppressWarnings("unchecked")
	public Node() {
		this.index = 0;
		this.elements = (T[])new Object[UnrolledLinkedList.DEFAULT_SIZE];
	}
	
	public boolean addElement(T data) {
		if(this.index == UnrolledLinkedList.DEFAULT_SIZE)
			return false;      // Cannot add data to this node.
		this.elements[index] = data;
		index++;     // Point to the next storage location.
		return true;   // Element added.
	}
	
}

public class UnrolledLinkedList<T> {
	public static final int DEFAULT_SIZE = 3;
	Node<T> root;
	public UnrolledLinkedList() {
		this.root = null;
	}
	
	public void addLast(T data) {
		if(this.root == null) {
			Node<T> node = new Node<T>();
			node.addElement(data);
			node.next = null;
			this.root = node;
		} else {
			// Find the last node.
			Node<T> current = this.root;
			while(current != null) {
				if(current.addElement(data)) {
					break;
				}  // Add to an existing node.
				else if(current.next == null){   // Create a new one.
					Node<T> node = new Node<T>();
					node.addElement(data);
					node.next = null;
					current.next = node;   // Attach it to the list.
					break;
				}
				current = current.next;
			}			
		}
	}
	
	public void display() {
		if(this.root == null)
			return;
		Node<T> current = this.root;
		while(current != null) {
			System.out.print("| ");
			for(int i = 0; i < current.index; i++)
				System.out.print(current.elements[i] +" ");
			System.out.print((current.next == null) ? "|" : "|-->");
			current = current.next;
		}
	}
	
	public static void main(String[] args) {
		UnrolledLinkedList<Integer> list = new UnrolledLinkedList<Integer>();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		list.display();
	}
}

package linkedlist.circularlinkedlist;

class Node {
	int data;
	Node next;
	public Node() {} 
	public Node(int data) {
		this(data, null);
	}
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
	public String toString() {
		return "[" + data + "]";
	}
}
/*
 * We choose the last node as our head node.
 */
public class CircularLinkedList {
	Node head;
	public CircularLinkedList() {
		this.head = null;
	}
	
	public void addLast(int data) {
		Node node = new Node(data);
		if(this.head == null) {   // Empty list.
			node.next = node;
			this.head = node;
		} else {
			node.next = this.head.next;
			this.head.next = node;
			this.head = node;
		}
	}
	
	public void addFirst(int data) {
		Node node = new Node(data);
		if(this.head == null) {
			node.next = node;
			this.head = node;
		} else {
			node.next = this.head.next;
			this.head.next = node;
		}
	}
	
	public void addAfter(int val, int data) {
		if(this.head == null)
			return;
		Node start = this.head.next;   // This is the start of the list.
		Node current = start;
		while(current.data != val) {
			if(current.next == start) {
				System.out.println("Value not found in the list.");
				return;
			}
			current = current.next;
		}
		if(current == this.head) {   // Insertion is supposed to be at the last.
			this.addLast(data);
		} else {
			Node node = new Node(data);
			node.next = current.next;
			current.next = node;
		}
	}
	
	public void delete(int data) {
		if(this.head == null)
			return;   // Empty list.
		// Find the required node.
		Node current = this.head.next;
		Node prev = null;
		while(current.data != data) {
			if(current.next == this.head.next)   // reaching the start again
				return;   // data not found to be deleted.
			prev = current;
			current = current.next;
		}
		if(prev == null) {   // Data to be deleted is the start.
			this.head.next = this.head.next.next;
		} else if(current == this.head) {   // To be deleted is the last node.
			prev.next = this.head.next;
			this.head = prev;
		} else {
			prev.next = current.next;
		}
		
	}
	
	public void display() {
		 Node start = this.head.next;  // Because head points to the last node.
		 Node current = start;
		 do {
			System.out.print(current);
			if(current.next != start)
				System.out.print("-->");
			current = current.next;
		} while (current != start);
		System.out.println();
	}
	
	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		for(int i = 1; i <= 6; i++)
			list.addLast(i);
		list.display();
		list.addFirst(0);
		list.display();
		list.addAfter(6, -1);
		list.display();
		//--------------- Deleting.
		list.delete(3);
		list.display();
	}
	
}

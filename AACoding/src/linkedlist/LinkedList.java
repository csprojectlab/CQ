package linkedlist;

class Node<T> {
	T data;
	Node<T> next;
	public Node() {}
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
	public String toString() {
		return "{" + this.data + "}";
	}
}

public class LinkedList<T> {
	Node<T> head;
	int size;
	public LinkedList() {
		this.head = null;
		this.size = 0;
	}
	
	/*
	 * Adding the element to the last of the list.
	 */
	public void addLast(T value) {
		Node<T> node = new Node<T>(value, null);
		if(this.head == null) {
			this.head = node;
		} else {
			Node<T> current = this.head;
			while(current.next != null)
				current = current.next;
			current.next = node;
		}
		this.size++;
	}
	
	/*
	 * It adds the value to the last of the list.
	 */
	public void add(T value) {
		this.addLast(value);
	}
	
	public void addFirst(T value) {
		Node<T> node = new Node<T>(value, null);
		if(this.head == null)
			this.head = node;
		else {
			node.next = head;
			this.head = node;
		}
		this.size++;
	}
	
	public int indexOf(T value) {
		if(this.head == null)
			return -1;
		Node<T> current = this.head;
		int count = 0;
		while(current != null) {
			count++;
			if(current.data.equals(value))
				break;
			current = current.next;
		}		
		return (current == null) ? -1 : count;	   // List is searched to last.	
	}
	
	/*
	 * Add after a given index.
	 */
	public void addAfter(int i, T value) {
		if(this.head == null || i <= 0 || i > size)
			return;
		int count = 1;   // We don't start from zero as we start current value from head.
		Node<T> current = this.head;
		while(count != i) {
			count++;
			current = current.next;
		}
		Node<T> node = new Node<T>(value, null);
		node.next = current.next;
		current.next = node;
		this.size++;
	}
	
	/*
	 * Add after a specified value.
	 */
	public void addAfter(T prev, T value) {
		if(this.head == null)
			return;
		int index = this.indexOf(prev);
		if(index != -1) 
			this.addAfter(index, value);
	}
	
	public void deleteFirst() {
		if(this.head == null)
			return;
		this.head = this.head.next;
		size--;
	}
	
	public void deleteLast() {
		if(this.head == null)
			return;
		if(this.head.next == null)   // Only one element.
			this.head = null;
		else {
			Node<T> current = this.head;
			while(current.next.next != null)
				current = current.next;
			current.next = null;
		}
		size--;
	}
	
	/*
	 * Deletes value at the i'th index.
	 */
	public void delete(int i) {
		if(this.head == null || i <= 0 || i > size)
			return;
		if(i == 1)
			this.deleteFirst();
		else if(i == this.size)
			this.deleteLast();
		else {
			int count = 1;
			Node<T> current = this.head;    // Will point to the node at the i'th index.[to be deleted]
			Node<T> prev = null;   // Previous to the current node.
			while(count != i) {
				count++;
				prev = current;
				current = current.next;
			}
			prev.next = current.next;
			this.size--;
		}
	}
	
	/*
	 * Delete the specified value.
	 */
	public void delete(T value) {
		if(this.head == null)
			return;
		int index = this.indexOf(value);
		if(index != -1)
			this.delete(index);		
	}
	
	/*
	 * Display the linked list.
	 */
	public void display() {
		Node<T> current = this.head;
		while(current != null) {
			System.out.print(current);
			if(current.next != null)
				System.out.print("-->");
			current = current.next;
		}
		System.out.println();
	}
	
	/*
	 * (non-Javadoc)   It returns the value in the head of the list.
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.head.toString();
	}
	
	
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("Aridaman");
		list.addFirst("Rishu");
		list.addLast("Vikas");
		list.addFirst("Shobbit");
		list.display();
		list.addAfter("Rishu", "Rohit");
		list.addAfter(list.size, "I am Last");
		list.display();
		list.delete("Aridaman");
		list.delete("Vikas");
		list.delete("Shobbit");
		list.display();
		
		LinkedList<Integer> intList = new LinkedList<Integer>();
		intList.add(1);
		intList.add(2);
		intList.display();
	}
}

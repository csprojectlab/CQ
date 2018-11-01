package linkedlist;

import java.util.Stack;

public class PalindromeLinkedList<T> {
	
	public Node<T> left = null;
	
	public boolean isPalindrome(Node<T> head) {
		Stack<Node<T>> stack = new Stack<>();
		Node<T> temp = head;
		while(head != null) {
			stack.push(head);
			head = head.next;
		}
		head = temp;
		while(temp != null) {
			if(!stack.pop().data.equals(temp.data))
				return false;
			temp = temp.next;
		}
		return true;
	}
	
	public boolean isPalindromeRecUtil(Node<T> right) {
		if(right == null)
			return true;
		boolean ans = this.isPalindromeRecUtil(right.next);
		if(ans == false)
			return false;
		ans = (left.data.equals(right.data));
		left = left.next;
		return ans;
	}
	
	public boolean isPalindromeRecursive(Node<T> head) {
		this.left = head;
		return this.isPalindromeRecUtil(left);
	}
	
	public static void main(String[] args) {
		LinkedList<Character> list = new LinkedList<>();
		list.add('r');
		list.add('a');
		list.add('d');
		list.add('a');
		list.add('r');
		PalindromeLinkedList<Character> p = new PalindromeLinkedList<>();
		System.out.println(p.isPalindrome(list.head));
		System.out.println(p.isPalindromeRecursive(list.head));
	}
	
}

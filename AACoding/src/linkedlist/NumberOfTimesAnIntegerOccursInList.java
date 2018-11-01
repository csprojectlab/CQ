package linkedlist;

public class NumberOfTimesAnIntegerOccursInList {

	public int countFreq(Node<Integer> node, int key) {
		if(node == null)
			return 0;
		else if((int)node.data == key)
			return 1 + this.countFreq(node.next, key);
		else
			return this.countFreq(node.next, key);
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = 1; i <= 12; i++)
			list.add(4);
		NumberOfTimesAnIntegerOccursInList n = new NumberOfTimesAnIntegerOccursInList();
		System.out.println(n.countFreq(list.head, 4));
	}
}

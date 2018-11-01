package trees;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfNodesAtALevelWithTreeAsString{
	Node root;
	int index;
	int level;
	int sum;
	public SumOfNodesAtALevelWithTreeAsString() {
		super();
		this.root = null;
		this.index = 0;
		this.level = 0;
		this.sum = 0;
	}

	public Node buildTree(String string) {
		Node node = null;
		if(string.charAt(index) == '(') {  // A new node is starting.
			index++;
			if(!(string.charAt(index) == ')'))
			   node = new Node(Integer.parseInt(string.charAt(index) + ""), null, null);  // Node with data only.
			else 
				return null;
			index++;
			node.left = this.buildTree(string);
			index++;
			node.right = this.buildTree(string);
			index++;
		}
		return node;
	}
	
	public void display(Node node) {
		if (node.left != null)
			System.out.print(node.left.data + " => ");
		else
			System.out.print("END=> ");
		System.out.print(node.data + " ");
		if (node.right != null)
			System.out.print("<= " + node.right.data);
		else
			System.out.print("<=END");
		System.out.println();
		if (node.left != null)
			display(node.left);
		if (node.right != null)
			display(node.right);
	}
	
	// Level starts from 1.
	public int sumOfNodesAtALevel(int level) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(this.root);
		int currentLevel = 0;
		int sum = 0;
		while(!queue.isEmpty()) {
			if(currentLevel > level)
				break;
			currentLevel++;
			int size = queue.size();
			while(size-- > 0) {
				Node node = queue.remove();
				if(currentLevel == level)
					sum += node.data;
				if(node.left != null)
					queue.add(node.left);
				if(node.right != null)
					queue.add(node.right);
			}
		}
		return sum;
	}
	
	public void sumAtLevelUsingStringTree(String str, int level) {
		if(this.index >= str.length())
			return;
		if(str.charAt(index) == '(') {
			this.level++;
		}
		else if(str.charAt(index) == ')')
			this.level--;
		else {
			if(this.level == level)
				sum += Integer.parseInt(str.charAt(this.index) + "");
		}
		this.index++;
		this.sumAtLevelUsingStringTree(str, level);		
	}
	
	// We can get the sum either by building a tree or by using the string data.
	public static void main(String[] args) {
		SumOfNodesAtALevelWithTreeAsString t = new SumOfNodesAtALevelWithTreeAsString();
		String s = "(0(1()())(2()()))";
		String s2 = "(0(5(6()())(4()(9()())))(7(1()())(3()())))";
		t.root = t.buildTree(s2);
		t.display(t.root);
		System.out.println("Sum of level 2: " + t.sumOfNodesAtALevel(2));
		
		t.index = 0;  // We use this again to loop the string.
		t.level = 0;
		t.sumAtLevelUsingStringTree(s, 2);
		System.out.println("Sum of level 2: " + t.sum);
	}
	
	

}

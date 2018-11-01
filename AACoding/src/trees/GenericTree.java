package trees;

import java.util.ArrayList;
import java.util.List;

class GenericNode {
	int data;
	List<GenericNode> children;
	public GenericNode() {
		this(0);
	}
	public GenericNode(int data) {
		this.data = data;
		this.children = new ArrayList<GenericNode>();
	}
}

public class GenericTree {
	GenericNode root;
	int size;
	public GenericTree() {
		this.root = new GenericNode();
		this.size = 0;
	}
	
	public void display(GenericNode node) {
		System.out.print(node.data + " => ");
		for(GenericNode n : node.children)
			System.out.print(n.data + " ");
		System.out.println();
		for(GenericNode n : node.children)
			this.display(n);		
	}
	
	public static void main(String[] args) {
		GenericTree t = new GenericTree();
		
	}
	
}

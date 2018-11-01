package trees;

public class ReplaceWithSumOfPredAndSucc extends BinaryTree {
	int arr[];
	int index;
	public ReplaceWithSumOfPredAndSucc() {
		super();
		this.arr = new int[20];  // to accommodate beginning and trailing zero.
		this.index = 1;  // Left most node of the tree will be at this index.
	}
	
	public void replaceWithSumInorder(Node node) {
		if(node.left != null)
			this.replaceWithSumInorder(node.left);
		node.data = this.arr[this.index - 1] + this.arr[this.index + 1];
		this.index++;
		if(node.right != null)
			this.replaceWithSumInorder(node.right);
	}
	
	public void storeInorder(Node node) {
		if(node.left != null) 
			this.storeInorder(node.left);
		this.arr[this.index++] = node.data;
		if(node.right != null)
			this.storeInorder(node.right);
	}
	
	public static void main(String[] args) {
//		1 true 2 true 4 false false true 5 false false true 3 true 6 false false true 7 false false
		ReplaceWithSumOfPredAndSucc t = new ReplaceWithSumOfPredAndSucc();
		t.display(t.root);
		t.storeInorder(t.root);
		System.out.println("Inorder Traversal: ");
		for(int i = 1; i < t.index; i++)
			System.out.print(t.arr[i] + " ");
		
		System.out.println();
		t.index = 1;
		
		t.replaceWithSumInorder(t.root);
		t.display(t.root);
	}
	
	
	

}
